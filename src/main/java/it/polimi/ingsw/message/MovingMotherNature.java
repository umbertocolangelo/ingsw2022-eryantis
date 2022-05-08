package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;

import java.io.Serializable;

public class MovingMotherNature implements MessageMethod, Serializable {

    private Integer jumps;

    public void apply(Game game) {
        game.moveMotherNature(jumps);
    }

    public void setJumps(Integer jumps) {
        this.jumps = jumps;
    }
}
