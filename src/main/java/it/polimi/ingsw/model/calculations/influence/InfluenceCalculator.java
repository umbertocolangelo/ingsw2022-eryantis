package it.polimi.ingsw.model.calculations.influence;

import it.polimi.ingsw.model.islands.IslandInterface;

/**
 * 
 */
public interface InfluenceCalculator {

    /**
     * Starts the influence calculus
     */
    void calculateInfluence(IslandInterface island);

}