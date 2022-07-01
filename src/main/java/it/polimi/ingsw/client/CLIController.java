package it.polimi.ingsw.client;

import it.polimi.ingsw.client.view.CLI;
import it.polimi.ingsw.client.view.gui.controllers.GUIController;
import it.polimi.ingsw.message.IsFirst;
import it.polimi.ingsw.model.player.Player;

import java.io.IOException;
import java.util.Scanner;


public class CLIController implements Runnable {

    /**
     * Boolean connection true
     */
    private Boolean connectionTrue = false;

    /**
     * Represent the Thread that will modify the game
     */
    private Thread t0;

    /**
     * Get the input from the keyboard
     */
    private Scanner stdIn;

    /**
     * Boolean is active
     */
    private Boolean isActive = false;

    /**
     * Keep the reference from Client
     */
    private Client client;

    /**
     * The string we get from the Scanner
     */
    private String input;

    /**
     * The clientState where the controller is now
     */
    private ClientState clientState = ClientState.SLEEPING;

    /**
     * Reference to the CLI
     */
    private CLI cli;

    /**
     * Default constructor
     * Keep the reference to the client
     */
    public CLIController() {
        this.stdIn = new Scanner(System.in);
    }

    /**
     * We receive the clientState and decide what to do
     */
    @Override
    public void run() {

        switch (clientState) {
            case LOGIN:
                System.out.println("Welcome to Eriantys, what's your name?");
                input = stdIn.nextLine();
                while ((input.matches(".*\\d.*")) || input.equals("")) {
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
                IsFirst isFirst = new IsFirst();
                isFirst.setPlayers(Integer.parseInt(message));
                System.out.println("Number of players selected "+ Integer.parseInt(message));
                System.out.println("Decide the gameMode, 1 for expert and 0 for normal");
                message = stdIn.nextLine(); // Read user input

                while (!(message.equals("0") || message.equals("1"))) {
                    System.out.println("You must select 0 or 1 ");
                    message = stdIn.nextLine(); // Read user input
                }
                if (message.equals("1")) {
                    isFirst.setGameMode(true);
                } else {
                    isFirst.setGameMode(false);
                }
                System.out.println("Game mode selected ");
                write(isFirst);
                break;
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
                System.out.println("\n\nWaiting for other players . . .");
                break;
            case CLIENTLOST:
                t0 = cli.clientLost(client.getNamePLayerLost());
                break;
            case CONNECTIONLOST:
                t0 = cli.connectionLost();
                break;
            case PLAYERPLUS:
                t0 = cli.playerIsPlus();
                break;
            case LOAD:
                System.out.println("A previously saved game has been found, insert 1 to load it or insert 0 to start a new game");
                input = stdIn.nextLine();
                while (!(input.equals("0") || input.equals("1"))){
                    System.out.println("You must select 0 or 1");
                    input = stdIn.nextLine();
                }
                write(input);
                setClientState(ClientState.SLEEPING);
                break;
            case WINNER:
                for (Player p : this.getClient().getGame().getPlayerList()) {
                    if (p.getIsWinner() && p.getName().equals(client.getNamePlayer())) {
                        System.out.println("\n\n\n\n\n\nCongratulations " + client.getNamePlayer() + " ! You are the winner of this magic game !\nNo one is on your level :)");
                        return;
                    } else {
                        System.out.println("\n\n\n\n\n\nOh noo! Unfortunately you have lost the game ...\nBut don't worry, play again to improve your skills and prove you are the best !");
                    }
                }
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

                    case MOVING_STUDENTS, MOVING_MOTHERNATURE, CHOOSING_CLOUD:
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
     * Returns client state
     * @return ClientState
     */
    public ClientState getClientState() {
        return this.clientState;
    }

    /**
     * Go to the different cli threads for expert cards that needs parameters
     */
    private void checkRound() {
        if (client.getGame().getCurrentRound().getId()==null) {
            t0 = cli.choosingExpertCardOrMoving();
        }
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

    /**
     * Sets the client
     * @param client Client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * sets client first interactions
     */
    public void startClient() {
        System.out.println("Insert 1 if you want to change the ip address, 0 if you dont\nYour target ip address is " + client.getIp() + " and your target port is " + client.getPort().toString());
        input = stdIn.nextLine();
        while (!(input.equals("0") || input.equals("1"))) {
            System.out.println("You inserted a wrong value ");
            input = stdIn.nextLine();
        }
        if (input.equals("1")) {
            System.out.println("Insert the ip address");
            input = stdIn.nextLine();
            while (!input.matches( "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$")) {
                System.out.println("You inserted a wrong value ");
                input = stdIn.nextLine();
            }
            client.setIp(input);
            System.out.println("Insert the port");
            input = stdIn.nextLine();
            while (!input.matches(".*\\d.*") || input.length()>5) {
                System.out.println("You inserted a wrong or too high value ");
                input = stdIn.nextLine();
            }
            client.setPort(Integer.parseInt(input));
        }
        Thread t1 = null;
        try {
            t1 = new Thread(client.run());
        } catch (IOException e) {
            e.printStackTrace();
        }
        t1.start();
    }

    /**
     * Connection refused texts
     */
    public void connectionRefuse() {
        System.out.println("The connection has been refused, write 0 if you want to try again or 1 to close the app");
        input = stdIn.nextLine();
        while (!(input.equals("0") || input.equals("1"))) {
            System.out.println("You inserted a wrong value ");
            input = stdIn.nextLine();
        }
        if (input.equals("1")) {
            return;
        } else {
            startClient();
        }
    }

    /**
     * @return conntectionTrue boolean
     */
    public Boolean getConnectionTrue() {
        return this.connectionTrue;
    }

    /**
     * Sets connectionTrue boolean
     * @param connectionTrue Boolean
     */
    public void setConnectionTrue(Boolean connectionTrue) {
        this.connectionTrue = connectionTrue;
    }

    /**
     * @return this client
     */
    public Client getClient(){
        return this.client;
    }

    /**
     * Sets cli
     * @param cli CLI
     */
    public void setCli(CLI cli) {
        this.cli = cli;
    }

}
