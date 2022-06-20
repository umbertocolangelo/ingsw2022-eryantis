package it.polimi.ingsw.client.view.gui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GuiLoadingController {
    /**
     *
     */
    private Scene scene;

    /**
     *
     */
    @FXML
    public AnchorPane scenePane;

    /**
     *
     */
    @FXML
    private Label loadingIndicator;


    /**
     *
     */
    private Stage stage;

    /**
     *
     */
    public GuiLoadingController() {

    }

    /**
     *
     */
    public void resize(Stage stage, Scene scene) {
        double height = stage.getHeight();
        double width = stage.getWidth();

        stage.setMinHeight(450);
        stage.setMinWidth(800);

        stage.widthProperty().addListener((obs, oldVal, newVal) -> {
            double scaleX = newVal.doubleValue()/width;
            scenePane.setScaleX(scaleX);
            scenePane.setTranslateX(scenePane.getTranslateX() + (newVal.doubleValue()-oldVal.doubleValue())/2);
        });

        stage.heightProperty().addListener((obs, oldVal, newVal) -> {
            double scaleY = newVal.doubleValue()/height;
            scenePane.setScaleY(scaleY);
            scenePane.setTranslateY(scenePane.getTranslateY() + (newVal.doubleValue()-oldVal.doubleValue())/2);
        });
    }

    /**
     * Sets the label text and position when is not the player turn
     */
    public void setWaitText() {
        loadingIndicator.setText("Waiting for your turn...");
        loadingIndicator.setLayoutX(432);
    }

    public void clientLost() throws IOException {
        stage = new Stage();
        ControllerHandler.getInstance().getStage().close();
        ControllerHandler.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/clientLost-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.setTitle("Eriantys");
        stage.show();

        GuiClientLost guiClientLost = fxmlLoader.getController();
        guiClientLost.resize(stage, scene);
    }

}
