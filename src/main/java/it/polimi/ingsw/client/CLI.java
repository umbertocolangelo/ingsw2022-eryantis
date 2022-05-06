package it.polimi.ingsw.client;

import it.polimi.ingsw.message.ChooseColorAndDeck;
import it.polimi.ingsw.message.MessageMethod;
import it.polimi.ingsw.model.rounds.SetUpRound;

import java.util.Scanner;

public class CLI {
    private Client client;
    private Controller controller;
    private Scanner scanner;
    public CLI(Client client, Controller controller){
        this.client=client;
        this.controller=controller;
    }

    public void chooseColorAndDeck(Object lock) {
        synchronized (controller) {
            System.out.println("Siamo nella fase di scelta del deck e del colore\n Inizia a scegliere il colore seleziona da 0 al numero di wizard");
            System.out.println(((SetUpRound) client.getGame().getCurrentRound()).getWizards());
            String input = scanner.nextLine();
            MessageMethod messageMethod = new ChooseColorAndDeck();
            messageMethod.setWizard(((SetUpRound) client.getGame().getCurrentRound()).getWizards().get(Integer.parseInt(input)));
            System.out.println("Scegli il colore\n");
            System.out.println(((SetUpRound) client.getGame().getCurrentRound()).getplayerColor());
            input = scanner.nextLine();
            messageMethod.setPlayerColor(((SetUpRound) client.getGame().getCurrentRound()).getplayerColor().get(Integer.parseInt(input)));
            controller.write(messageMethod);
            controller.notify();
        }
    }

}
