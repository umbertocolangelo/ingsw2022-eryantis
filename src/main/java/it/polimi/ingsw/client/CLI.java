package it.polimi.ingsw.client;

import it.polimi.ingsw.message.ChooseColorAndDeck;
import it.polimi.ingsw.message.ChoosingAssistant;
import it.polimi.ingsw.message.MessageMethod;
import it.polimi.ingsw.model.rounds.SetUpRound;

import java.util.Scanner;

public class CLI {
    /**
     * Keep the reference to the Client
     */
    private Client client;
    /**
     * Keep the reference to the controller
     */
    private Controller controller;
    /**
     * The inpu we get from the keyboard
     */
    private Scanner scanner=new Scanner(System.in) ;

    /**
     *Is where we store the input from keyboard
     */
    private String input;

    /**
     *
     * @param client
     * @param controller
     */
    public CLI(Client client, Controller controller){
        this.client=client;
        this.controller=controller;
    }

    /**Get the thread witch will run the chooseColorAndDeck method
     *
     * @return thread
     */

    public Thread chooseColorAndDeck() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

            System.out.println("Siamo nella fase di scelta del deck e del colore\n Inizia a scegliere il colore seleziona da 0 al numero di wizard");
            System.out.println(((SetUpRound) client.getGame().getCurrentRound()).getWizards());
            input = scanner.nextLine();
            while (input=="" || !input.matches("[0-9]+") || Integer.parseInt(input)>((SetUpRound) client.getGame().getCurrentRound()).getWizards().size()-1)
            {
                System.out.println("Hai inserito un valore sbagliato o troppo alto");
                input = scanner.nextLine();
            }
                System.out.println("Wizard scelto " + ((SetUpRound) client.getGame().getCurrentRound()).getWizards().get(Integer.parseInt(input)) + "\n");
            MessageMethod messageMethod = new ChooseColorAndDeck();
            ((ChooseColorAndDeck) messageMethod).setWizard(((SetUpRound) client.getGame().getCurrentRound()).getWizards().get(Integer.parseInt(input)));
            System.out.println("Scegli il colore\n");
            System.out.println(((SetUpRound) client.getGame().getCurrentRound()).getplayerColor());
            input = scanner.nextLine();
            while (input=="" || !input.matches("[0-9]+") || Integer.parseInt(input)>((SetUpRound) client.getGame().getCurrentRound()).getplayerColor().size()-1)
                {
                    System.out.println("Hai inserito un valore sbagliato o troppo alto");
                    input = scanner.nextLine();
                }
                System.out.println("Color scelto " + ((SetUpRound) client.getGame().getCurrentRound()).getplayerColor().get(Integer.parseInt(input)) + "\n");
            ((ChooseColorAndDeck) messageMethod).setPlayerColor(((SetUpRound) client.getGame().getCurrentRound()).getplayerColor().get(Integer.parseInt(input)));
            controller.write(messageMethod);
        }
    });
        t.start();
        return t;
    }

    /**Get the thread to run the play assistantCArd action
     *
     * @return thread
     */
    public Thread choosingAssistant(){
    Thread t = new Thread(() -> {
        System.out.println("Adesso è il momento di scegliere la tua carta assistente da giocare!");
        System.out.println(( client.getGame().getCurrentPlayer()).getAssistantCard());
         input = scanner.nextLine();
        while (input=="" || !input.matches("[0-9]+") || Integer.parseInt(input)>client.getGame().getCurrentPlayer().getAssistantCard().size()-1)
        {
            System.out.println("Hai inserito un valore sbagliato o troppo alto");
            input = scanner.nextLine();
        }
        MessageMethod messageMethod = new ChoosingAssistant();
        ((ChoosingAssistant) messageMethod).setAssistantCard(client.getGame().getCurrentPlayer().getAssistantCard().get(Integer.parseInt(input)));
        //messageMethod.setWizard(((SetUpRound) client.getGame().getCurrentRound()).getWizards().get(Integer.parseInt(input)));
        //messageMethod.setPlayerColor(((SetUpRound) client.getGame().getCurrentRound()).getplayerColor().get(Integer.parseInt(input)));
        controller.write(messageMethod);

    });
        t.start();
        return t;
}

}
