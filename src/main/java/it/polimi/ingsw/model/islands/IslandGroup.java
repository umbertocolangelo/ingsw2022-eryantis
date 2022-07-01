package it.polimi.ingsw.model.islands;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.objectTypes.FixedObject;
import it.polimi.ingsw.model.objectTypes.FixedObjectTower;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.pawns.Tower;

import java.io.Serializable;
import java.util.*;

public class IslandGroup implements IslandInterface, Serializable, FixedObjectTower {

    /**
     * Default constructor
     */
    public IslandGroup() {

    }

    /**
     * linked list of island in the same group
     */
    private LinkedList<Island> islandGroup = new LinkedList<Island>();

    /**
     * Add an island interface element to the island group
     * @param islandInterface indicates the new Island element of this islandGroup
     */
    public void addIslandInterface(IslandInterface islandInterface) {
        for (Island island: islandInterface.getIslandGroupElements()) {
            this.islandGroup.add(island);
            island.setIsGrouped();
        }
    }

    /**
     * Return the number of students in the group
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
    public void setDeny() { islandGroup.get(0).setDeny(); }

    /**
     * Return the deny token
     * @return the number of denyTokens on the IslandGroup
     */
    public Integer getDeny() {
        int denyNum = 0;
        for (Island island: islandGroup) {
            denyNum = denyNum + island.getDeny();
        }
        return denyNum;
    }

    /**
     * Removes one deny token from the IslandGroup
     */
    public void removeDeny() {
        for (Island island: islandGroup) {
            if(island.getDeny()>0){
                island.removeDeny();
                return;
            }
        }
    }
    /**
     * Returns the number of towers
     * @return towers number of the group
     */
    public Integer numOfTowers() { return this.islandGroup.size(); }

    /**
     * Returns the dominant color on the island group
     * @return PlayerColor
     */
    public PlayerColor getInfluenceColor() {
        return this.islandGroup.get(0).getInfluenceColor();
    }

    /**
     * Returns the island interface element of the group
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
     * Returns true
     * @return isGrouped
     */
    public Boolean isGrouped() { return true; }

    /**
     * Returns group size
     * @return Integer
     */
    public Integer getSize() { return this.islandGroup.size(); }

    /**
     * Returns id of group first island
     * @return String
     */
    @Override
    public String getId() {
        return islandGroup.getFirst().getId();
    }

    /**
     * Add a tower on the group
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
     * Remove the tower in the correct island in islandGroup
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
     * Students on the island group
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
