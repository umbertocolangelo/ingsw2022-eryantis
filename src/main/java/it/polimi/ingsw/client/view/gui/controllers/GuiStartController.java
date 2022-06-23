package it.polimi.ingsw.client.view.gui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class GuiStartController {

    @FXML
    private AnchorPane scenePane;

    @FXML
    private Text connection;

    /**
     * Reference to the stage
     */
    private Stage stage;

    /**
     * Reference to the scene
     */
    private Scene scene;


    public void onClickEvent(MouseEvent mouseEvent) throws IOException {

            stage = new Stage();
            GUIController.getInstance().getStage().close();
            GUIController.setStage(stage);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/portIp-view.fxml"));
            scene = new Scene(fxmlLoader.load(), 1280, 720);
            stage.setScene(scene);
            stage.setTitle("Eriantys");
            stage.show();

            GuiPortIpController loginController = fxmlLoader.getController();
            loginController.resize(stage);

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
