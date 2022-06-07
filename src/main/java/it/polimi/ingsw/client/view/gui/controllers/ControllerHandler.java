package it.polimi.ingsw.client.view.gui.controllers;

import it.polimi.ingsw.client.Client;
import it.polimi.ingsw.client.ClientState;
import it.polimi.ingsw.client.view.gui.GuiMain;
import it.polimi.ingsw.message.IngressCardSwap;
import it.polimi.ingsw.message.StudentToIsland;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.io.IOException;


public class ControllerHandler {
    /**
     *
     */
    private String nameClientLost;

    /**
     *Set true when a cadr that needs an island as parameter has been played
     */
    private Boolean cardNeedIsland=false;

    /**
     *Not used
     */
    private Boolean finishTurn=false;

    /**
     *Message method student To Island
     */
    private StudentToIsland studentToIsland;

    /**
     * Keep the reference of the message methode, useful for the expertCard implemented in Rounds
     */
    private IngressCardSwap messageMethodIngressCard;

    /**
     * Keep the reference to the expertCard played
     */
    private String idExpertCardPlayed;

    /**
     * Used to set choose which loading view is the right one to call
     */
    private Boolean needRefresh=false;
    /**
     *Need to use the messagge in view
     */
    private Boolean cardPlayed=false;

    /**
     *True if e chose an equal name
     */
    private Boolean equal=false;

    /**
     * Set true if isFirst, for change scene
     */
    private Boolean isFirst=false;

    /**
     *Keep the reference to stage
     */
    private static Stage stage;

    /**
     *Keep the reference to client
     */
    private Client client;

    /**
     *Keep the reference to clientState
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
            case CLIENTLOST:
                nameClientLost=client.getNamePLayerLost();
                GuiLoadingController loadingController=new GuiLoadingController();
                Platform.runLater(() -> {
                    try {
                        loadingController.clientLost();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                break;
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
                if(client.getGame().getCurrentRound().getId()!=null){
                    if(client.getGame().getCurrentRound().getId()==0 || client.getGame().getCurrentRound().getId()==3 || client.getGame().getCurrentRound().getId()==2) {
                        GuiChooseExpertCardController cardController = new GuiChooseExpertCardController();
                        Platform.runLater(() -> {
                            try {
                                System.out.println("Change scene normal");
                                cardController.sceneStudentOnCard();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                    }else   if(client.getGame().getCurrentRound().getId()==1){
                        GuiActionPhaseController actionController = new GuiActionPhaseController();
                        Platform.runLater(() -> {
                            try {
                                actionController.refresh();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                }

                }else {
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
                            } else {
                                GuiIsFirstController controllerFirst = new GuiIsFirstController();
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
                            if (!needRefresh) {
                                GuiChooseWizardAndColorController colorController = new GuiChooseWizardAndColorController();
                                Platform.runLater(() -> {
                                    try {
                                        colorController.changeScene();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                });
                            } else {
                                GuiActionPhaseController colorController = new GuiActionPhaseController();
                                Platform.runLater(() -> {
                                    try {
                                        colorController.changeScene();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                });
                            }
                            break;
                        case MOVING_STUDENTS://cambio scena da choosing assistant card a moving students and mn
                            if (!needRefresh) {
                                needRefresh = true;
                                GuiPianificationPhaseController assistantController = new GuiPianificationPhaseController();
                                Platform.runLater(() -> {
                                    try {
                                        assistantController.changeScene();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                });
                            } else {
                                GuiActionPhaseController actionController = new GuiActionPhaseController();
                                Platform.runLater(() -> {
                                    try {
                                        actionController.refresh();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                });
                            }
                            break;

                        case MOVING_MOTHERNATURE, CHOOSING_CLOUD:
                            GuiActionPhaseController movingMotherNatureController = new GuiActionPhaseController();
                            Platform.runLater(() -> {
                                try {
                                    movingMotherNatureController.refresh();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            });
                            break;

                    }
                }
         //   case WINNER:



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

    public Boolean getCardPlayed() {
        return cardPlayed;
    }

    public void setCardPlayed(Boolean cardPlayed) {
        this.cardPlayed = cardPlayed;
    }

    public String getIdExpertCardPlayed() {
        return idExpertCardPlayed;
    }

    public void setIdExpertCardPlayed(String idExpertCardPlayed) {
        this.idExpertCardPlayed = idExpertCardPlayed;
    }

    public IngressCardSwap getMessageMethod() {
        return messageMethodIngressCard;
    }

    public void setMessageMethodIngressCard(IngressCardSwap messageMethod) {
        this.messageMethodIngressCard = messageMethod;
    }

    public Boolean getFinishTurn() {
        return finishTurn;
    }

    public void setFinishTurn(Boolean finishTurn) {
        this.finishTurn = finishTurn;
    }

    public StudentToIsland getStudentToIsland() {
        return studentToIsland;
    }

    public void setStudentToIsland(StudentToIsland studentToIsland) {
        this.studentToIsland = studentToIsland;
    }

    public Boolean getCardNeedIsland() {
        return cardNeedIsland;
    }

    public void setCardNeedIsland(Boolean cardNeedIsland) {
        this.cardNeedIsland = cardNeedIsland;
    }

    public String getNameClientLost() {
        return nameClientLost;
    }
}
