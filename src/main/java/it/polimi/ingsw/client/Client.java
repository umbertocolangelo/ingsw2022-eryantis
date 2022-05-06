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

    private String ip;
    private int port;
    private Game game;
    private Scanner stdin;
    private String namePlayer;
    private Object inputObject;
    private Controller controller;
    private  ObjectOutputStream socketOut;


    public Client(String ip, int port){
        this.ip = ip;
        this.port = port;
    }

    private boolean active = true;

    public synchronized boolean isActive(){
        return active;
    }

    public synchronized void setActive(boolean active){
        this.active = active;
    }

    public Thread asyncReadFromSocket(final ObjectInputStream socketIn){
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
                                System.out.println("ricevuto game al client");
                                if (game.getCurrentPlayer().getName().equals(namePlayer))
                                    controller.setActive(true);
                            } else if (inputObject instanceof SetUp) {
                                controller.setActive(true);
                                System.out.println("ricevutoi");
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

    public Thread asyncWriteToSocket(final Scanner stdin, final ObjectOutputStream socketOut){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (isActive()) {

                        /**if(game.getCurrentPlayer().getPlayerPhase()==PlayerPhase.SET_UP_PHASE) {
                            MessageMethod messageMethod = new MessageMethod("1");
                            messageMethod.setPlayerColor(PlayerColor.WHITE);
                            messageMethod.setWizard(Wizard.PURPLE_WIZARD);
                            socketOut.writeObject(messageMethod);
                        }
                         */

                    }
                }catch(Exception e){
                    setActive(false);
                }
            }
        });
        t.start();
        return t;
    }

    public void run() throws IOException {
        Socket socket = new Socket(ip, port);
        System.out.println("Connection established");
        ObjectInputStream socketIn = new ObjectInputStream(socket.getInputStream());
        socketOut = new ObjectOutputStream(socket.getOutputStream());
         stdin = new Scanner(System.in);
         controller=new Controller(this);

        try{
            Thread t0 = asyncReadFromSocket(socketIn);
            Thread t1 = asyncWriteToSocket(stdin, socketOut);
            controller.run();
            t0.join();
            //t1.join();

        } catch(InterruptedException | NoSuchElementException e){
            System.out.println("Connection closed from the client side");
        } finally {
            stdin.close();
            socketIn.close();
            socketOut.close();
            socket.close();
        }
    }

    public Scanner getScanner(){
        return stdin;
    }

    public String getNamePlayer(){
        return this.namePlayer;
    }

    public ObjectOutputStream getIn(){
        return socketOut;
    }

    public Game getGame(){
        return this.game;
    }

}
