package it.polimi.ingsw.client;

import java.io.IOException;
import java.util.Scanner;

public class Controller implements Runnable{

    /**
     * Represent the Thread that will modify the game
     */
    private Thread t0;

    /**
     *Get the input from the keyboard
     */
    private Scanner stdIn;

    /**
     *
     */
    private Boolean isActive = false;

    /**
     *Keep the reference from Client
     */
    private Client client;

    /**
     *The string we get from the Scanner
     */
    private String input;

    /**
     *The clientState where the controller is now
     */
    private ClientState clientState = ClientState.SLEEPING;

    /**
     *The CLI
     */
    private CLI cli;

    /**
     *
     * @param client
     */
    public Controller(Client client) {

        this.client = client;
        this.stdIn = client.getScanner();
        cli = new CLI(client,this);

    }


    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
           switch (clientState) {
               case LOGIN:
                  // System.out.println("Dentro Login");
                   input = stdIn.nextLine();
                   write(input);
                   setClientState(ClientState.SLEEPING);
                   break;

               case SLEEPING:
                   break;
               case PLAYING:
                   switch (client.getGame().getCurrentPlayer().getPlayerPhase()) {
                       case SET_UP_PHASE :
                            t0= cli.chooseColorAndDeck();
                            break;
                       case CHOOSING_ASSISTANT:
                           t0=cli.choosingAssistant();
                           break;
                   }
                   try {
                       t0.join();
                       setClientState(ClientState.SLEEPING);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
/**
 */
            }

        }

    /**
     * This method write to the server socket synchronized with the read
     *
     * @param object the object we need to send
     */
    public void write(Object object){
        synchronized (client) {
            try {
                System.out.println("metodo send nel controller");
                client.getIn().writeObject(object);
                client.getIn().flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**Set the clientState
     *
     * @param clientState The client State we want to modify
     */
    public void setClientState(ClientState clientState){
        this.clientState=clientState;
    }

}
