package it.polimi.ingsw.client;

import java.io.IOException;
import java.util.Scanner;

public class Controller implements Runnable{

    /**
     *
     */
    private Scanner stdIn;

    /**
     *
     */
    private Boolean isActive = false;

    /**
     *
     */
    private Client client;

    /**
     *
     */
    private String input;

    /**
     *
     */
    private ClientState clientState = ClientState.SLEEPING;

    /**
     *
     */
    private CLI cli;

    /**
     *
     * @param client
     */
    public Controller(Client client) {

        this.client = client;
        this.stdIn = client.getScanner();
        cli = new CLI(client);

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

               case LOGIN :
                   System.out.println("Dentro Login");
                   input = stdIn.nextLine();
                   write(input);
                   break;

               case SLEEPING:
                   break;

               case CHOOSE_COLOR:
                   cli.chooseColorAndDeck();

/**
                if (client.getGame() != null && client.getGame().getCurrentPlayer().getPlayerPhase() == PlayerPhase.SET_UP_PHASE) {
                        System.out.println("Siamo nella fase di scelta del deck e del colore\n Inizia a scegliere il colore seleziona da 0 al numero di wizard");
                        System.out.println(((SetUpRound) client.getGame().getCurrentRound()).getWizards());
                        String input = stdIn.nextLine();
                        MessageMethod messageMethod = new ChooseColorAndDeck();
                        messageMethod.setWizard(((SetUpRound) client.getGame().getCurrentRound()).getWizards().get(Integer.parseInt(input)));
                        System.out.println("Scegli il colore\n");
                        System.out.println(((SetUpRound) client.getGame().getCurrentRound()).getplayerColor());
                        input = stdIn.nextLine();
                        messageMethod.setPlayerColor(((SetUpRound) client.getGame().getCurrentRound()).getplayerColor().get(Integer.parseInt(input)));
                        write(messageMethod);
                    }else {
                        System.out.println("Sono a comando da tastiera");
                        input = stdIn.nextLine();
                        write(input);
                    }
 */


            }

        }

    /**
     *
     * @param object
     */
    public void write(Object object){
        synchronized (client) {
            try {
                System.out.println("scrivo");
                client.getIn().writeObject(object);
                client.getIn().flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param clientState
     */
    public void setClientState(ClientState clientState){
        this.clientState=clientState;
    }

}
