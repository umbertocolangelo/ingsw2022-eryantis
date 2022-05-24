package it.polimi.ingsw.client.view.gui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class GuiLoginController {

    @FXML
    AnchorPane scenePane;

    @FXML
    private RadioButton twoPlayers;

    /**
     *
     */
    private Stage stage;

    /**
     *
     */
    private Scene scene;



    /**
     * click on start button
     * @param mouseEvent
     */
    public void onClickEvent(MouseEvent mouseEvent) throws IOException {

        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/loading-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();
        ControllerHandler.getInstance().write("virepo");
        ControllerHandler.getInstance().write("2");
        ControllerHandler.getInstance().write("0");
        ControllerHandler.getInstance().receiveMessage();



    }

    public void changeScene() throws IOException {

        stage= ControllerHandler.getInstance().getStage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/deckAndColor-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();

    }

    /**
     *
     */
    public void twoPlayers(MouseEvent mouseEvent) {

    }

    /**
     *
     */
    public void threePlayers(MouseEvent mouseEvent) {
    }

    /**
     *
     * @param mouseEvent
     */
    public void classicGame(MouseEvent mouseEvent) {
    }

    /**
     *
     * @param mouseEvent
     */
    public void expertGame(MouseEvent mouseEvent) {
    }

}
