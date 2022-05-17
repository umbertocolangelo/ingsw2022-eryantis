package it.polimi.ingsw.client;


import it.polimi.ingsw.message.SetName;
import it.polimi.ingsw.message.SetUp;
import it.polimi.ingsw.model.Game;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Client {

    /**
     * Keep the reference to the socket
     */
    private  Socket socket;

    /**
     *  Keep the reference to InputStream
     */
    private ObjectInputStream socketIn;

    /**
     * Keep the ip port
     */
    private String ip;

    /**
     *Keep the reference to the port
     */
    private final int port;

    /**
     * Keep the reference to the game
     */
    private Game game;

    /**
     * Keep the reference to the Scanner
     */
    private Scanner stdin;

    /**
     * Keep the reference to the namePlayer
     */
    private String namePlayer;

    /**
     * It's a semaphore needed to synchronized with the output
     */
    private Object inputObject;

    /**
     * Keep the reference to the controller
     */
    private Controller controller;

    /**
     * Keep the reference to the OutputStream
     */
    private  ObjectOutputStream socketOut;

    /**
     * Set if the player is active to read or not
     */
    private Boolean active = true;

    /**
     * @param ip        The ip address
     * @param port      the port
     */
    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    /**
     *
     * @return  active      Get the active variable
     */
    public synchronized boolean isActive() {
        return active;
    }

    /**
     *
     * @param active        Set the active variable
     */
    public synchronized void setActive(Boolean active) {
        this.active = active;
    }

    /**
     *
     * @param socketIn The inputStream
     * @return Thread  Return the thread who will keep read and once he read it will run the controller and wait for his termination
     */
    public Thread asyncReadFromSocket(final ObjectInputStream socketIn) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    try {
                        while (isActive()) {
                            inputObject = socketIn.readObject();
                            if (inputObject instanceof String) {
                                System.out.println((String) inputObject);
                            } else if (inputObject instanceof Game) {
                                game = (Game) inputObject;
                                System.out.println("Client received Game.");
                                if (game.getCurrentPlayer().getName().equals(namePlayer))
                                    controller.setClientState(ClientState.PLAYING);
                                    controller.run();
                            } else if (inputObject instanceof SetUp) {
                               // System.out.println("Set Up received.");
                                controller.setClientState(ClientState.LOGIN);
                                controller.run();
                            } else if (inputObject instanceof SetName)
                                namePlayer = ((SetName) inputObject).getName();
                            else {
                                throw new IllegalArgumentException();
                            }

                        }
                    } catch (Exception e) {
                        setActive(false);
                    }
                }
            }
        });
        t.start();
        return t;
    }


    /**
     *  When the client is running start the thread for reading and wait until that thread die
     * @throws IOException
     */
    public void run() throws IOException {
        socket = new Socket(ip, port);
        System.out.println("Connection established.");
        socketIn = new ObjectInputStream(socket.getInputStream());
        socketOut = new ObjectOutputStream(socket.getOutputStream());
        stdin = new Scanner(System.in);
        controller = new Controller(this);

        try {
            Thread t0 = asyncReadFromSocket(socketIn);
           // Thread t1 = asyncWriteToSocket(stdin, socketOut);

            t0.join();
            //t1.join();

        } catch (InterruptedException | NoSuchElementException e) {
            System.out.println("Connection closed from the client side");

        } finally {
            stdin.close();
            socketIn.close();
            socketOut.close();
            socket.close();
        }
    }

    /**
     *
     * @return stdIn        The scanner of the keyboard
     */
    public Scanner getScanner() { return stdin; }

    /**
     *
     * @return
     */
    public String getNamePlayer() {
        return this.namePlayer;
    }

    /**
     *
     * @return socketOut        The inputStream
     */
    public ObjectOutputStream getIn(){
        return socketOut;
    }

    /**
     *
     * @return game     The refrence to the game in the client
     */
    public Game getGame(){
        return this.game;
    }

}
