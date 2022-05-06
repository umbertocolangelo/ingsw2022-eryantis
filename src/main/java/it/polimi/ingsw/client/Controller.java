package it.polimi.ingsw.client;

import it.polimi.ingsw.message.ChooseColorAndDeck;
import it.polimi.ingsw.message.MessageMethod;
import it.polimi.ingsw.model.enumerations.PlayerPhase;
import it.polimi.ingsw.model.rounds.SetUpRound;

import java.io.IOException;
import java.util.Scanner;

public class Controller implements Runnable{
    private Scanner stdIn;
    private Boolean isActive=false;
    private Client client;
    private String input;


    public Controller(Client client){
        this.client=client;
        this.stdIn=client.getScanner();
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
        while (true) {
            while (isActive) {
                if(client.getGame()!=null)
                System.out.println(client.getGame().getCurrentPlayer() + "   " +client.getNamePlayer() );
                while (client.getGame()!=null && client.getGame().getCurrentPlayer().getName().equals(client.getNamePlayer())) {

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
                    }
                }
                    input = stdIn.nextLine();
                    write(input);

                //isActive = false;

            }
            //  }

        }
    }

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

    public void setActive(Boolean bol){
        this.isActive=bol;
    }

}
