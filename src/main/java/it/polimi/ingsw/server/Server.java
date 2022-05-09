package it.polimi.ingsw.server;


import it.polimi.ingsw.listener.PropertyObserver;
import it.polimi.ingsw.message.MessageMethod;
import it.polimi.ingsw.message.SetUp;
import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.player.Player;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private LinkedList<Player> players=new LinkedList<>();
    private static final int PORT = 12345;
    private ServerSocket serverSocket;
    private ExecutorService executor = Executors.newFixedThreadPool(128);
    private Map<String, SocketClientConnection> waitingConnection = new HashMap<>();
    private Map<String, SocketClientConnection> playingConnection = new HashMap<>();
    private LinkedList<SocketClientConnection> socketConnections = new LinkedList<>();
    private Integer numberOfPlayer = 128;
    private Boolean gameMode; // true for expert mode, false for normal one
    private PropertyObserver propertyObserver;
    private Game game;
    private SetUp setup = new SetUp();


    /**
     * deregister connection
     * @param c
     */
    public synchronized void deregisterConnection(SocketClientConnection c) {
        SocketClientConnection opponent = playingConnection.get(c);
        if(opponent != null) {
            opponent.closeConnection();
        }
        playingConnection.remove(c);
        playingConnection.remove(opponent);
        Iterator<String> iterator = waitingConnection.keySet().iterator();
        while(iterator.hasNext()){
            if(waitingConnection.get(iterator.next())==c){
                iterator.remove();
            }
        }
    }

    /**
     *
     * @param c         The socketConnection which is currently running
     * @param name         The name of the player
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws InterruptedException     Thrown when the modifyGame doesn't end
     */
    public synchronized void lobby(SocketClientConnection c, String name) throws IOException, ClassNotFoundException, InterruptedException {

        List<String> keys = new ArrayList<>(waitingConnection.keySet());
        System.out.println("New client " + name);
        waitingConnection.put(name, c);
        if (waitingConnection.size()==1) {
            c.send("You are the first player");

            decideNumberOfPlayersAndGameMode(c);
        }
        c.send("waiting for other players");
        keys = new ArrayList<>(waitingConnection.keySet());

        if (waitingConnection.size()==numberOfPlayer) {
            System.out.println(waitingConnection.size() +" "+ numberOfPlayer);
            for (SocketClientConnection d : waitingConnection.values())
                d.send("Players arrived, starting game..");

            //System.out.println("dentro");
            SocketClientConnection c1 = waitingConnection.get(keys.get(0));
            SocketClientConnection c2 = waitingConnection.get(keys.get(1));

            Player player1 = new Player(c1.getName());
            players.add(player1);
            Player player2 = new Player(c2.getName());
            players.add(player2);
            if (waitingConnection.size()==3) {
                SocketClientConnection c3 = waitingConnection.get(keys.get(2));
                Player player3 = new Player(c3.getName());
                players.add(player3);
            }
            game = new Game();
            propertyObserver=new PropertyObserver(game,this);
            game.addListener(propertyObserver);
            //System.out.println(game.getCurrentPlayer().getName());
            //System.out.println(game.getPlayerList());
            Thread t1=new Thread( modifyGame(game));
            t1.join();
            //c2.asyncSend(game);
            //c1.asyncSend(game);

            //System.out.println(game.getCurrentPlayer());

            playingConnection.putAll(waitingConnection);
            waitingConnection.clear();

            //c1.asyncSend(model.getBoardCopy());
            //c2.asyncSend(model.getBoardCopy());
            //if(model.getBoardCopy().)
            // if(model.isPlayerTurn(player1)){
            //   c1.asyncSend(gameMessage.moveMessage);
            // c2.asyncSend(gameMessage.waitMessage);
            //} else {
            //  c2.asyncSend(gameMessage.moveMessage);
            //c1.asyncSend(gameMessage.waitMessage);
        }
    }

    /**
     *
     * @throws IOException
     */
    public Server() throws IOException {
        this.serverSocket = new ServerSocket(PORT);
    }

    /**
     *
     */
    public void run(){
        int connections = 0;
        System.out.println("Server is running");
        while(!Thread.currentThread().isInterrupted() ){ //Abbiamo un problema che il client si disconnetete se tutte due si connetono insieme e scrive il secondo client
            try {

                Socket newSocket = serverSocket.accept();
                connections++;
                System.out.println("Ready for the new connection - " + connections);
                SocketClientConnection socketConnection = new SocketClientConnection(newSocket, this);
                socketConnections.add(socketConnection);
                Thread t0 = new Thread(socketConnection);

                  t0.start();

            } catch (IOException e) {
                System.out.println("Connection Error!");
            }
        }
    }

    /**
     *
     * @param username  The name of the player who is calling this method
     * @return  boolean     True if the name is not already chosen, false instead
     */
    public Boolean equalName(String username) {
        for (int i =0;i<socketConnections.size()-1;i++) {
            if (socketConnections.get(i).getName().equals(username))
                return true;
        }
        return false;
    }

    /**
     *
     * @param c         The socketConnection which is the first player
     * @throws IOException  Thrown if occurs problems with the socket
     * @throws ClassNotFoundException
     */
    public void decideNumberOfPlayersAndGameMode(SocketClientConnection c) throws IOException, ClassNotFoundException {
        c.send("Decide the number of players, 2 or 3 ");
        c.send(setup);
        String message = (String) c.getIn().readObject();
        while(!(message.equals("2") || message.equals("3"))) {
            c.send("You must select 2 or 3 ->");
            c.send(setup);
            message = (String) c.getIn().readObject(); // Read user input
        }
        numberOfPlayer= Integer.valueOf(message);
        System.out.println("number of players selected "+ numberOfPlayer);

        c.send("Decide the gameMode, 1 for expert and 0 for normal");
        c.send(setup);
        message = (String) c.getIn().readObject(); // Read user input

        while(!(message.equals("0") || message.equals("1"))) {
            c.send("You must select 0 or 1 ");
            c.send(setup);
            message = (String) c.getIn().readObject(); // Read user input
        }

        if(message.equals("1"))
            gameMode = true;
        else
            gameMode = false;

        System.out.println("Game mode selected  " + gameMode);

    }

    /**
     * This method is called from observer, after its modified we sent the game to the client
     */
    public void sendGame(){
        System.out.println("Invio il gioco da server");
        synchronized (this) {
            for (SocketClientConnection c : playingConnection.values()) {
                c.send(game);
            }
        }
    }

    /**
     *
     * @return  game    The reference to the game
     */
    public Game getGame(){ return this.game; }

    /**
     * Synchronized the modifying in game with the other threads
     * @param object
     * @return
     */
    public Thread modifyGame(Object object){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                if(object instanceof Game) {
                    //Dovremmo mettere un messaggio per fare questa azione
                    game.setPlayerList(players);
                    game.initializeGame();
                    sendGame();
                }
                if (object instanceof MessageMethod) {
                   ((MessageMethod) object).apply(game);
                }
            }
        });
        t.start();
        return t;
    }

}


