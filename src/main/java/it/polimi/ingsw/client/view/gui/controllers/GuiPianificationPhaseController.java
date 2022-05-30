package it.polimi.ingsw.client.view.gui.controllers;

import it.polimi.ingsw.model.enumerations.AssistantCard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class GuiPianificationPhaseController {

    /**
     *
     */
    @FXML
    private AnchorPane scenePane;

    /**
     *
     */
    private String assistantCard;

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
    private AnchorPane anchorPane;


    /**
     * click to show rules
     * @param mouseEvent
     */
    public void onRulesClick(MouseEvent mouseEvent) {

    }

    /**
     * select card 1
     * @param mouseEvent
     */
    public void onCard1Click(MouseEvent mouseEvent) {
        assistantCard = AssistantCard.ONE_CARD.getId();
    }

    /**
     * select card 2
     * @param mouseEvent
     */
    public void onCard2Click(MouseEvent mouseEvent) {
        assistantCard = AssistantCard.TWO_CARD.getId();
    }

    /**
     * select card 3
            * @param mouseEvent
     */
    public void onCard3Click(MouseEvent mouseEvent) {
        assistantCard = AssistantCard.THREE_CARD.getId();
    }

    /**
     * select card 4
     * @param mouseEvent
     */
    public void onCard4Click(MouseEvent mouseEvent) {
        assistantCard = AssistantCard.FOUR_CARD.getId();
    }

    /**
     * select card 5
     * @param mouseEvent
     */
    public void onCard5Click(MouseEvent mouseEvent) {
        assistantCard = AssistantCard.FIVE_CARD.getId();
    }

    /**
     * select card 6
     * @param mouseEvent
     */
    public void onCard6Click(MouseEvent mouseEvent) {
        assistantCard = AssistantCard.SIX_CARD.getId();
    }

    /**
     * select card 7
     * @param mouseEvent
     */
    public void onCard7Click(MouseEvent mouseEvent) {
        assistantCard = AssistantCard.SEVEN_CARD.getId();
    }

    /**
     * select card 8
     * @param mouseEvent
     */
    public void onCard8Click(MouseEvent mouseEvent) {
        assistantCard = AssistantCard.EIGHT_CARD.getId();
    }

    /**
     * select card 9
     * @param mouseEvent
     */
    public void onCard9Click(MouseEvent mouseEvent) {
        assistantCard = AssistantCard.NINE_CARD.getId();
    }

    /**
     * select card 10
     * @param mouseEvent
     */
    public void onCard10Click(MouseEvent mouseEvent) {
        assistantCard = AssistantCard.TEN_CARD.getId();
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
    }

    /**
     *
     * @throws IOException
     */
    public void changeScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/loading-view.fxml"));
        stage = (Stage)scenePane.getScene().getWindow();
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * TODO
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
