package it.polimi.ingsw.client.view.gui.controllers;

import it.polimi.ingsw.client.Client;
import it.polimi.ingsw.client.ClientState;
import it.polimi.ingsw.message.IngressCardSwap;
import it.polimi.ingsw.message.StudentToIsland;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.ConnectException;


public class GUIController {

    /**
     *
     */
    private Boolean connectionTrue=false;

    /**
     *
     */
    private Boolean connectionRefuse=false;

    /**
     * Reference to the name of the client lost
     */
    private String nameClientLost;

    /**
     * Set true when a card that needs an island as parameter has been played
     */
    private Boolean cardNeedIsland = false;

    /**
     * Not used
     */
    private Boolean finishTurn = false;

    /**
     * Message method student To Island
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
    private Boolean needRefresh = false;
    /**
     * Need to use the message in view
     */
    private Boolean cardPlayed = false;

    /**
     * True if e chose an equal name
     */
    private Boolean equal = false;

    /**
     * Set true if isFirst, for change scene
     */
    private Boolean isFirst = false;

    /**
     * Keep the reference to stage
     */
    private static Stage stage;

    /**
     * Keep the reference to client
     */
    private Client client;

    /**
     * Keep the reference to clientState
     */
    private ClientState clientState;

    /**
     * static reference to controller handler
     *
     * @param client
     */
    private static GUIController GUIController;

    /**
     * Default constructor
     */
    public GUIController() {

    }

    /**
     * Gives controller handler instance
     *
     * @return the instance of the controller handler
     */
    public static GUIController getInstance() {
        if (GUIController == null) {
            GUIController = new GUIController();
        }
        return GUIController;
    }

    /**
     * Receive message from login
     */
    public void receiveMessage() {
        client.asyncReadFromSocket(client.getOut());
    }

    /**
     * Get client reference
     *
     * @return
     */
    public Client getClient() {
        return this.client;
    }

    /**
     * Get stage reference
     *
     * @return
     */
    public Stage getStage() {
        return stage;
    }

    /**
     * Get stage reference
     *
     * @param stage
     */
    public static void setStage(Stage stage) {
        GUIController.stage = stage;
    }

    /**
     * Set client state
     *
     * @param clientState
     */
    public void setClientState(ClientState clientState) {
        this.clientState = clientState;
    }

