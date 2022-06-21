package it.polimi.ingsw.client;


import it.polimi.ingsw.client.view.gui.controllers.ControllerHandler;
import it.polimi.ingsw.message.*;
import it.polimi.ingsw.model.Game;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Client {


    /**
     *
     */
    private String namePLayerLost;

    /**
     * Keep the reference to the socket
     */
    private Socket socket;

    /**
     * Keep the reference to InputStream
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
     * Keeps the reference to the CLI controller
     */
    private Controller controller;

    /**
     * Keep the reference to the OutputStream
     */
    private ObjectOutputStream socketOut;

    /**
     * Set if the player is active to read or not
     */
    private Boolean active = true;

    /**
     * States if the view is CLI (false) or GUI (true)
     */
    private Boolean isCli = false;

    /**
     * Keeps the reference to the GUI controller
     */
    private ControllerHandler controllerHandler;

    /**
     * The ip address and the port
     * @param ip
     * @param port
     */
    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    /**
     * Get the active variable
     * @return active
     */
    public synchronized boolean isActive() {
        return active;
    }

    /**
     * Set the active variable
     * @param active
     */
    public synchronized void setActive(Boolean active) {
        this.active = active;
    }

    /**
     *
     */
    private Semaphore semaphore = new Semaphore(0);

    /**
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
                            System.out.println("Received something: " + inputObject);
                            if (!isCli) {
                                if (inputObject instanceof ClientLost) {
                                    ControllerHandler.getInstance().setClientState(ClientState.CLIENTLOST);
                                    ControllerHandler.getInstance().chooseScene();
                                }else if (inputObject instanceof SetUp) {
                                    ControllerHandler.getInstance().setClientState(ClientState.LOGIN);
                                    new Thread(ControllerHandler.getInstance().chooseScene());
                                }else if (inputObject instanceof LoadGame) {
                                    ControllerHandler.getInstance().setClientState(ClientState.LOAD);
                                    ControllerHandler.getInstance().chooseScene();
                                }else if (inputObject instanceof EqualName) {
                                    ControllerHandler.getInstance().setClientState(ClientState.EQUALNAME);
                                    ControllerHandler.getInstance().chooseScene();
                                } else if (inputObject instanceof IsFirst) {
                                    System.out.println("isFirst");
                                    ControllerHandler.getInstance().setClientState(ClientState.ISFIRST);
                                    new Thread(ControllerHandler.getInstance().chooseScene());
                                } else if (inputObject instanceof SetName) {
                                    System.out.println("setName");
                                    namePlayer = ((SetName) inputObject).getName();
                                } else if (inputObject instanceof Game) {
                                    game = (Game) inputObject;
                                    System.out.println("Client received Game.");
                                    if (game.getCurrentPlayer().getName().equals(namePlayer)) {
                                        ControllerHandler.getInstance().setClientState(ClientState.PLAYING);
                                        ControllerHandler.getInstance().chooseScene();
                                    }
                                }
                                /*
                                else if (inputObject instanceof Winner) {
                                    System.out.println("Winner");
                                    ControllerHandler.getInstance().setClientState(ClientState.WINNER);
                                    ControllerHandler.getInstance().chooseScene();
                                }
                                 */
                            } else {
                                if (inputObject instanceof String) {
                                    System.out.println((String) inputObject);
                                } else if (inputObject instanceof Game) {
                                    game = (Game) inputObject;
                                    System.out.println("Client received Game");

                                    if (game.getCurrentPlayer().getName().equals(namePlayer)) {
                                        controller.setClientState(ClientState.PLAYING);
                                        controller.run();
                                    }
                                } else if (inputObject instanceof SetUp) {
                                    controller.setClientState(ClientState.LOGIN);
                                    controller.run();
                                }else if (inputObject instanceof EqualName) {
                                    controller.setClientState(ClientState.EQUALNAME);
                                    controller.run();
                                }else if (inputObject instanceof LoadGame) {
                                    controller.setClientState(ClientState.LOAD);
                                    controller.run();
                                } else if (inputObject instanceof SetName) {
                                    namePlayer = ((SetName) inputObject).getName();
                                } else if (inputObject instanceof IsFirst) {
                                    controller.setClientState(ClientState.ISFIRST);
                                    controller.run();
                                }else if (inputObject instanceof PlayerIsPlus) {
                                    controller.setClientState(ClientState.PLAYERPLUS);
                                    controller.run();
                                } else if (inputObject instanceof ClientLost) {
                                    namePLayerLost = ((ClientLost) inputObject).getNamePlayerLost();
                                    controller.setClientState(ClientState.CLIENTLOST);
                                    controller.run();
                                }
                                /*
                                else if (inputObject instanceof Winner) {
                                    controller.setClientState(ClientState.WINNER);
                                    controller.run();

                                }
                                */
                                else {
                                    throw new IllegalArgumentException();
                                }
                            }
                        }

                    } catch (Exception e) {
                        setActive(false);
                    }
                }
            }
        });
      //  t.start();
        return t;
    }

    /**
     * When the client is running start the thread for reading and wait until that thread die
     * @throws IOException
     * @return
     */
    public Runnable run() throws IOException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    socket = new Socket(ip, port);
                    System.out.println("Connection established.");
                    socketIn = new ObjectInputStream(socket.getInputStream());
                    socketOut = new ObjectOutputStream(socket.getOutputStream());
                    stdin = new Scanner(System.in);
                    controller = new Controller(this);
                    ControllerHandler.getInstance().setClient(Client.this);
                    Thread t0 = new Thread(asyncReadFromSocket(socketIn));
                   final ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(128);
                 executor.submit(new Thread(asyncReadFromSocket(socketIn)));
                   executor.awaitTermination(10000, TimeUnit.DAYS);
                 //t0.join();
                 //  semaphore.acquire();

                } catch (NoSuchElementException e) {
                    System.out.println("Connection closed from the client side");

                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        stdin.close();

                        socketIn.close();


                        socketOut.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
      //  t.start();
        return t;
    }

    /**
     * The scanner of the keyboard
     * @return stdIn
     */
    public Scanner getScanner() {
        return this.stdin;
    }

    /**
     *
     * @return
     */
    public String getNamePlayer() {
        return this.namePlayer;
    }

    /**
     * The inputStream
     * @return socketOut
     */
    public ObjectOutputStream getIn() {
        return this.socketOut;
    }

    /**
     *
     * @return
     */
    public ObjectInputStream getOut() {
        return this.socketIn;
    }

    /**
     * The reference to the game in the client
     * @return game
     */
    public Game getGame() {
        return this.game;
    }

    /**
     *
     * @return
     */
    public String getNamePLayerLost() {
        return this.namePLayerLost;
    }

    /**
     *
     * @param namePLayerLost
     */
    public void setNamePLayerLost(String namePLayerLost) {
        this.namePLayerLost = namePLayerLost;
    }

    /**
     * Sets the view to CLI
     */
    public void setIsCli(){
        this.isCli = true;
    }

}
