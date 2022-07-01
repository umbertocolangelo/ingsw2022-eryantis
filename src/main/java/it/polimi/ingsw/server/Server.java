package it.polimi.ingsw.server;


import it.polimi.ingsw.listener.PropertyObserver;
import it.polimi.ingsw.message.*;
import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.utils.SavingManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.*;
import java.util.concurrent.Semaphore;

public class Server {

    /**
     * Keep the reference to the players
     */
    private LinkedList<Player> players = new LinkedList<>();

    /**
     * Port for local connection
     */
    private static final int PORT = 65432;

    /**
     * Keep the reference to the socket
     */
    private ServerSocket serverSocket;

    /**
     * Keep the reference to the connection that are waiting in the lobby
     */
    private LinkedList<SocketClientConnection> waitingConnection = new LinkedList<>();

    /**
     * Keep the reference to the connection that are playing
     */
    private LinkedList<SocketClientConnection> playingConnection = new LinkedList<>();

    /**
     * Keep the reference to each socket the server accept
     */
    private LinkedList<SocketClientConnection> socketConnections = new LinkedList<>();

    /**
     * Keep the reference to the number of Player
     */
    private Integer numberOfPlayer = 0;

    /**
     * Keep the reference to the GameMode
     */
    private Boolean gameMode; // true for expert mode, false for normal one

    /**
     * Keep the refernce to the Observer
     */
    private PropertyObserver propertyObserver;

    /**
     * Keep the reference to Game
     */
    private Game game;

    /**
     * Reference to the setUp message
     */
    private SetUp setup = new SetUp();

    /**
     * Reference to the semaphore
     */
    private Semaphore semaphore = new Semaphore(1);

    /**
     * Holds the loaded instance of Game if present
     */
    private Game loadedGame;

    /**
     * Default constructor
     * @throws IOException
     */
    public Server() throws IOException {
        this.serverSocket = new ServerSocket(PORT);
    }

    /**
     * This method handles the connection differently if we are in game or waiting in lobby
     * @param c the connection that has to be shutdown
     */
    public synchronized void deregisterConnection(SocketClientConnection c) {
        c.setHasBeenDisconnected(true);
        socketConnections.remove(c);
        if (!playingConnection.isEmpty() && !c.getPlayerIsPlus()) {
            for (SocketClientConnection clientConnection : playingConnection) {
                clientConnection.send(new ClientLost(c.getName()));
            }
        } else {
            if (waitingConnection.contains(c)) {
                waitingConnection.remove(c);
            }
          if (numberOfPlayer==0 && !socketConnections.isEmpty()) {
                Boolean thereIsAFirst = false;
                //Check if there is a player that already received a first and in this case do not set a new first
                for (SocketClientConnection d: socketConnections) {
                    if (d.getIsFirst()) {
                        thereIsAFirst = true;
                    }
                }
                if (!thereIsAFirst) {
                    socketConnections.getFirst().setIsFirst();
                    socketConnections.getFirst().send(new IsFirst());
                }
            }
        }
    }

    /**
     * The connection try to create a game, if we have the number of connection equal to the number of player we create a game
     * @param c         The socketConnection which is currently running
     * @param name         The name of the player
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws InterruptedException     Thrown when the modifyGame doesn't end
     */
    public synchronized void lobby(SocketClientConnection c, String name)
            throws IOException, ClassNotFoundException, InterruptedException {

        if (name!=null) {
            waitingConnection.add(c);
            System.out.println("New client");
            if (semaphore.availablePermits() == 0) {
                semaphore.release();
            }
            if (!playingConnection.isEmpty()) {
                c.setPlayerIsPlus(true);
                c.close();
                return;
            }

        //We enter here only if we need to set again the message isFirst
        }else if (waitingConnection.size()>numberOfPlayer) {
            while (waitingConnection.size()>numberOfPlayer) {
                waitingConnection.getLast().setPlayerIsPlus(true);
                waitingConnection.getLast().close();
            }
        }

        //If socket enter here we start the game, switching from waiting connection to playing connection
        if (waitingConnection.size()==numberOfPlayer) {
            SocketClientConnection c1 = waitingConnection.get(0);
            SocketClientConnection c2 = waitingConnection.get(1);

            Player player1 = new Player(c1.getName());
            players.add(player1);
            Player player2 = new Player(c2.getName());
            players.add(player2);

            if (waitingConnection.size()==3) {
                SocketClientConnection c3 = waitingConnection.get(2);
                Player player3 = new Player(c3.getName());
                players.add(player3);
            }

            // check if there is a matching game saved
            LinkedList<String> playerNames = new LinkedList<String>();
            for(Player p : players) {
                playerNames.add(p.getName());
            }

            loadedGame = SavingManager.getInstance().loadGame(playerNames,gameMode);

            // if a matching save is present
            if (loadedGame!=null) {
                System.out.println("Founded previously saved game");
                waitingConnection.get(0).send(new LoadGame());
            } else {
                createGame();
            }
        }
    }

