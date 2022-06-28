package it.polimi.ingsw.client.view.gui.controllers;

import it.polimi.ingsw.message.IsFirst;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GuiConnectionLost {

    @FXML
    private AnchorPane scenePane;

    /**
     *
     */
    private Stage stage;

    /**
     *
     */
    private Scene scene;

    public void connectionLost() throws IOException {
        stage = GUIController.getInstance().getStage();

        double x = stage.getX();
        double y = stage.getY();
        double width = stage.getWidth();
        double height = stage.getHeight();

        stage = new Stage();
        GUIController.getInstance().getStage().close();
        GUIController.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/connectionLost-view.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("Eriantys");
        stage.show();

        GuiConnectionLost controller = fxmlLoader.getController();
        controller.resize(stage);
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setX(x);
        stage.setY(y);
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
}
