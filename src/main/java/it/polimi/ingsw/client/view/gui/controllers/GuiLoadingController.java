package it.polimi.ingsw.client.view.gui.controllers;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GuiLoadingController {

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

        //scenePane.translateXProperty().bind(scene.widthProperty().subtract(scenePane.widthProperty().divide(2)));
        //scenePane.translateYProperty().bind(scene.heightProperty().subtract(scenePane.heightProperty().divide(2)));

        stage.widthProperty().addListener((obs, oldVal, newVal) -> {
            double scaleX = newVal.doubleValue()/width;
            scenePane.setScaleX(scaleX);
            scenePane.setTranslateX(scenePane.getTranslateX() + (newVal.doubleValue()-oldVal.doubleValue())/2);
            //scenePane.setCenterShape(true);
        });

        stage.heightProperty().addListener((obs, oldVal, newVal) -> {
            double scaleY = newVal.doubleValue()/height;
            scenePane.setScaleY(scaleY);
            scenePane.setTranslateY(scenePane.getTranslateY() + (newVal.doubleValue()-oldVal.doubleValue())/2);
            //scenePane.setCenterShape(true);
        });
    }

    /**
     *
     */
    public void closeStage() {
        this.stage.close();
    }

    /**
     *
     * @return
     */
    public Stage getStage() {
        return stage;
    }

    /**
     * Sets the label text and position when is not the player turn
     */
    public void setWaitText() {
        loadingIndicator.setText("Waiting for your turn...");
        loadingIndicator.setLayoutX(432);
    }

}
