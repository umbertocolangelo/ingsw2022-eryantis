package it.polimi.ingsw;

import it.polimi.ingsw.client.CLIController;
import it.polimi.ingsw.client.Client;

public class ClientAppCLI {

    public  static void main(String[] args) {
        Client client = new Client("localhost", 65432);
        CLIController CLIController =new CLIController();
        CLIController.setClient(client);
        client.setController(CLIController);
        CLIController.startClient();
    }

}
