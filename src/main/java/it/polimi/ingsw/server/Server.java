package it.polimi.ingsw.server;


import it.polimi.ingsw.listener.PropertyObserver;
import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.enumerations.Wizard;
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
    private Map<String, ClientConnection> playingConnection = new HashMap<>();
    private LinkedList<SocketClientConnection> socketConnections=new LinkedList<>();
    private Integer numberOfPlayer=128;
    private Boolean gameMode; // true for expert mode, false for normal one
    private PropertyObserver propertyObserver;
    private Game game;

    //Deregister connection
    public synchronized void deregisterConnection(SocketClientConnection c) {
        ClientConnection opponent = playingConnection.get(c);
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


    public synchronized void lobby(SocketClientConnection c, String name) throws IOException, ClassNotFoundException {
        List<String> keys = new ArrayList<>(waitingConnection.keySet());
        System.out.println("New client " + name);
        waitingConnection.put(name, c);
        if (waitingConnection.size() == 1) {
            c.send("You are the first player");
            decideNumberOfPlayersAndGameMode(c);
        }
        c.send("waiting for other players");
        keys = new ArrayList<>(waitingConnection.keySet());
        //System.out.println(waitingConnection.size());
        if (waitingConnection.size() == numberOfPlayer) {
            for (SocketClientConnection d : waitingConnection.values())
                d.send("Players arrived, starting game..");

            //System.out.println("dentro");
            SocketClientConnection c1 = waitingConnection.get(keys.get(0));
            SocketClientConnection c2 = waitingConnection.get(keys.get(1));

            Player player1 = new Player(c1.getName());
            players.add(player1);
            Player player2 = new Player(c2.getName());
            players.add(player2);
            if (waitingConnection.size() == 3) {
                SocketClientConnection c3 = waitingConnection.get(keys.get(2));
                Player player3 = new Player(c3.getName());
                players.add(player3);
            }
            System.out.println(players);

            //playingConnection.put(c1, c2);
            //playingConnection.put(c2, c1);

             game = new Game();
            propertyObserver=new PropertyObserver(game,this);
            game.addListener(propertyObserver);
             executor.submit(new Thread() {
                                 public void run() {

                                     game.setPlayerList(players);
                                     game.inizializeGame();
                                 }

                             });

            c1.asyncSend(game);
            c2.asyncSend(game);
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


    public Server() throws IOException {
        this.serverSocket = new ServerSocket(PORT);
    }

    public void run(){
        int connections = 0;
        System.out.println("Server is running");
        while(true){
            try {
                Socket newSocket = serverSocket.accept();
                connections++;
                System.out.println("Ready for the new connection - " + connections);
                SocketClientConnection socketConnection = new SocketClientConnection(newSocket, this);
                socketConnections.add(socketConnection);
                executor.submit(socketConnection);
            } catch (IOException e) {
                System.out.println("Connection Error!");
            }
        }
    }


    public Boolean equalName(String username) {
        for (int i =0;i<socketConnections.size()-1;i++) {
            if (socketConnections.get(i).getName().equals(username))
                return true;
        }
        return false;
    }

    public void decideNumberOfPlayersAndGameMode(SocketClientConnection c) throws IOException, ClassNotFoundException {
        c.send("Decide the number of players, 2 or 3 ");
        String message=(String) c.getIn().readObject();
        while(!(message.equals("2") || message.equals("3"))) {
            c.send("You must select 2 or 3 ->");
            message=(String) c.getIn().readObject(); // Read user input
        }
        numberOfPlayer= Integer.valueOf(message);
        System.out.println("number of players selected "+ numberOfPlayer);

        c.send("Decide the gameMode, 1for expert and 0 for normal");
        message=(String) c.getIn().readObject(); // Read user input

        while(!(message.equals("0") || message.equals("1"))) {
            c.send("You must select 0 or 1 ");
            message=(String) c.getIn().readObject(); // Read user input
        }
        if(message.equals("1"))
            gameMode=true;
        else
            gameMode=false;
        System.out.println("Game mode selected  " + gameMode);

    }

    public void sendGame(){
        for( ClientConnection c: playingConnection.values())
        c.asyncSend(game);
    }

    public Game getGame(){
        return game;
    }

    public void modifyGame(Object object){
        new Thread() {
            public void run() {
                synchronized (game) {
                    game.chooseColorAndDeck(PlayerColor.WHITE, Wizard.PURPLE_WIZARD);
                }
            }
        }.start();
    }
}


