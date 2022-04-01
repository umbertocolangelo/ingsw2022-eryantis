package it.polimi.ingsw.Model.Islands;

import it.polimi.ingsw.Model.Enumerations.Color;
import it.polimi.ingsw.Model.Enumerations.PlayerColor;

import java.util.*;

/**
 * 
 */
public interface IslandInterface {

    /**
     * @param color 
     * @return
     */
    public Integer numOfStudents(Color color);

    /**
     * 
     */
    public void setDeny();

    /**
     * 
     */
    public void removeDeny();

    /**
     * @return
     */
    public Integer numOfTowers();

    /**
     * @return
     */
    public PlayerColor influenceColor();

}