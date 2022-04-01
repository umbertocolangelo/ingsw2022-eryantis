package it.polimi.ingsw.Model.Islands;

import java.util.*;

/**
 * 
 */
public interface IslandInterface {

    /**
     * @param color 
     * @return
     */
    public Int numOfStudents(Color color);

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
    public Int numOfTowers();

    /**
     * @return
     */
    public PlayerColor influenceColor();

}