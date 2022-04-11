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
    private Integer numOfGroups;

    /**
     * indicates if there is a new update in islands list
     */
    private Boolean isUpdated = false;

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
        for (int i=0; i< islands.size(); i++) {
            if (islands.get(i).getInfluenceColor().equals(islands.get(i+1).getInfluenceColor())) {
                islandsUpdate(i);
            }
            // se avviene la creazione di un group rifaccio la verifica rispetto alla nuova rightIsland dell'elemento nuovo (perchè l'if precendente controlla solo la prima isola a destra)
            if (isUpdated && islands.get(i).getInfluenceColor().equals(islands.get(i+1).getInfluenceColor())) {
                islandsUpdate(i);
            }
            else if (isUpdated && !islands.get(i).getInfluenceColor().equals(islands.get(i+1).getInfluenceColor())) {
                isUpdated = false;
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
        if (islands.size() == 12) { numOfGroups = 0; }
        else if (islands.size()<12) {
            for (IslandInterface islandInterface: islands) {
                if (islandInterface.isGrouped()) {
                    numOfGroups += 1;
                }
            }
        }
        return numOfGroups;
    }

    /**
     * Used only for methods test
     * @return this.islands
     */
    public LinkedList<IslandInterface> getIslands() {
        return this.islands;
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
     * updates islands linkedlist after an island join, replacing islands.get(curr) and its right element with newGroup
     * @param curr is the old IslandInterface element in islands linkedlist
     */
    private void islandsUpdate (Integer curr) {
        IslandGroup newGroup = new IslandGroup();
        if (!islands.get(curr).isGrouped()) { setNewGroup(newGroup, (Island) islands.get(curr)); }
        else { setNewGroup(newGroup, (IslandGroup) islands.get(curr)); }
        for (int i=0; i<islands.size(); i++) {
            if (islands.get(i).equals(newGroup.getIslandGroupElement().get(0))) {
                for (int j=i; j<newGroup.getIslandGroupElement().size()+i; j++) {
                    islands.remove(j);
                }
                islands.add(i, newGroup);
            }
        }
        isUpdated = true;
    }


    /**
     * sets in islandGroup all islandInterface elements interested in the same island join
     * @param newIslandGroup is the new group in which are set oldIsland and its right element in islands list
     * @param oldIsland is the element in the IslandManager islands that will be replaced by newIslandGroup
     */
    private void setNewGroup(IslandGroup newIslandGroup, Island oldIsland) {

        if (!rightIsland(oldIsland).isGrouped()) {
            oldIsland.setIsGrouped(true);
            rightIsland(oldIsland).setIsGrouped(true);
            newIslandGroup.addIsland(oldIsland);
            newIslandGroup.addIsland((Island) rightIsland(oldIsland));
        }
        else {
            oldIsland.setIsGrouped(true);
            newIslandGroup.addIsland(oldIsland);
            newIslandGroup.addIslandGroup((IslandGroup) rightIsland(oldIsland));
        }
    }

    /**
     * sets in islandGroup all islandInterface elements interested in the same island join
     * @param newIslandGroup is the new group in which are set oldIslandGroup and its right element in islands list
     * @param oldIslandGroup is the element in the old IslandManager islands that will be replaced by newIslandGroup
     */
    private void setNewGroup(IslandGroup newIslandGroup, IslandGroup oldIslandGroup) {

        if (!rightIsland(oldIslandGroup).isGrouped()) {
            rightIsland(oldIslandGroup).setIsGrouped(true);
            newIslandGroup.addIslandGroup(oldIslandGroup);
            newIslandGroup.addIsland((Island) rightIsland(oldIslandGroup));
        }
        else {
            newIslandGroup.addIslandGroup(oldIslandGroup);
            newIslandGroup.addIslandGroup((IslandGroup) rightIsland(oldIslandGroup));
        }
    }

}

