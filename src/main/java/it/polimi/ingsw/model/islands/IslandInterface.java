package it.polimi.ingsw.model.islands;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.pawns.Tower;

import java.util.LinkedList;

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

    /**
     * @return LinkedList<Tower>        Return the LinkedList of Towers
     */
    public LinkedList<Tower> getTowers();

    /**
     *
     * @param newSet indicates new isGrouped status
     */
    public void setIsGrouped (boolean newSet);

    /**
     * @return current isGrouped status
     */
    public Boolean isGrouped();

}
