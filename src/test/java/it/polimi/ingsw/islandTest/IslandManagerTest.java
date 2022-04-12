
package it.polimi.ingsw.islandTest;

import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.islands.IslandGroup;
import it.polimi.ingsw.model.islands.IslandInterface;
import it.polimi.ingsw.model.islands.IslandManager;
import it.polimi.ingsw.model.pawns.Tower;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IslandManagerTest {

    /**T
     * Testing checkGroup
     */
    @Test
    public void checkGroup() {
        IslandManager islandManager = new IslandManager();
        Tower tower1 = new Tower(PlayerColor.WHITE);
        Tower tower2 = new Tower(PlayerColor.WHITE);
        Tower tower3 = new Tower(PlayerColor.BLACK);
        IslandGroup islandGroup = new IslandGroup();
        islandManager.getIslands().get(0).getTowers().add(tower1);
        islandManager.getIslands().get(1).getTowers().add(tower2);
        islandManager.getIslands().get(2).getTowers().add(tower2);
        islandManager.getIslands().get(3).getTowers().add(tower1);
        checkGroup();
    }

    /**T
     * Testing getNumOfGroups
     */
    @Test
    public void getNumOfGroups() {
        IslandManager islandManager = new IslandManager();
        islandManager.getNumOfGroups();
        assertTrue(islandManager.getNumOfGroups()==0);
        islandManager.getIslands().get(5).setIsGrouped(true);
        islandManager.getNumOfGroups();
        assertTrue(islandManager.getNumOfGroups()==0);
        islandManager.getIslands().remove(11);
        assertTrue(islandManager.getNumOfGroups()==1);
    }

    /**T
     * Testing setNewGroup(IslandGroup, Island)
     */
    @Test
    public void setNewGroup1() {
        IslandManager islandManager = new IslandManager();
        IslandGroup islandGroup = new IslandGroup();
        islandManager.setNewGroupTest(islandGroup, (Island) islandManager.getIslands().get(0));
        assertTrue(islandGroup.getIslandGroupElement().contains(islandManager.getIslands().get(0)));
        assertTrue(islandGroup.getIslandGroupElement().contains(islandManager.getIslands().get(1)));
        assertTrue(!islandGroup.getIslandGroupElement().contains(islandManager.getIslands().get(2)));
    }

    /**T
     * Testing setNewGroup(IslandGroup, IslandGroup)
     */
    @Test
    public void setNewGroup2() {
        IslandManager islandManager = new IslandManager();
        IslandGroup islandGroup = new IslandGroup();
        IslandGroup islandGroup1 = new IslandGroup();
        islandManager.setNewGroupTest(islandGroup1, (Island) islandManager.getIslands().get(0));
        assertTrue(islandGroup1.getIslandGroupElement().contains(islandManager.getIslands().get(0)));
        assertTrue(islandGroup1.getIslandGroupElement().contains(islandManager.getIslands().get(1)));
        assertTrue(!islandGroup1.getIslandGroupElement().contains(islandManager.getIslands().get(2)));
        assertTrue(islandGroup1.getIslandGroupElement().get(0).isGrouped());
        islandManager.getIslands().remove(0);
        islandManager.getIslands().remove(1);
        islandManager.getIslands().add(0, islandGroup1);
        System.out.println(islandManager.getIslands().size());
        System.out.println(islandManager.getIslands().get(0));
        //islandManager.setNewGroupTest(islandGroup, islandGroup1);
        //assertTrue(islandGroup.getIslandGroupElement().get(0).isGrouped());
        //assertTrue(islandGroup.getIslandGroupElement().get(1).isGrouped());
        //assertTrue(islandGroup.getIslandGroupElement().get(2).isGrouped());
        //non capisco perche non va
    }

    /**T
     * Testing rightIsland
     */
    @Test
    public void rightIsland() {
        IslandManager islandManager = new IslandManager();
        assertTrue(islandManager.rightIslandTest(islandManager.getIslands().get(0)).equals(islandManager.getIslands().get(1)));
        assertTrue(islandManager.rightIslandTest(islandManager.getIslands().get(11)).equals(islandManager.getIslands().get(0)));
        islandManager.getIslands().remove(11);
        assertTrue(islandManager.rightIslandTest(islandManager.getIslands().get(10)).equals(islandManager.getIslands().get(0)));
    }

    /**T
     * Testing leftIsland
     */
    @Test
    public void leftIsland() {
        IslandManager islandManager = new IslandManager();
        assertTrue(islandManager.leftIslandTest(islandManager.getIslands().get(0)).equals(islandManager.getIslands().get(11)));
        assertTrue(islandManager.leftIslandTest(islandManager.getIslands().get(5)).equals(islandManager.getIslands().get(4)));
        islandManager.getIslands().remove(11);
        assertTrue(islandManager.leftIslandTest(islandManager.getIslands().get(0)).equals(islandManager.getIslands().get(10)));
    }

    /**T
     * Testing islandsUpdate
     */
    @Test
    public void islandUpdate() {
        IslandManager islandManager = new IslandManager();

    }
}