    /**
     * Accept the connection and create a SocketClientConnection for each socket
     */
    public void run() {
        int connections = 0;
        System.out.println("Server is running");

        while (!Thread.currentThread().isInterrupted() ) {
            try {
                Socket newSocket = serverSocket.accept();
                newSocket.setSoTimeout(360000);
                connections++;
                System.out.println("Ready for the new connection - " + connections);
                SocketClientConnection socketConnection = new SocketClientConnection(newSocket, this);
                socketConnections.add(socketConnection);

                Thread t0 = new Thread(socketConnection);
                t0.start();

            } catch(SocketTimeoutException e) {
                System.out.println("### Timed out after 5 seconds.");
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param username  The name of the player who is calling this method
     * @return true if the name is not already chosen, false instead
     */
    public Boolean equalName(String username, Boolean isFirst) {
        if (isFirst) {
            return false;
        }
        for (int i = 0; i<socketConnections.size()-1; i++) {
            if (socketConnections.get(i).getName() == null) {
                return false;
            }
            if (socketConnections.get(i).getName().equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method is called from observer, after its modified we sent the game to the client
     */
    public void sendGame() {
        System.out.println("Sending game to clients");
            for (SocketClientConnection c : playingConnection) {
                c.send(game);
        }
    }

    /**
     * @return reference to the game
     */
    public Game getGame() {
        return this.game;
    }

    /**
     * Synchronized the modifying in game with the other threads
     * @param object The message method which modifies the game
     * @return the thread used
     */
    public Thread modifyGame(Object object) {
        Thread t = new Thread(() -> {
            if (object instanceof MessageMethod && playingConnection.size()==numberOfPlayer) {
               ((MessageMethod) object).apply(game);
            }
        });
        t.start();
        return t;
    }

    /**
     * Load the game saved
     * @param choice is 1 if the game saved has to be loaded, 0 if a new game has to be created
     * @return the thread used
     */
    public Thread loadGame(String choice){
        Server server = this;
        Thread t;
        if(choice.equals("1")){
            t = new Thread(() -> {
               game = loadedGame;
               propertyObserver = new PropertyObserver(game,this);
               game.addListener(propertyObserver);
               game.setInstances();
               playingConnection.addAll(waitingConnection);
               sendGame();
            });
        }else{
            t = new Thread(() -> {
                try {
                    createGame();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        t.start();
        return t;
    }

    /**
     * Create a new game
     * @throws InterruptedException
     */
    private void createGame() throws InterruptedException{
        game = new Game();
        propertyObserver = new PropertyObserver(game,this);
        game.addListener(propertyObserver);
        MessageMethod messageMethod = new StartGame();
        ((StartGame)messageMethod).setGameMode(gameMode);
        ((StartGame)messageMethod).setPlayers(players);
        Thread t1 = new Thread(modifyGame(messageMethod));
        t1.join();
        playingConnection.addAll(waitingConnection);
        waitingConnection.clear();
    }

    /**
     * @param gameMode The game mode we want to set
     */
    public void setGameMode(Boolean gameMode) {
        this.gameMode = gameMode;
    }

    /**
     * @param numberOfPlayer THe number of player we decided
     */
    public void setNumberOfPlayer(Integer numberOfPlayer){
        this.numberOfPlayer = numberOfPlayer;
    }

    /**
     * @return semaphore The semaphore that the server uses to handle the socket
     */
    public Semaphore getSemaphore() {
        return this.semaphore;
    }

    /**
     * @return waitingConnection list
     */
    public LinkedList<SocketClientConnection> getWaitingConnection() {
        return this.waitingConnection;
    }

    /**
     * @return playingConnection list
     */
    public LinkedList<SocketClientConnection> getPlayingConnection() {
        return this.playingConnection;
    }

}


