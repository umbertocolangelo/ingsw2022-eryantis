package it.polimi.ingsw;

import it.polimi.ingsw.client.Client;
import it.polimi.ingsw.client.view.gui.GuiMain;

public class ClientApp3 {

    public  static void main(String[] args) {
        Client client = new Client("localhost", 65432);
        GuiMain guiMain=new GuiMain();
        guiMain.launchApp();
    }

}
