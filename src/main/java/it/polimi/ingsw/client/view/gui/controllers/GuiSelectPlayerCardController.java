package it.polimi.ingsw.client.view.gui.controllers;

import it.polimi.ingsw.message.MessageMethod;
import it.polimi.ingsw.message.PlayExpertCard;
import it.polimi.ingsw.model.Game;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class GuiSelectPlayerCardController implements Initializable {

    @FXML
    private AnchorPane scenePane;
    @FXML
    private Button player1;
    @FXML
    private Button player2;
    @FXML
    private Button player3;

    /**
     * Reference to game
     */
    private Game game;

    /**
     * Reference to player
     */
    private String player;

    /**
     * Build the scene select a Player Color as an expert card
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        game = GUIController.getInstance().getClient().getGame();
        player1.setText(game.getPlayerList().get(0).getName());
        player2.setText(game.getPlayerList().get(1).getName());
        if (game.getPlayerList().size()==3) {
            player2.setText(game.getPlayerList().get(2).getName());
        } else {
            player3.setDisable(false);
            player3.setVisible(false);
        }
    }

    /**
     * Click on selected card
     * @param mouseEvent
     */
    public void clickSelectPlayer(MouseEvent mouseEvent) {
        if (player!=null) {
            MessageMethod playExpertCard = new PlayExpertCard();
            ((PlayExpertCard) playExpertCard).setExpertCard("45");
            ((PlayExpertCard) playExpertCard).setParameter(player);
            GUIController.getInstance().write(playExpertCard);
        }
    }

    /**
     * Click on player zero
     * @param mouseEvent
     */
    public void clickPlayer0(MouseEvent mouseEvent) {
        player = game.getPlayerList().get(0).getId();
    }

    /**
     * Click on player one
     * @param mouseEvent
     */
    public void clickPlayer1(MouseEvent mouseEvent) {
        player = game.getPlayerList().get(1).getId();
    }

    /**
     * Click on player two
     * @param mouseEvent
     */
    public void clickPlayer2(MouseEvent mouseEvent) {
        player = game.getPlayerList().get(2).getId();
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
