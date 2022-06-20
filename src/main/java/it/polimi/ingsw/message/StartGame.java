package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.player.Player;

import java.io.Serializable;
import java.util.LinkedList;

public class StartGame implements Serializable, MessageMethod {

    /**
     * List of the players of this game
     */
    public LinkedList<Player> players;

    /**
     * Game mode, expert or normal
     */
    public Boolean gameMode = true;

    /**
     * Sets game settings
     * @param game
     */
    @Override
    public void apply(Game game) {
        game.setPlayerList(players);
        if (gameMode==false) {
            game.setNormalMode();
        }
        //Coins prova
        for (int i =0; i<game.getPlayerList().size(); i++) {
            game.getPlayerList().get(i).setCoin(5);
        }
        game.initializeGame();
       game.getCardManager().setDeck("44");
    }

    /**
     * Sets players
     * @param players
     */
    public void setPlayers(LinkedList<Player> players) {
        this.players = players;
    }

    /**
     * Sets game mode
     * @param gameMode
     */
    public void setGameMode(Boolean gameMode) {
        this.gameMode = gameMode;
    }

}
