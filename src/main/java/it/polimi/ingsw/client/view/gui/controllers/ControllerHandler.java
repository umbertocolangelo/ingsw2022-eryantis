package it.polimi.ingsw.client.view.gui.controllers;

import it.polimi.ingsw.client.Client;
import it.polimi.ingsw.client.ClientState;
import it.polimi.ingsw.client.view.gui.GuiMain;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerHandler {
    /**
     *
     */
    private static Stage stage;

    /**
     *
     */
    private Client client;

    /**
     *
     */
    private ClientState clientState;

    /**
     *
     * @param client
     */
    private static ControllerHandler controllerHandler;


    public ControllerHandler() {



    }
    public static ControllerHandler getInstance(){
        if (controllerHandler==null)
            controllerHandler=new ControllerHandler();
        return controllerHandler;
    }

    public void setClient(Client client){
        this.client= client;
    }

    public void chooseScene() throws IOException {

    switch (clientState)

    {
        case LOGIN:
            GuiMain guiMain = new GuiMain();
            guiMain.launchApp();
            break;
        case PLAYING:
            switch (client.getGame().getCurrentPlayer().getPlayerPhase()) {
                case SET_UP_PHASE:
                        System.out.println("Setup");
                        GuiLoginController controller = new GuiLoginController();
                        Platform.runLater(() -> {
                         try {
                        controller.changeScene();
                        } catch (IOException e) {
                        e.printStackTrace();
                        }
                         });
                        break;
                case CHOOSING_ASSISTANT:
                    GuiChooseWizardAndColorController colorController=new GuiChooseWizardAndColorController();
                    Platform.runLater(() -> {
                        try {
                            colorController.changeScene();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
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

    public void receiveMessage(){
       client.asyncReadFromSocket(client.getOUt());

    }

    public Client getClient(){
        return this.client;
    }

    public static void setStage(Stage stage) {
        ControllerHandler.stage = stage;
    }

    public Stage getStage() {
    return stage;
    }

    public void setClientState(ClientState clientState){
        this.clientState=clientState;
    }

}
