package it.polimi.ingsw.client.view.gui.controllers;

import it.polimi.ingsw.message.Winner;
import it.polimi.ingsw.model.player.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

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

    public void show() throws IOException {
        stage = GUIController.getInstance().getStage();
        double x = stage.getX();
        double y = stage.getY();
        double width = stage.getWidth();
        double height = stage.getHeight();
        stage = new Stage();
        GUIController.getInstance().getStage().close();
        GUIController.setStage(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/winner-view.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("Eriantys");
        stage.show();
        GuiWinnerController winnerController = fxmlLoader.getController();
        winnerController.resize(stage);
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setX(x);
        stage.setY(y);

        for (Player p : GUIController.getInstance().getClient().getGame().getPlayerList()) {
            if (p.getIsWinner() && p.getName().equals(GUIController.getInstance().getClient().getNamePlayer())) {
                winnerController.setWinnerText();
                return;
            }
        }
        winnerController.setLoserText();
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
