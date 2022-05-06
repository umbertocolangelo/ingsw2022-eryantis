package it.polimi.ingsw.message;

import java.io.Serializable;

public class SetName implements Serializable {
    private String name;

    public SetName(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

}
