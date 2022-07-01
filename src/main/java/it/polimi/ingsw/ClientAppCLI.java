package it.polimi.ingsw;

import it.polimi.ingsw.client.CLIController;
import it.polimi.ingsw.client.Client;

/**
 * Client app cli
 */
public class ClientAppCLI {

    /**
     * main
     * @param args String
     */
    public  static void main(String[] args) {
        Client client = new Client("localhost", 65432);
        CLIController CLIController =new CLIController();
        CLIController.setClient(client);
        client.setController(CLIController);
        client.setIsCli();
        CLIController.startClient();
    }

}
