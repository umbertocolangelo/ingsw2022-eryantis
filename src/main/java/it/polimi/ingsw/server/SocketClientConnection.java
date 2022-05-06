package it.polimi.ingsw.server;


import it.polimi.ingsw.listener.PropertyObserver;
import it.polimi.ingsw.message.MessageMethod;
import it.polimi.ingsw.message.SetName;
import it.polimi.ingsw.message.SetUp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.NoSuchElementException;


public class SocketClientConnection  implements ClientConnection, Runnable {

    private Object object=new Object();
    private Socket socket;
    private ObjectOutputStream out;
    private Server server;
    private String name;
    private ObjectInputStream in;
    private boolean active = true;
    private PropertyObserver observer;

    public SocketClientConnection(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
    }

    private synchronized boolean isActive(){
        return active;
    }

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

    @Override
    public synchronized void closeConnection() {
        send("Connection closed!");
        try {
            socket.close();
        } catch (IOException e) {
            System.err.println("Error when closing socket!");
        }
        active = false;
    }

    @Override
    public void addObserver(PropertyObserver observer) {
            this.observer=observer;
    }

    private void close() {
        closeConnection();
        System.out.println("Deregistering client...");
        server.deregisterConnection(this);
        System.out.println("Done!");
    }

    //Si potrebbe modificare mettendo semplicemente una gui
    public void asyncSend(final Object message){
        new Thread(new Runnable() {
            @Override
            public void run() {
                send(message);
            }
        }).start();
    }


    @Override
    public void run() {
       // while(!Thread.currentThread().isInterrupted()){
        try{
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

            SetUp setup=new SetUp();
           // System.out.println("si");
            send("Welcome!\nWhat is your name?");
            send(setup);
            synchronized (server) { //si  sincronizza con il send
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
                        Thread t1=new Thread( server.modifyGame(object));
                        t1.join();
                        System.out.println(object);
                    }
                    /** if(object instanceof MessageMethod)
                     {

                     if (  ((MessageMethod) object).getId().equals("1")){
                     server.getGame().chooseColorAndDeck(((MessageMethod) object).getPlayerColor(),((MessageMethod) object).getWizard());
                     }
                     }
                     */
                    //  notify(read);
                }

        } catch (IOException | NoSuchElementException e) {
            System.err.println("Error! " + e.getMessage());
        } catch (ClassNotFoundException e){
                e.printStackTrace();
            } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            close();
        }

        //}
    }

    public String getName(){
        return  this.name;
    }

    public ObjectInputStream getIn(){
        return this.in;
    }

}
