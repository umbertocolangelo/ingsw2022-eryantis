package it.polimi.ingsw.client.view.gui.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class GuiStartController {

    /**
     *
     */
    private Stage stage;

    /**
     *
     */
    private Scene scene;

    /**
     * click on next button
     * @param mouseEvent
     */
    public void onClickEvent(MouseEvent mouseEvent) throws IOException {
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/login-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();
    }

}
