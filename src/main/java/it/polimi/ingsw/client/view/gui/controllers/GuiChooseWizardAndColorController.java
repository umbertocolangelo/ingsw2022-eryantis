package it.polimi.ingsw.client.view.gui.controllers;

import it.polimi.ingsw.message.ChooseColorAndDeck;
import it.polimi.ingsw.message.MessageMethod;
import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.enumerations.Wizard;
import it.polimi.ingsw.model.rounds.SetUpRound;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;


public class GuiChooseWizardAndColorController implements Initializable {
    /**
     *
     */
    private LinkedList<Wizard> wizards=new LinkedList<>();


    @FXML
    private ImageView wizard1;
    @FXML
    private ImageView wizard2;
    @FXML
    private ImageView wizard3;
    @FXML
    private ImageView wizard4;
    @FXML
    private RadioButton white;
    @FXML
    private RadioButton grey;
    @FXML
    private RadioButton black;




    /**
     *
     */
    private Stage stage;

    /**
     *
     */
    private Scene scene;

    /**
     *
     */
    private String wizard;

    /**
     *
     */
    private String color;

    /**
     * click on wizard1
     * @param mouseEvent
     */
    public void onWizardClick1(MouseEvent mouseEvent) {
        if(wizard1.getImage()!=null)
        wizard = Wizard.GREEN_WIZARD.getId();
    }

    /**
     * click on wizard2
     * @param mouseEvent
     */
    public void onWizardClick2(MouseEvent mouseEvent) {
        if(wizard2.getImage()!=null)
        wizard = Wizard.YELLOW_WIZARD.getId();
    }

    /**
     * click on wizard3
     * @param mouseEvent
     */
    public void onWizardClick3(MouseEvent mouseEvent) {
        if(wizard3.getImage()!=null)
        wizard = Wizard.PURPLE_WIZARD.getId();

    }

    /**
     * click on wizard4
     * @param mouseEvent
     */
    public void onWizardClick4(MouseEvent mouseEvent) {
        if(wizard4.getImage()!=null)
        wizard = Wizard.BLUE_WIZARD.getId();
    }



    /**
     * click on next button
     * @param mouseEvent
     */
    public void onNextClick(MouseEvent mouseEvent) throws IOException {
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/loading-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();
        MessageMethod messageMethod = new ChooseColorAndDeck();
        ((ChooseColorAndDeck)messageMethod).setWizard(wizard);
        ((ChooseColorAndDeck)messageMethod).setPlayerColor(color);
        ControllerHandler.getInstance().write(messageMethod);
        //ControllerHandler.getInstance().receiveMessage();
    }

    /**
     * click on color white
     * @param mouseEvent
     */
    public void onColorClick1(MouseEvent mouseEvent) {
        color = PlayerColor.WHITE.getId();

    }

    /**
     * click on color black
     * @param mouseEvent
     */
    public void onColorClick2(MouseEvent mouseEvent) {
        color = PlayerColor.BLACK.getId();
    }

    /**
     * click on color grey
     * @param mouseEvent
     */
    public void onColorClick3(MouseEvent mouseEvent) {
        color = PlayerColor.GREY.getId();
    }

    /**
     *
     * @throws IOException
     */
    public void changeScene() throws IOException {
        stage = ControllerHandler.getInstance().getStage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/pianificationPhase-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();
    }

    /**
     *
     * @param mouseEvent
     */
    public void lightUp(MouseEvent mouseEvent) {

    }

    /**
     *
     * @param mouseEvent
     */
    public void turnOff(MouseEvent mouseEvent) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Game game=ControllerHandler.getInstance().getClient().getGame();
        ((SetUpRound)game.getCurrentRound()).getplayerColor();
        if(!((SetUpRound)game.getCurrentRound()).getWizards().contains(Wizard.GREEN_WIZARD)) {
            wizard1.setDisable(false);
            wizard1.setImage(null);
        }
        if(!((SetUpRound)game.getCurrentRound()).getWizards().contains(Wizard.YELLOW_WIZARD)) {
            wizard2.setImage(null);
            wizard2.setVisible(false);
        }
        if(!((SetUpRound)game.getCurrentRound()).getWizards().contains(Wizard.PURPLE_WIZARD)) {
            wizard3.setImage(null);
            wizard3.setVisible(false);
        }
        if(!((SetUpRound)game.getCurrentRound()).getWizards().contains(Wizard.BLUE_WIZARD)){
            wizard4.setVisible(false);
            wizard4.setImage(null);
        }

        if (!((SetUpRound)game.getCurrentRound()).getplayerColor().contains(PlayerColor.WHITE)){
            white.setDisable(false);
            white.setVisible(false);
        }

        if (!((SetUpRound)game.getCurrentRound()).getplayerColor().contains(PlayerColor.BLACK)) {
            black.setVisible(false);
            black.setDisable(false);
        }
        if (!((SetUpRound)game.getCurrentRound()).getplayerColor().contains(PlayerColor.GREY)) {
            grey.setVisible(false);
            grey.setDisable(false);
        }
    }
}
