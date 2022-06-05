package it.polimi.ingsw.client;

import it.polimi.ingsw.client.view.CLI;
import it.polimi.ingsw.message.IsFirst;

import java.io.IOException;
import java.util.Scanner;


public class Controller implements Runnable {

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
     * Default constructor
     * Keep the reference to the client
     * @param client
     */
    public Controller(Client client) {
        this.client = client;
        this.stdIn = client.getScanner();
        cli = new CLI(client,this);
    }

    /**
     * We receive the clientState and decide what to do
     */
    @Override
    public void run() {

        switch (clientState) {
            case LOGIN:
                input = stdIn.nextLine();
                while ( (input.matches(".*\\d.*"))){
                    System.out.println("You inserted a wrong value for username");
                input = stdIn.nextLine();
                 }

                write(input);
                setClientState(ClientState.SLEEPING);
                break;
            case ISFIRST:
                System.out.println("You are the first Player");
                System.out.println("Decide the number of players, 2 or 3");
                String message = stdIn.nextLine();
                while(!(message.equals("2") || message.equals("3"))) {
                        System.out.println("You must select 2 or 3! Please try again");
                    message = stdIn.nextLine(); // Read user input
                }
                IsFirst isFirst=new IsFirst();
                isFirst.setPlayers(Integer.parseInt(message));
                System.out.println("Number of players selected "+ Integer.parseInt(message));
                System.out.println("Decide the gameMode, 1 for expert and 0 for normal");
                message = stdIn.nextLine(); // Read user input// Read user input

                while(!(message.equals("0") || message.equals("1"))) {
                    System.out.println("You must select 0 or 1 ");
                    message = stdIn.nextLine(); // Read user input// Read user input
                }

                if(message.equals("1"))
                    isFirst.setGameMode(true);
                else
                    isFirst.setGameMode(false);

                System.out.println("Game mode selected ");
                write(isFirst);

            case EQUALNAME:
                System.out.println("The username is already present, select another one");
                input = stdIn.nextLine();
                while ( (input.matches(".*\\d.*"))){
                    System.out.println("You inserted a wrong value for username");
                    input = stdIn.nextLine();
                }

                write(input);
                setClientState(ClientState.SLEEPING);
                break;
            case SLEEPING:
                break;

            case PLAYING:
                for (int i = 0; i < 50; i++) {
                    System.out.println("\b");
                }
                switch (client.getGame().getCurrentPlayer().getPlayerPhase()) {
                    case SET_UP_PHASE:
                        t0 = cli.chooseColorAndDeck();
                        break;

                    case CHOOSING_ASSISTANT:
                        t0 = cli.choosingAssistant();
                        break;

                    case MOVING_STUDENTS:
                        checkRound();
                        break;

                    case MOVING_MOTHERNATURE:
                        checkRound();
                        break;

                    case CHOOSING_CLOUD:
                        checkRound();
                        break;
                }
                try {
                    t0.join();
                    setClientState(ClientState.SLEEPING);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }

    }

    /**
     * This method write to the server socket synchronized with the read
     * @param object the object we need to send
     */
    public void write(Object object) {
        synchronized (client) {
            try {
                client.getIn().writeObject(object);
                client.getIn().flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Set the clientState
     * @param clientState The client State we want to modify
     */
    public void setClientState(ClientState clientState) {
        this.clientState = clientState;
    }

    /**
     *
     */
    private void checkRound() {
        if(client.getGame().getCurrentRound().getId()==null)
            t0 = cli.choosingExpertCardOrMoving();
        else {
            switch (client.getGame().getCurrentRound().getId()) {
                case 0:
                    t0 = cli.ingressCardSwap();
                    break;
                case 1:
                    t0 = cli.ingressHallSwap();
                    break;
                case 2:
                    t0 = cli.studentToHall();
                    break;
                case 3:
                    t0 = cli.studentToIsland();
                    break;
            }
        }
    }

}
