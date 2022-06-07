package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.player.Player;

import java.io.Serializable;
import java.util.LinkedList;

public class StartGame implements Serializable, MessageMethod {
    /**
     *
     */
    public LinkedList<Player> players;

    /**
     *
     */
    public Boolean gameMode=true;

    /**
     * @param game
     */
    @Override
    public void apply(Game game) {
        game.setPlayerList(players);
        if(gameMode==false)
            game.setNormalMode();
        for (int i =0; i<game.getPlayerList().size(); i++) //Necessario per far giocare le play expertCArd
            game.getPlayerList().get(i).setCoin(5);
        game.initializeGame();
        game.getCardManager().setDeck("38");



    }

    public void setPlayers(LinkedList<Player> players){
        this.players=players;
    }

    public void setGameMode(Boolean gameMode){
        this.gameMode=gameMode;
    }

}