    /**
     * Set client
     *
     * @param client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Set the correct scene in the gui
     *
     * @throws IOException
     */
    public Thread chooseScene() throws IOException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                switch (clientState) {
                    case CLIENTLOST:
                        nameClientLost = client.getNamePLayerLost();
                        GuiLoadingController loadingController = new GuiLoadingController();
                        Platform.runLater(() -> {
                            try {
                                loadingController.clientLost();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                        break;
                    case WAITING:
                        GuiPortIpController starting = new GuiPortIpController();
                        Platform.runLater(() -> {
                            try {
                                starting.waiting();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                        break;
                    case CONNECTIONREFUSE:
                        GuiPortIpController startController = new GuiPortIpController();
                        Platform.runLater(() -> {
                            try {
                                startController.refresh();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                        break;
                    case LOGIN:
                    GuiPortIpController start = new GuiPortIpController();
                    Platform.runLater(() -> {
                        try {
                            start.login();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
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
                    case LOAD:
                        GuiLoadGameController loadController = new GuiLoadGameController();
                        Platform.runLater(() -> {
                            try {
                                loadController.show();
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
                        if (client.getGame().getCurrentRound().getId() != null) {
                            if (client.getGame().getCurrentRound().getId() == 0 || client.getGame().getCurrentRound().getId() == 3 || client.getGame().getCurrentRound().getId() == 2) {
                                GuiChooseExpertCardController cardController = new GuiChooseExpertCardController();
                                Platform.runLater(() -> {
                                    try {
                                        System.out.println("Change scene normal");
                                        cardController.sceneStudentOnCard();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                });
                            } else if (client.getGame().getCurrentRound().getId() == 1) {
                                GuiActionPhaseController actionController = new GuiActionPhaseController();
                                Platform.runLater(() -> {
                                    try {
                                        actionController.refresh();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                });
                            }
                        } else {
                            switch (client.getGame().getCurrentPlayer().getPlayerPhase()) {
                                //change scene from login to deck/color phase
                                case SET_UP_PHASE:
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
                                                System.out.println("Change scene not normal");
                                                controllerFirst.changeScene();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                        });
                                    }
                                    break;
                                //change scene from deck/color phase to choosing assistant card
                                case CHOOSING_ASSISTANT:
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
                                //change scene from choosing assistant card to moving students and mn
                                case MOVING_STUDENTS:
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
                                case WINNER:
                                    GuiActionPhaseController winnerController = new GuiActionPhaseController();
                                    Platform.runLater(() -> {
                                        try {
                                            winnerController.winnerScene();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    });
                                    break;
                            }
                        }
                }
            }

        });
        t.start();
        return t;
    }

    /**
     * This method write to the server socket synchronized with the read
     *
     * @param object the object we need to send
     */
    public void write(Object object) {
        synchronized (client) {
            try {
                System.out.println("Writing");
                client.getIn().writeObject(object);
                client.getIn().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Set true if this client is the first one
     */
    public void setIsFirst() {
        this.isFirst = true;
    }

    /**
     * Set equal name boolean
     */
    public void setEqual() {
        this.equal = true;
    }

    /**
     * Get equal name boolean
     *
     * @return
     */
    public Boolean getEqual() {
        return this.equal;
    }

    /**
     * Get the selected assistant card
     *
     * @return
     */
    public Boolean getCardPlayed() {
        return this.cardPlayed;
    }

    /**
     * Set the assistant card played
     *
     * @param cardPlayed
     */
    public void setCardPlayed(Boolean cardPlayed) {
        this.cardPlayed = cardPlayed;
    }

    /**
     * Get the id of the expert card played
     *
     * @return
     */
    public String getIdExpertCardPlayed() {
        return this.idExpertCardPlayed;
    }

    /**
     * Set the id of the expert card played
     *
     * @param idExpertCardPlayed
     */
    public void setIdExpertCardPlayed(String idExpertCardPlayed) {
        this.idExpertCardPlayed = idExpertCardPlayed;
    }

    /**
     * Get the type of message method to send at the model
     *
     * @return
     */
    public IngressCardSwap getMessageMethod() {
        return this.messageMethodIngressCard;
    }

    /**
     * Set the type of message method to send at the model
     *
     * @param messageMethod
     */
    public void setMessageMethodIngressCard(IngressCardSwap messageMethod) {
        this.messageMethodIngressCard = messageMethod;
    }

    /**
     * Get finished turn boolean
     *
     * @return
     */
    public Boolean getFinishTurn() {
        return this.finishTurn;
    }

    /**
     * Set finished turn boolean
     *
     * @param finishTurn
     */
    public void setFinishTurn(Boolean finishTurn) {
        this.finishTurn = finishTurn;
    }

    /**
     * Get the student of studentToIsland expert card effect
     *
     * @return
     */
    public StudentToIsland getStudentToIsland() {
        return this.studentToIsland;
    }

    /**
     * Get the student studentToIsland expert card effect
     *
     * @param studentToIsland
     */
    public void setStudentToIsland(StudentToIsland studentToIsland) {
        this.studentToIsland = studentToIsland;
    }

    /**
     * Get if is needed an island because of an expert card effect
     *
     * @return
     */
    public Boolean getCardNeedIsland() {
        return this.cardNeedIsland;
    }

    /**
     * Set if is needed an island because of an expert card effect
     *
     * @param cardNeedIsland
     */
    public void setCardNeedIsland(Boolean cardNeedIsland) {
        this.cardNeedIsland = cardNeedIsland;
    }

    /**
     * Get the name of the client lost
     *
     * @return
     */
    public String getNameClientLost() {
        return this.nameClientLost;
    }


    /**
     *
     */
    public void startClient() throws ConnectException,IOException {
       // Client client = new Client("localhost", 65432);

            //final ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(128);
       // try {
            Thread t1 = new Thread(client.run());

           t1.start();

    }


    public Boolean getConnectionRefuse() {
        return connectionRefuse;
    }

    public void setConnectionRefuse(Boolean connectionRefuse) {
        this.connectionRefuse = connectionRefuse;
    }

    public Boolean getConnectionTrue() {
        return connectionTrue;
    }

    public void setConnectionTrue(Boolean connectionTrue) {
        this.connectionTrue = connectionTrue;
    }
}

