package it.polimi.ingsw.model.islands;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.pawns.Student;
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
     * set deny token
     */
    public void setDeny();

    /**
     * get deny token
     */
    public Integer getDeny();

    /**
     * remove deny token
     */
    public void removeDeny();

    /**
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
     * @return current isGrouped status
     */
    public Boolean isGrouped();

    /**
     * used only in tests
     * @return IslandInterface element size;
     */
    public Integer getSize();

    /**
     * @return island interface id
     */
    public String getId();

    /**
     * @return island interface elements
     */
    public LinkedList<Island> getIslandGroupElements();

    /**
     * @return island interface students
     */
    public LinkedList<Student> getStudents();

}
