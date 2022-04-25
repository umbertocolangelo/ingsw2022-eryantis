package it.polimi.ingsw.model.islands;

import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.pawns.MotherNature;

import java.util.*;

/**
 *
 */
public class IslandManager {

    /**
     * Default constructor instantiates the initial 12 Islands of the board into a linked list
     */
    public IslandManager(MotherNature motherNature) {
        this.motherNature = motherNature;
        int size = 0;
        while (size < 12) {
            Island island = new Island();
            islands.add(island);
            size++;
        }
    }

    /**
     *
     */
    private LinkedList<IslandInterface> islands = new LinkedList<IslandInterface>();

    /**
     *
     */
    MotherNature motherNature;

    /**
     *
     */
    private Integer numOfGroups;

    /**
     * @return
     */
    public IslandInterface nextIsland(Integer assistantCardValue) {
        IslandInterface temp = null;
        for (int i=0; i<islands.size(); i++) {
            if (islands.get(i).equals(motherNature.getIsland())) {
                temp = islands.get(i+assistantCardValue);
            }
        }
        return temp;
    }

    /**
     * verify group conditions and eventually instantiate new islandGroup list
     */
    public void checkGroup(IslandInterface islandInterface) {
        int j;
        for (int i = 0; i < islands.size(); i++) {
            if (islands.get(i) == islandInterface) {
                if (islandInterface.getInfluenceColor()==rightIsland(islandInterface).getInfluenceColor() && islandInterface.getInfluenceColor()==leftIsland(islandInterface).getInfluenceColor()) {
                    if (i-1 == -1) { j = islands.size()-1; }
                    else { j = i-1; }
                    islandsUpdate(j); //primo update unisce leftIsland a island
                    islandsUpdate(j); //secondo update unisce il nuovo gruppo (con dentro leftIsland e island) a rightIsland
                }
                else if (islandInterface.getInfluenceColor()==leftIsland(islandInterface).getInfluenceColor()) {
                    islandsUpdate(i-1);
                }
                else if (islandInterface.getInfluenceColor()==rightIsland(islandInterface).getInfluenceColor()) {
                    islandsUpdate(i);
                }
            }
        }
    }

    /**
     * @return islands size
     */
    public Integer getSize() {
        return this.islands.size();
    }

    /**
     * @return number of islandGroup in islands linkedlist
     */
    public Integer getNumOfGroups() {
        numOfGroups = 0;
        if (islands.size() == 12) {
            numOfGroups = 0;
        } else if (islands.size() < 12) {
            for (int i=0; i<islands.size(); i++) {
                if (islands.get(i).isGrouped()) {
                    numOfGroups += 1;
                }
            }
        }
        return numOfGroups;
    }

    /**
     * Used only for methods test
     *
     * @return this.islands
     */
    public LinkedList<IslandInterface> getIslands() {
        return this.islands;
    }

    /**
     * @param islandInterface
     * @return left param "island" IslandInterface element in islands
     */
    private IslandInterface leftIsland(IslandInterface islandInterface) {
        IslandInterface tempIslandInterface = null;
        if (islands.get(0).equals(islandInterface)) {
            tempIslandInterface = islands.get(islands.size()-1); }
        else {
            for (int i= islands.size()-1; i>0; i--) {
                if (islands.get(i).equals(islandInterface)) {
                    tempIslandInterface = islands.get(i-1);
                }
            }
        }
        return tempIslandInterface;
    }

    /**
     * @param islandInterface
     * @return right param "island" IslandInterface element in islands
     */
    private IslandInterface rightIsland(IslandInterface islandInterface) {
        IslandInterface tempIslandInterface = null;
        if (islands.get(islands.size()-1).equals(islandInterface)) {
            tempIslandInterface = islands.get(0);
        }
        else {
            for (int i=0; i<islands.size()-1; i++) {
                if (islands.get(i).equals(islandInterface)) {
                    tempIslandInterface = islands.get(i+1);
                }
            }
        }
        return tempIslandInterface;
    }


    /**
     * updates islands linkedlist after an island join, replacing islands.get(curr) and its right element with newGroup
     *
     * @param curr is the old IslandInterface element in islands linkedlist
     */
    private void islandsUpdate(Integer curr) {
        IslandGroup newGroup = new IslandGroup();
        if (!islands.get(curr).isGrouped()) {
            setNewGroup(newGroup, (Island) islands.get(curr));
        } else {
            setNewGroup(newGroup, (IslandGroup) islands.get(curr));
        }
        for (int i = 0; i < islands.size(); i++) {
            if (islands.get(i).equals(newGroup.getIslandGroupElements().get(0))) {
                for (int j=i; j<newGroup.getIslandGroupElements().size()+i; j++) {
                    islands.remove(j);
                }
                islands.add(i, newGroup);
            }
        }
    }


    /**
     * sets in islandGroup all islandInterface elements interested in the same island join
     *
     * @param newIslandGroup is the new group in which are set oldIsland and its right element in islands list
     * @param oldIsland      is the element in the IslandManager islands that will be replaced by newIslandGroup
     */
    private void setNewGroup(IslandGroup newIslandGroup, Island oldIsland) {

        if (!rightIsland(oldIsland).isGrouped()) {
            oldIsland.setIsGrouped();
            rightIsland(oldIsland).setIsGrouped();
            newIslandGroup.addIsland(oldIsland);
            newIslandGroup.addIsland((Island) rightIsland(oldIsland));
        } else {
            oldIsland.setIsGrouped();
            newIslandGroup.addIsland(oldIsland);
            newIslandGroup.addIslandGroup((IslandGroup) rightIsland(oldIsland));
        }
    }

    /**
     * sets in islandGroup all islandInterface elements interested in the same island join
     *
     * @param newIslandGroup is the new group in which are set oldIslandGroup and its right element in islands list
     * @param oldIslandGroup is the element in the old IslandManager islands that will be replaced by newIslandGroup
     */
    private void setNewGroup(IslandGroup newIslandGroup, IslandGroup oldIslandGroup) {

        if (!rightIsland(oldIslandGroup).isGrouped()) {
            rightIsland(oldIslandGroup).setIsGrouped();
            newIslandGroup.addIslandGroup(oldIslandGroup);
            Island tempIsland;
            tempIsland = (Island) rightIsland(oldIslandGroup);
            newIslandGroup.addIsland(tempIsland);
        } else {
            newIslandGroup.addIslandGroup(oldIslandGroup);
            IslandGroup tempGroup;
            tempGroup = (IslandGroup) rightIsland(oldIslandGroup);
            newIslandGroup.addIslandGroup(tempGroup);
        }
    }

    /**
     * used only for test
     *
     * @param newIslandGroup
     * @param oldIsland
     */
    public void setNewGroupTest(IslandGroup newIslandGroup, Island oldIsland) {
        setNewGroup(newIslandGroup, oldIsland);
    }

    /**
     * used only for test
     *
     * @param newIslandGroup
     * @param oldIslandGroup
     */
    public void setNewGroupTest(IslandGroup newIslandGroup, IslandGroup oldIslandGroup) {
        setNewGroup(newIslandGroup, oldIslandGroup);
    }

    /**
     * used only for test
     */
    public void islandsUpdateTest(Integer curr) { islandsUpdate(curr); }

    /**
     * used only for test
     */
    public IslandInterface rightIslandTest(IslandInterface islandInterface) {
        return rightIsland(islandInterface);
    }

    /**
     * used only for test
     */
    public IslandInterface leftIslandTest(IslandInterface islandInterface) {
        return leftIsland(islandInterface);
    }
}
