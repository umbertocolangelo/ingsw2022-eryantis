package it.polimi.ingsw;

import it.polimi.ingsw.client.Client;
import it.polimi.ingsw.client.view.gui.GuiMain;
import it.polimi.ingsw.client.view.gui.controllers.GUIController;

public class ClientAppGUI3 {
    public  static void main(String[] args) {
        Client client = new Client("localhost", 65432);
        GUIController.getInstance().setClient(client);
        client.setIsGui();
        GuiMain guiMain=new GuiMain();
        guiMain.launchApp();
    }
}


