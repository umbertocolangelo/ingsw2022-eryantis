
package it.polimi.ingsw.client.view.gui.controllers;

import it.polimi.ingsw.message.IsFirst;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GuiLoadGameController {

    /**
     *
     */
    @FXML
    AnchorPane scenePane;

    /**
     *
     */
    @FXML
    Button loadButton;

    /**
     *
     */
    @FXML
    Button newButton;

    /**
     *
     */
    Scene scene;

    /**
     *
     */
    Stage stage;


    public void show() throws IOException {
        stage = new Stage();
        ControllerHandler.getInstance().getStage().close();
        ControllerHandler.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/loadgame-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.setTitle("Eriantys");
        stage.show();
        resize(stage, scene);
    }

    /**
     * Click to load previous game
     * @param mouseEvent
     */
    public void onLoadClick(MouseEvent mouseEvent) throws IOException {
        stage = new Stage();
        ControllerHandler.getInstance().getStage().close();
        ControllerHandler.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/loading-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.setTitle("Eriantys");
        stage.show();
        ControllerHandler.getInstance().write("1");
        GuiLoginController loginController = fxmlLoader.getController();
        loginController.resize(stage, scene);
    }

    /**
     * Click to start a new game and login
     * @param mouseEvent
     */
    public void onNewClick(MouseEvent mouseEvent) throws IOException {
        stage = new Stage();
        ControllerHandler.getInstance().getStage().close();
        ControllerHandler.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/loading-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.setTitle("Eriantys");
        stage.show();
        ControllerHandler.getInstance().write("0");
        GuiLoginController loginController = fxmlLoader.getController();
        loginController.resize(stage, scene);
    }

    /**
     * Window resize
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
}