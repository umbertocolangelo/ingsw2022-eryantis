package it.polimi.ingsw.message;

import java.io.Serializable;

public class ClientLost implements Serializable {

    /**
     * The name of the player that has been disconnected
     */
    private String namePlayerLost;

    /**
     * Default constructor
     * @param namePlayerLost
     */
    public ClientLost(String namePlayerLost){
        this.namePlayerLost=namePlayerLost;
    }

    /**
     * @return player disconnected
     */
    public String getNamePlayerLost() {
        return this.namePlayerLost;
    }

    /**
     * Sets playerLost name
     * @param namePlayerLost
     */
    public void setNamePlayerLost(String namePlayerLost) {
        this.namePlayerLost = namePlayerLost;
    }

}
