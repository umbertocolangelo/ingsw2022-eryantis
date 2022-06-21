package it.polimi.ingsw.client.view.gui.controllers;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GuiWinnerController {

    @FXML
    private AnchorPane scenePane;
    /**
     * Text field
     */
    @FXML
    private Label winner1;
    @FXML
    private Label winner2;
    @FXML
    private Label winner3;
    @FXML
    private Label loser1;
    @FXML
    private Label loser2;

    /**
     * Reference to the stage
     */
    private Stage stage;

    /**
     * Reference to the scene
     */
    private Scene scene;

    /**
     * Sets the label text when client wins
     */
    public void setWinnerText() {
        loser1.setVisible(false);
        loser2.setVisible(false);
    }

    /**
     * Sets the label text when client loses
     */
    public void setLoserText() {
        winner1.setVisible(false);
        winner2.setVisible(false);
        winner3.setVisible(false);
    }

    /**
     * Window resize
     */
    public void resize(Stage stage) {
        double height = stage.getHeight();
        double width = stage.getWidth();

        //stage min sizes
        stage.setMinHeight(450);
        stage.setMinWidth(800);

        //horizontal listener
        stage.widthProperty().addListener((obs, oldVal, newVal) -> {
            double scaleX = newVal.doubleValue()/width;
            scenePane.setScaleX(scaleX);
            scenePane.setTranslateX(scenePane.getTranslateX() + (newVal.doubleValue()-oldVal.doubleValue())/2);
        });

        //vertical listener
        stage.heightProperty().addListener((obs, oldVal, newVal) -> {
            double scaleY = newVal.doubleValue()/height;
            scenePane.setScaleY(scaleY);
            scenePane.setTranslateY(scenePane.getTranslateY() + (newVal.doubleValue()-oldVal.doubleValue())/2);
        });
    }
}
