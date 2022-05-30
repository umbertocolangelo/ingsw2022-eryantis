package it.polimi.ingsw.client.view.gui.controllers;

import it.polimi.ingsw.message.IsFirst;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class GuiIsFirstController {

    /**
     *
     */
    @FXML
    private RadioButton twoPlayers;

    /**
     *
     */
    @FXML
    private RadioButton threePlayers;

    /**
     *
     */
    @FXML
    private RadioButton expertMode;

    /**
     *
     */
    @FXML
    private RadioButton classicMode;

    /**
     *
     */
    private Integer numOfPLayers;

    /**
     *
     */
    private Boolean expertModeOrClassic;

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
    public void onStartClick(MouseEvent mouseEvent) throws IOException {
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/loading-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();
        IsFirst isFirst=new IsFirst();

        isFirst.setGameMode(expertModeOrClassic);
        isFirst.setPlayers(numOfPLayers);
        ControllerHandler.getInstance().write(isFirst);


    }

    /**
     *
     * @throws IOException
     */
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
        numOfPLayers = 2;
    }

    /**
     *
     */
    public void threePlayers(MouseEvent mouseEvent) {
        numOfPLayers = 3;
    }

    /**
     *
     * @param mouseEvent
     */
    public void classicGame(MouseEvent mouseEvent) {
        expertModeOrClassic =false;
    }

    /**
     *
     * @param mouseEvent
     */
    public void expertGame(MouseEvent mouseEvent) {
        expertModeOrClassic = true;
    }

}
