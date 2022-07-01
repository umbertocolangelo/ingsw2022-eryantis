package it.polimi.ingsw.model.calculations.influence;

import it.polimi.ingsw.model.islands.IslandInterface;

/**
 * Interface of the state patterns of influence calculus
 */
public interface InfluenceCalculator {

    /**
     * Starts the influence calculus
     * @param island the island where we want calculate the influence
     */
    void calculateInfluence(IslandInterface island);

}