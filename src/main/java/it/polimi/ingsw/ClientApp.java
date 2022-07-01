package it.polimi.ingsw;

import it.polimi.ingsw.client.Client;

import java.io.IOException;

/**
 * ClientApp
 */
public class ClientApp {

    /**
     * main
     * @param args String
     */
    public static void main(String[] args) {
        Client client = new Client("localhost", 65432);
        try {
            for (String arg : args) {
                if(arg.equals("--cli") || arg.equals("--c")){
                    client.setIsCli();
                    break;
                }
            }
            client.run();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
