package it.polimi.ingsw.client.view.gui.controllers;

import it.polimi.ingsw.message.MessageMethod;
import it.polimi.ingsw.message.PlayExpertCard;
import it.polimi.ingsw.model.Game;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class GuiSelectPlayerCard implements Initializable {

    /**
     *
     */
    private Game game;

    /**
     *
     */
    private String player;

    @FXML
    private Button player1;
    @FXML
    private Button player2;
    @FXML
    private Button player3;


    /**
     * Build the scene select a Player Color as an expert card
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        game=ControllerHandler.getInstance().getClient().getGame();
        player1.setText(game.getPlayerList().get(0).getName());
        player2.setText(game.getPlayerList().get(1).getName());
        if(game.getPlayerList().size()==3)
            player2.setText(game.getPlayerList().get(2).getName());
        else{
            player3.setDisable(false);
            player3.setVisible(false);
        }
    }


    public void clickSelectPlayer(MouseEvent mouseEvent) {
        MessageMethod playExpertCard=new PlayExpertCard();
        ((PlayExpertCard)playExpertCard).setExpertCard("45");
        ((PlayExpertCard)playExpertCard).setParameter(player);
        ControllerHandler.getInstance().write(playExpertCard);
    }

    public void clickPlayer0(MouseEvent mouseEvent) {
        player=game.getPlayerList().get(0).getId();
    }

    public void clickPlayer3(MouseEvent mouseEvent) {
        player=game.getPlayerList().get(1).getId();
    }

    public void clickPlayer2(MouseEvent mouseEvent) {
        player=game.getPlayerList().get(2).getId();
    }
}
