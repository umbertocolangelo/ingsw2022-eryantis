package it.polimi.ingsw;

import it.polimi.ingsw.client.Client;
import it.polimi.ingsw.client.Controller;

public class ClientAppCLI {

    public  static void main(String[] args) {
        Client client = new Client("localhost", 65432);
        Controller controller=new Controller();
        controller.setClient(client);
        client.setController(controller);
        controller.startClient();
    }

}
