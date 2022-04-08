package it.polimi.ingsw.model.islands;

import it.polimi.ingsw.model.enumerations.PlayerColor;
import java.util.*;

/**
 * 
 */
public class IslandManager {

    /**
     * Default constructor instantiates the initial 12 Islands of the board into a linked list
     */
    public IslandManager() {
        islands = new LinkedList<IslandInterface>();
        int size = 0;
        while (size < 12) {
            islands.add(new Island());
            size++;
        }
    }

    /**
     * 
     */
    private LinkedList<IslandInterface> islands;

    /**
     * 
     */
    private Integer numOfGroups;

    /**
     * @return
     */
    public Island nextIsland() {
        //TODO implement after influence calculation
        return null;
    }

    /**
     * verify group conditions and eventually instantiate new islandGroup list
     */
    public void checkGroup() {
        for (IslandInterface island: islands) {
            if (island.getInfluenceColor().equals(rightIsland(island).getInfluenceColor())) {
                IslandGroup newGroup = new IslandGroup();
                setNewGroup(newGroup, island);
                islandsUpdate(newGroup);
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
    public Integer numOfGoups() {
        // int blackCounter=0, whiteCounter=0, greyCounter=0;
        if (islands.size() == 12) { numOfGroups = 0; }
        else if (islands.size()<12) {
            for (IslandInterface islandInterface: islands) {
                if (islandInterface.isGrouped()) {
                    numOfGroups += 1;
                    /*
                    if (islandInterface.getInfluenceColor().toString().equals("BLACK")) {
                        blackCounter += 1;
                        if (blackCounter == 3) {checkWinner("BLACK"); }
                    }
                    else if (islandInterface.getInfluenceColor().toString().equals("WHITE")) { whiteCounter += 1; }
                    else if (islandInterface.getInfluenceColor().toString().equals("GREY")) { greyCounter += 1; }
                    */
                }
            }

        }
        return numOfGroups;
    }

    /**
     * @param island
     * @return left IslandInterface element in islands after param "island"
     */
    private IslandInterface leftIsland(IslandInterface island) {
        ListIterator<IslandInterface> islandIterator = islands.listIterator();
        IslandInterface tempIslandInterface = null;
        while (islandIterator.hasPrevious()) {
            if (islandIterator.previous()==island) {
                tempIslandInterface = islandIterator.previous();
            }
            else if (islandIterator.previous()==null) { tempIslandInterface = islands.get(islands.size()-1); }
        }
        return tempIslandInterface;
    }

    /**
     * @param island
     * @return right IslandInterface element in islands after param "island"
     */
    private IslandInterface rightIsland(IslandInterface island) {
        ListIterator<IslandInterface> islandIterator = islands.listIterator();
        IslandInterface tempIslandInterface = null;
        while (islandIterator.hasNext()) {
            if (islandIterator.next()==island) {
                tempIslandInterface = islandIterator.next();
            }
            else if (islandIterator.next()==null) { tempIslandInterface = islands.get(0); }
        }
        return tempIslandInterface;
    }


    /**
     * updates islands linkedlist after an island join
     * @param islandGroup is the new IslandInterface element to replace into islands linkedlist
     */
    private void islandsUpdate (IslandGroup islandGroup) {
        for (int i=0; i<islands.size(); i++) {
            if (islands.get(i).equals(islandGroup.getIslandGroupElement().get(0))) {
                for (int j=i; j<islandGroup.getIslandGroupElement().size()+i; j++) {
                    islands.remove(j);
                }
                islands.add(i, islandGroup);
            }
        }
    }


    /**
     * sets in islandGroup all islandInterface elements interested in the same island join
     * @param islandGroup is the new group in which are set IslandInterface element at the right conditions
     * @param islandInterface is the element in the old IslandManager islands that will be replaced by islandGroup
     */
    private void setNewGroup(IslandGroup islandGroup, IslandInterface islandInterface) {

        if (!islandInterface.isGrouped() && !rightIsland(islandInterface).isGrouped()) {
            islandInterface.setIsGrouped(true);
            rightIsland(islandInterface).setIsGrouped(true);
            islandGroup.addIsland((Island) islandInterface);
            islandGroup.addIsland((Island) rightIsland(islandInterface));
        }
        else if (!islandInterface.isGrouped() && rightIsland(islandInterface).isGrouped()) {
            islandInterface.setIsGrouped(true);
            islandGroup.addIsland((Island) islandInterface);
            islandGroup.addIslandGroup((IslandGroup) rightIsland(islandInterface));
        }
        else if (islandInterface.isGrouped() && !rightIsland(islandInterface).isGrouped()) {
            rightIsland(islandInterface).setIsGrouped(true);
            islandGroup.addIslandGroup((IslandGroup) islandInterface);
            islandGroup.addIsland((Island) rightIsland(islandInterface));
        }
        else {
            islandGroup.addIslandGroup((IslandGroup) islandInterface);
            islandGroup.addIslandGroup((IslandGroup) rightIsland(islandInterface));
        }

    }
}