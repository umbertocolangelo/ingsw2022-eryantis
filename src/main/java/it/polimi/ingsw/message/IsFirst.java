package it.polimi.ingsw.message;

import java.io.Serializable;

public class IsFirst implements Serializable {

    /**
     * Reference to player num
     */
    public Integer playersNumber;

    /**
     * Reference to expert or classic mode
     */
    public Boolean gameMode = true;

    /**
     * Sets the number of player
     * @param players
     */
    public void setPlayers(Integer players){
        this.playersNumber = players;
    }

    /**
     * Sets expert or normal game mode
     * @param gameMode
     */
    public void setGameMode(Boolean gameMode){
        this.gameMode = gameMode;
    }

    /**
     * @return number of players
     */
    public Integer getPlayersNumber(){
        return this.playersNumber;
    }

    /**
     * @return game mode
     */
    public Boolean getGameMode(){
        return this.gameMode;
    }
}


