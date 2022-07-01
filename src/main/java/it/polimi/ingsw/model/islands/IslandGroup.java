package it.polimi.ingsw.model.islands;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.objectTypes.FixedObject;
import it.polimi.ingsw.model.objectTypes.FixedObjectTower;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.pawns.Tower;

import java.io.Serializable;
import java.util.*;

/**
 *
 */
public class IslandGroup implements IslandInterface, Serializable, FixedObjectTower {

    /**
     * Default constructor
     */
    public IslandGroup() {

    }

    /**
     * Stores the number of denyTokens on the IslandGroup
     */
    private Integer denyTokens = 0;

    /**
     * linked list of island in the same group
     */
    private LinkedList<Island> islandGroup = new LinkedList<Island>();

    /**
     * @param islandInterface indicates the new Island element of this islandGroup
     */
    public void addIslandInterface(IslandInterface islandInterface) {
        for (Island island: islandInterface.getIslandGroupElements()) {
            this.islandGroup.add(island);
            island.setIsGrouped();
        }
    }

    /**
     * @param color of student
     * @return this color number of students on the group
     */
    public Integer numOfStudents(Color color) {
        int total = 0;
        for (int i=0; i< islandGroup.size(); i++) {
            total += islandGroup.get(i).numOfStudents(color);
        }
        return total;
    }

    /**
     * Adds one deny token to the IslandGroup
     */
    public void setDeny() { denyTokens++; }

    /**
     * @return the number of denyTokens on the IslandGroup
     */
    public Integer getDeny() { return denyTokens; }

    /**
     * Removes one deny token from the IslandGroup
     */
    public void removeDeny() {
        if (denyTokens>0) {
            denyTokens--;
        }
    }
    /**
     * @return towers number of the group
     */
    public Integer numOfTowers() { return this.islandGroup.size(); }

    /**
     * returns the dominant color on the island group
     * @return PlayerColor
     */
    public PlayerColor getInfluenceColor() {
        return this.islandGroup.get(0).getInfluenceColor();
    }

    /**
     * @return copy of islandGroup linked list
     */
    public LinkedList<Island> getIslandGroupElements() {
        return new LinkedList<>(this.islandGroup);
    }

    /**
     * Return the LinkedList of every Towers in this islandGroup
     * @return the list of the tower
     */
    public LinkedList<Tower> getTowers() {
        LinkedList<Tower> towerList = new LinkedList<>();
        for (Island island: islandGroup) {
            towerList.add(island.getTowers().get(0));
        }
        return towerList;
    }

    /**
     * not used in islandGroup implementation
     */
    public void setIsGrouped() {}

    /**
     * @return isGrouped
     */
    public Boolean isGrouped() { return true; }

    /**
     * @return group size
     */
    public Integer getSize() { return this.islandGroup.size(); }

    /**
     * @return id of group first island
     */
    @Override
    public String getId() {
        return islandGroup.getFirst().getId();
    }

    /**
     * add a tower on the group
     * @param tower is the tower to add
     */
    public void addTower(Tower tower) {
        for (Island island: islandGroup) {
            if (island.getTowers()==null) {
                island.addTower(tower);
                return;
            }
        }
    }

    /**
     * remove the tower in the correct island in islandGroup
     * @param tower
     */
    public void removeTower(Tower tower) {
        for (Island island: islandGroup) {
            if (island.getTowers().get(0)==tower) {
                island.removeTower(tower);
                return;
            }
        }
    }

    /**
     * students on the island group
     * @return the students present on the island group
     */
    public LinkedList<Student> getStudents() {
        LinkedList<Student> students = new LinkedList<>();
        for (Island island: islandGroup) {
            for (int i=0; i<island.getStudents().size(); i++) {
                students.add(island.getStudents().get(i));
            }
        }
        return students;
    }

}
