package it.polimi.ingsw.server;


import it.polimi.ingsw.message.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.NoSuchElementException;



public class SocketClientConnection implements Runnable {

    /**
     *Set true if we close the connection, useful if we want to avoid close the connection twice
     */
    private Boolean hasBeenDisconnected=false;

    /**
     *True if the player is more than the player selected in isfirst
     */
    private Boolean playerIsPlus=false;

    /**
     *
     */
    private Boolean isFirst = false;

    /**
     * Keep the reference to the socket
     */
    private Socket socket;

    /**
     * Keep the reference to the outputStream
     */
    private ObjectOutputStream out;

    /**
     * Keep the reference to the server
     */
    private Server server;

    /**
     * Keep the reference to the playerName
     */
    private String name;

    /**
     * Keep the reference to the inputStream
     */
    private ObjectInputStream in;

    /**
     * Keep the reference to the active status
     */
    private boolean active = true;

    /**
     * Default constructor
     * @param socket        The socket we want to hande
     * @param server        The reference to the server
     */
    public SocketClientConnection(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
    }

    /**
     * This boolean is needed to close the connection when it's needed
     * @return active
     */
    private synchronized boolean isActive(){
        return this.active;
    }

    /**
     * This method send the message synchronized with the reading
     * @param message
     */
    public void send(Object message) {
        synchronized (server) {
            try {
                out.reset();
                out.writeObject(message);
                out.flush();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * This method is needed when we want to close the connection, closes the socket and sets active to false
     */
    public synchronized void closeConnection() {
        send("We lost your Connection");
        try {
            socket.close();
        } catch (IOException e) {
            System.err.println("Error when closing socket!");
        }
        active = false;
    }

    /**
      *Calls close connection and closes the connection also in the server
     */
    public void close() {
        if(playerIsPlus)
            send(new PlayerIsPlus());
        if (!hasBeenDisconnected) {
            if (isFirst)
                server.setNumberOfPlayer(0);
            closeConnection();
            if (server.getSemaphore().availablePermits() == 0)
                server.getSemaphore().release();
            System.out.println("Unregistering client ...");
            server.deregisterConnection(this);
            System.out.println("Done!");
        }
    }

    /**
     * This run is always open and keep listening to the client and send the message to the server
     */
    @Override
    public void run() {
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            SetUp setup = new SetUp();

            //It synchronizes with send
            server.getSemaphore().acquire();

            //If there are no player waiting in the lobby set this client connection as first
            if (server.getWaitingConnection().isEmpty() && server.getPlayingConnection().isEmpty()){
                isFirst = true;
            }

            send(setup);
            String read = (String) in.readObject();
            read = read.toUpperCase();
            while (server.equalName(read, isFirst)) {
                send(new EqualName());
                System.out.println("Ready to read");
                read = (String) in.readObject();
                System.out.println("Object read");
                read = read.toUpperCase();
                System.out.println(read);
            }

            name = read;
            send(new SetName(name));

            if (isFirst) {
                System.out.println("Sending is first");
                send(new IsFirst());
                IsFirst isFirst = (IsFirst) in.readObject();
                System.out.println();
                server.setGameMode(isFirst.getGameMode());
                server.setNumberOfPlayer(isFirst.getPlayersNumber());

            }

            server.lobby(this, name);

            while (isActive()) {
                Object object = in.readObject();
                if (object instanceof MessageMethod) {
                    Thread t1 = new Thread( server.modifyGame(object));
                    t1.join();
                    System.out.println(object);
                }
                if ((object instanceof IsFirst)) {
                    server.setGameMode(((IsFirst)object).getGameMode());
                    server.setNumberOfPlayer(((IsFirst)object).getPlayersNumber());
                    server.lobby(this,null);
                }
                if ((object instanceof String)) {
                    Thread t1 = new Thread(server.loadGame((String) object));
                    t1.join();
                }
            }
        } catch (IOException | NoSuchElementException e) {
            System.err.println("Error! " + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    /**
     * @return playerName
     */
    public String getName() {
        if (name!=null) {
            return this.name;
        }
        else {
            return null;
        }
    }

    /**
     * @return input stream
     */
    public ObjectInputStream getIn(){
        return this.in;
    }

    /**
     * set isFirst
     */
    public void setIsFirst(){
        isFirst=true;
    }

    /**
     *
     * @return if player the first one
     */
    public Boolean getIsFirst(){
        return this.isFirst;
    }

    /**
     *
     * @return playerIsPlus
     */
    public Boolean getPlayerIsPlus() {
        return playerIsPlus;
    }

    /**
     * set isPlus
     * @param playerIsPlus
     */
    public void setPlayerIsPlus(Boolean playerIsPlus) {
        this.playerIsPlus = playerIsPlus;
    }

    /**
     *
     * @return if player has been disconnected
     */
    public Boolean getHasBeenDisconnected() {
        return hasBeenDisconnected;
    }

    /**
     * set boolean that indicates player disconnection
     * @param hasBeenDisconnected
     */
    public void setHasBeenDisconnected(Boolean hasBeenDisconnected) {
        this.hasBeenDisconnected = hasBeenDisconnected;
    }
}
