package it.polimi.ingsw.client.view.gui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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


    /**
     * Click on start button
     * @param mouseEvent
     * @throws IOException
     */
    public void onClickEvent(MouseEvent mouseEvent) throws IOException {
        askPortAndIp();
    }

    /**
     * Enter key is pressed
     * @param keyEvent
     * @throws IOException
     */
    public void onKeyPressed(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            askPortAndIp();
        }
    }


    /**
     * Window resize
     */
    public void resize(Stage stage) {
        double height = stage.getScene().getHeight();
        double width = stage.getScene().getWidth();
        //stage min sizes
        stage.setMinHeight(450);
        stage.setMinWidth(800);


        //horizontal listener
        stage.getScene().widthProperty().addListener((obs, oldVal, newVal) -> {
            double scaleX = (newVal.doubleValue()/width);
            scenePane.setScaleX(scaleX);
            scenePane.setTranslateX(scenePane.getTranslateX() + (newVal.doubleValue()-oldVal.doubleValue())/2);
        });

        //vertical listener
        stage.getScene().heightProperty().addListener((obs, oldVal, newVal) -> {
            double scaleY = (newVal.doubleValue()/height);
            scenePane.setScaleY(scaleY);
            scenePane.setTranslateY(scenePane.getTranslateY() + (newVal.doubleValue()-oldVal.doubleValue())/2);
        });
    }

    /**
     * Show the portIp-view scene
     */
    private void askPortAndIp() throws IOException {
        stage = GUIController.getInstance().getStage();
        double x = stage.getX();
        double y = stage.getY();
        double width = stage.getWidth();
        double height = stage.getHeight();
        stage = new Stage();
        GUIController.getInstance().getStage().close();
        GUIController.setStage(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/portIp-view.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("Eriantys");
        stage.show();
        GuiPortIpController portIpController = fxmlLoader.getController();
        portIpController.resize(stage);
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setX(x);
        stage.setY(y);
    }

}
