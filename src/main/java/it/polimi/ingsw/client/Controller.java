package it.polimi.ingsw.client;

import java.util.Scanner;

public class Controller {
    private Scanner stdIn;

    public Controller(Client client){
        this.stdIn=client.getScanner();
    }


}
