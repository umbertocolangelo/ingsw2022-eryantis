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
     *
     * @param tower is the tower to add
     */

    public void addTower(Tower tower);

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
     */
    public void setIsGrouped();

    /**
     * @return current isGrouped status
     */
    public Boolean isGrouped();

    /**
     * used only in tests
     * @return IslandInterface element size;
     */
    public Integer getSize();

    /**
     *
     */
    public LinkedList<Island> getIslandGroupElements();

}
