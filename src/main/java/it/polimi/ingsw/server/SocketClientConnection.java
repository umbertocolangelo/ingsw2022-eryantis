package it.polimi.ingsw.server;


import it.polimi.ingsw.message.MessageMethod;
import it.polimi.ingsw.message.SetName;
import it.polimi.ingsw.message.SetUp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.NoSuchElementException;


public class SocketClientConnection  implements  Runnable {

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
     * @param socket        The socket we want to hande
     * @param server        The reference to the server
     */
    public SocketClientConnection(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
    }

    /**
     * This boolean is needed to close the connection when its needed
     * @return active
     */
    private synchronized boolean isActive(){
        return this.active;
    }

    /**
     * This method send the message synchronized with the reading
     * @param message
     */
    public  void send(Object message) {
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
     * This method is needed when we want to close the connection, close the socket and set active to false
     */
    public synchronized void closeConnection() {
        send("Connection closed!");
        try {
            socket.close();
        } catch (IOException e) {
            System.err.println("Error when closing socket!");
        }
        active = false;
    }


    /**
     *Calls the close connection and close the connection also in the server
     */
    private void close() {
        closeConnection();
        System.out.println("Deregistering client...");
        server.deregisterConnection(this);
        System.out.println("Done!");
    }



    /**
     * This run is always open and keep listening to the client and send the message to the server
     */
    @Override
    public void run() {
       // while(!Thread.currentThread().isInterrupted()){
        try {
            synchronized (server) {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            SetUp setup = new SetUp();
           // System.out.println("si");
            send("Welcome!\nWhat is your name?");

             //si  sincronizza con il send
                send(setup);
                String read = (String) in.readObject();
                while (server.equalName(read) || read.matches(".*\\d.*")) {
                    send("You inserted a number or the username is already used, insert another one");
                    send(setup);
                    read = (String) in.readObject();
                    System.out.println(read);
                }
                name = read;
                send(new SetName(name));
            }
                server.lobby(this, name);
                while (isActive()) {
                    Object object = in.readObject();
                    if (object instanceof MessageMethod) {
                        Thread t1 = new Thread( server.modifyGame(object));
                        t1.join();
                        System.out.println(object);
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
     *
     * @return name     Return the playerName
     */
    public String getName(){
        return  this.name;
    }

    /**
     *
     * @return in       Return the inputStream
     */
    public ObjectInputStream getIn(){
        return this.in;
    }

}
