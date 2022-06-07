package it.polimi.ingsw.message;

import java.io.Serializable;

public class ClientLost implements Serializable {

    /**
     * THe name of the player that has been diconneted
     */
    private String namePlayerLost;

    public String getNamePlayerLost() {
        return namePlayerLost;
    }

    public void setNamePlayerLost(String namePlayerLost) {
        this.namePlayerLost = namePlayerLost;
    }

    public ClientLost(String namePlayerLost){
        this.namePlayerLost=namePlayerLost;
    }
}
