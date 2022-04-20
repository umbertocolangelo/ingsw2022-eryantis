package it.polimi.ingsw.model.calculations.influence;

import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.islands.IslandInterface;

/**
 * 
 */
public class IslandInfluence implements InfluenceCalculator {

    /**
     * Default constructor
     */
    public IslandInfluence(Island island) {
        this.island = island;
    }

    /**
     * 
     */
    private IslandInterface island;

    /**
     * 
     */
    public void calculateInfluence() {
        // TODO implement here
    }

    /**
     * 
     */
    public void applyInfluence() {
        // TODO implement here
    }

}