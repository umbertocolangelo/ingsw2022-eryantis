package it.polimi.ingsw.message;

import java.io.Serializable;

public class SetName implements Serializable {

    /**
     *Is the name of the Player
     */
    private String name;

    /**
     * Set the name
     * @param name
     */
    public SetName(String name){
        this.name = name;
    }

    /**
     * Get the name
     * @return
     */
    public String getName(){
        return this.name;
    }

}
