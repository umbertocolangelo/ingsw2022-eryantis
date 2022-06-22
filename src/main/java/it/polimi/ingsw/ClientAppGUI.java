package it.polimi.ingsw;

import it.polimi.ingsw.client.Client;
import it.polimi.ingsw.client.view.gui.GuiMain;
import it.polimi.ingsw.client.view.gui.controllers.ControllerHandler;

public class ClientAppGUI {

        public  static void main(String[] args) {
            Client client = new Client("localhost", 65432);
            ControllerHandler.getInstance().setClient(client);
            GuiMain guiMain=new GuiMain();
            guiMain.launchApp();
        }
}

