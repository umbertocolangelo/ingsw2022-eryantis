package it.polimi.ingsw.Model.Calculations.Influence;

import java.util.*;

/**
 * 
 */
public interface InfluenceCalculator {

    /**
     * 
     */
    private Collection<Player> playerList;

    /**
     * 
     */
    public void calculateInfluence();

    /**
     * 
     */
    private void applyInfluence();

}