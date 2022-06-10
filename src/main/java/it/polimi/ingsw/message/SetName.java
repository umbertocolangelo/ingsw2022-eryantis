package it.polimi.ingsw.message;

import java.io.Serializable;

public class SetName implements Serializable {

    /**
     * Name of the player
     */
    private String name;

    /**
     * Sets the name
     * @param name
     */
    public SetName(String name){
        this.name = name;
    }

    /**
     * @return player's name
     */
    public String getName(){
        return this.name;
    }

}
