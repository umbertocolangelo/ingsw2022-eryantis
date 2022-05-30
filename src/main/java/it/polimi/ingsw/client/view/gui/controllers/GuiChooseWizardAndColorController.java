package it.polimi.ingsw.client.view.gui.controllers;

import it.polimi.ingsw.message.ChooseColorAndDeck;
import it.polimi.ingsw.message.MessageMethod;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.enumerations.Wizard;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class GuiChooseWizardAndColorController {

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
        wizard = Wizard.GREEN_WIZARD.getId();
    }

    /**
     * click on wizard2
     * @param mouseEvent
     */
    public void onWizardClick2(MouseEvent mouseEvent) {
        wizard = Wizard.BLUE_WIZARD.getId();
    }

    /**
     * click on wizard3
     * @param mouseEvent
     */
    public void onWizardClick3(MouseEvent mouseEvent) {
        wizard = Wizard.PURPLE_WIZARD.getId();
    }

    /**
     * click on wizard4
     * @param mouseEvent
     */
    public void onWizardClick4(MouseEvent mouseEvent) {
        wizard = Wizard.YELLOW_WIZARD.getId();
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
        color = PlayerColor.GREY.getId();
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
        color = PlayerColor.WHITE.getId();
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

}
