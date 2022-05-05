package it.polimi.ingsw.model.islands;

import it.polimi.ingsw.model.pawns.MotherNature;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 */
public class IslandManager implements Serializable {

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
                if (i+assistantCardValue>=islands.size()) {
                    temp = islands.get(i+assistantCardValue-islands.size()); //circular list
                }
                else {
                    temp = islands.get(i+assistantCardValue);
                }
            }
        }
        return temp;
    }

    /**
     * verify group conditions and eventually instantiate new islandGroup list
     */
    public void checkGroup(IslandInterface islandInterface) { //passare la posizione di madre natura
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
     * updates islands linked list after an island join, replacing islands.get(curr) and its right element with newGroup
     *
     * @param curr is the old IslandInterface element in islands linkedlist
     */
    private void islandsUpdate(Integer curr) {

        IslandGroup newGroup = new IslandGroup();
        setNewGroup(newGroup, islands.get(curr));

        if (curr==islands.size()-1) {
            islands.add(curr, newGroup);
            islands.remove(curr+1);
            islands.remove(0);
        }
        else {
            islands.add(curr, newGroup);
            islands.remove(curr+1);
            islands.remove(curr+1);

        }
    }


    /**
     * sets in newIslandGroup all islandInterface elements interested in the same island join
     *
     * @param newIslandGroup is the new group in which are set oldIsland and its right element in islands list
     * @param islandInterface is the element in the IslandManager islands that will be replaced by newIslandGroup
     */
    private void setNewGroup(IslandGroup newIslandGroup, IslandInterface islandInterface) {
        newIslandGroup.addIslandInterface(islandInterface);
        newIslandGroup.addIslandInterface(rightIsland(islandInterface));
    }

    /**
     * used only for test
     * @param newIslandGroup
     * @param islandInterface
     */
    public void setNewGroupTest(IslandGroup newIslandGroup, IslandInterface islandInterface) {
        setNewGroup(newIslandGroup, islandInterface);
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
