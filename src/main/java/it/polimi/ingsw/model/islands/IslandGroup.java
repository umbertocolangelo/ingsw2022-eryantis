package it.polimi.ingsw.model.islands;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.pawns.Tower;

import java.util.*;

/**
 *
 */
public class IslandGroup implements IslandInterface {

    /**
     * Default constructor
     */
    public IslandGroup() {

    }

    /**
     *
     */
    private boolean isDenied;

    /**
     *
     */
    private String id;

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
     * set isDenied
     */
    public void setDeny() {
        this.isDenied = true;
    }

    /**
     * @return this.isDenied
     */
    public boolean getDeny() { return this.isDenied; }

    /**
     *
     */
    public void removeDeny() {
        this.isDenied = false;
    }

    /**
     * @return towers number of the group
     */
    public Integer numOfTowers() { return this.islandGroup.size(); }

    /**
     * @return
     */
    public PlayerColor getInfluenceColor() {
        return this.islandGroup.get(0).getInfluenceColor();
    }

    /**
     * @return copy of islandGroup linkedlist
     */
    public LinkedList<Island> getIslandGroupElements() {
        return new LinkedList<>(this.islandGroup);
    }

    /**
     * @return LinkedList<Tower>        Return the LinkedList of every Towers in this islandGroup
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
     * @return
     */
    public Boolean isGrouped() { return true; }

    /**
     * @return
     */
    public Integer getSize() { return this.islandGroup.size(); }

    /**
     *
     * @param tower is the tower to add
     */
    public void addTower(Tower tower) {
        for (Island island: islandGroup) {
            if(island.getTowers().get(0)==null){
                island.addTower(tower);
                return;
            }
        }
    }

    /**
     * @return id
     */
    public String getId() {
        return this.id;
    }

    /**
     *
     */
    public void setId(String id) {
        this.id = id;
    }

}
