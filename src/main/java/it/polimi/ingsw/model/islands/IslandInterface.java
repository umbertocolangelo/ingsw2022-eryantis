package it.polimi.ingsw.model.islands;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.pawns.Tower;

import java.util.LinkedList;

/**
 * Interface of islands and island groups
 */
public interface IslandInterface {

    /**
     * @param color
     * @return
     */
    public Integer numOfStudents(Color color);

    /**
     * Set deny token
     */
    public void setDeny();

    /**
     * Get deny token
     */
    public Integer getDeny();

    /**
     * Remove deny token
     */
    public void removeDeny();

    /**
     * Return the number of towers
     * @return num of towers
     */
    public Integer numOfTowers();

    /**
     * add a tower
     * @param tower
     */
    public void addTower(Tower tower);

    /**
     * dominant player color
     * @return player color
     */
    public PlayerColor getInfluenceColor();

    /**
     * Return the LinkedList of Towers
     * @return the list of the towers
     */
    public LinkedList<Tower> getTowers();

    /**
     * sets isGrouped to true
     */
    public void setIsGrouped();

    /**
     * True if island interface element is grouped
     * @return current isGrouped status
     */
    public Boolean isGrouped();

    /**
     * used only in tests
     * @return IslandInterface element size
     */
    public Integer getSize();

    /**
     * Returns island interface id
     * @return String
     */
    public String getId();

    /**
     * Returns island interface elements
     * @return LinkedList
     */
    public LinkedList<Island> getIslandGroupElements();

    /**
     * returns island interface students
     * @return LinkedList
     */
    public LinkedList<Student> getStudents();

}
