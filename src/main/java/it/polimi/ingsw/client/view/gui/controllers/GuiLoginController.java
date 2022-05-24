package it.polimi.ingsw.client.view.gui.controllers;

import it.polimi.ingsw.client.ClientState;
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
        ControllerHandler.getInstance().setClientState(ClientState.SLEEPING);
        ControllerHandler.getInstance().chooseScene();
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        /**FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/login-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();
         */
    }

    public void changeScene() throws IOException {

       /** FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/fxml/login-view.fxml"));
        fxmlLoader1.setController(this);
        scenePane= (AnchorPane) fxmlLoader1.load();
        System.out.println(scenePane);
        */
        stage= ControllerHandler.getInstance().getStage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/loading-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();

    }



}
