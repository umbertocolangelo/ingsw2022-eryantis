package it.polimi.ingsw.message;

import java.io.Serializable;

public class IsFirst implements Serializable {

    /**
     *
     */
    public Integer players;

    /**
     *
     */
    public Boolean gameMode=true;



    public void setPlayers(Integer players){
        this.players=players;
    }

    public void setGameMode(Boolean gameMode){
        this.gameMode=gameMode;
    }

    public Integer getPlayers(){
        return this.players;
    }

    public Boolean getGameMode(){
        return this.gameMode;
    }
}


