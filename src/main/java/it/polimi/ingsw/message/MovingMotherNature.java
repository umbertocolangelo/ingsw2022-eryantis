package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;

import java.io.Serializable;

public class MovingMotherNature implements MessageMethod, Serializable {

    /**
     * number of jumps
     */
    private Integer jumps;

    /**
     * Applies the change to the model
     * @param game
     */
    public void apply(Game game) {
        game.moveMotherNature(jumps);
    }

    /**
     * Sets motherNature jumps
     * @param jumps
     */
    public void setJumps(Integer jumps) {
        this.jumps = jumps;
    }
}
