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
    private Boolean equal=false;

    /**
     * Set true if isFirst, for change scene
     */
    private Boolean isFirst=false;

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

    /**
     * Default constructor
     */
    public ControllerHandler() {

    }

    /**
     *
     * @return the instance of the controller handler
     */
    public static ControllerHandler getInstance(){
        if (controllerHandler==null) {
            controllerHandler = new ControllerHandler();
        }
        return controllerHandler;
    }

    /**
     *
     */
    public void receiveMessage() {
        client.asyncReadFromSocket(client.getOUt());
    }

    /**
     *
     * @return
     */
    public Client getClient() {
        return this.client;
    }

    /**
     *
     * @return
     */
    public Stage getStage() {
        return stage;
    }

    /**
     *
     * @param stage
     */
    public static void setStage(Stage stage) {
        ControllerHandler.stage = stage;
    }

    /**
     *
     * @param clientState
     */
    public void setClientState(ClientState clientState){
        this.clientState = clientState;
    }

    /**
     *
     * @param client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     *
     * @throws IOException
     */
    public void chooseScene() throws IOException {

        switch (clientState) {
            case LOGIN:
                GuiMain guiMain = new GuiMain();
                guiMain.launchApp();
                break;
            case ISFIRST:
                setIsFirst();
                System.out.println("IsFirst");
                GuiLoginController controller = new GuiLoginController();
                Platform.runLater(() -> {
                    try {
                        controller.changeSceneIsFirst();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                break;
            case EQUALNAME:
                GuiLoginController controllerEqual = new GuiLoginController();
                Platform.runLater(() -> {
                    try {
                        controllerEqual.changeSceneEqual();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                break;
            case PLAYING:
                switch (client.getGame().getCurrentPlayer().getPlayerPhase()) {
                    case SET_UP_PHASE: //cambio scena da login a deck/color phase
                            System.out.println("Setup");
                            GuiLoginController controllerLogin = new GuiLoginController();
                            if (!isFirst) {
                                Platform.runLater(() -> {
                                    try {
                                        System.out.println("Change scene normal");
                                        controllerLogin.changeScene();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                });
                            }
                            else{
                                GuiIsFirstController controllerFirst =new GuiIsFirstController();
                                Platform.runLater(() -> {
                                    try {
                                        System.out.println("Change scene nont normal");

                                        controllerFirst.changeScene();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                });
                            }
                            break;
                    case CHOOSING_ASSISTANT: //cambio scena da deck/color phase a choosing assistant card
                        GuiChooseWizardAndColorController colorController = new GuiChooseWizardAndColorController();
                        Platform.runLater(() -> {
                            try {
                                colorController.changeScene();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                        break;
                    case MOVING_STUDENTS: //cambio scena da choosing assistant card a moving students and mn
                        GuiPianificationPhaseController assistantController = new GuiPianificationPhaseController();
                        Platform.runLater(() -> {
                            try {
                                assistantController.changeScene();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                        break;
                    case CHOOSING_CLOUD: //cambio scena da mooving mn a choosing cloud
                        GuiActionPhaseController actionController = new GuiActionPhaseController();
                        Platform.runLater(() -> {
                            try {
                                actionController.changeScene();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                        break;
                }
            case WINNER:



        }

    }

    /**
     * This method write to the server socket synchronized with the read
     * @param object the object we need to send
     */
    public void write(Object object) {
        synchronized (client) {
            try {
                System.out.println("writing");
                client.getIn().writeObject(object);
                client.getIn().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**Set true if this client is the first one
     *
     */
    public void setIsFirst(){
        this.isFirst=true;
    }


    public void setEqual(){
        this.equal=true;
    }

    public Boolean getEqual(){
        return equal;
    }

}
