package it.polimi.ingsw.model.islands;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.enumerations.PlayerColor;

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
    public boolean getDeny();
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
    public PlayerColor getInfluenceColor();

}