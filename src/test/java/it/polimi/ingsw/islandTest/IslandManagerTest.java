
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
        assertTrue(islandManager.getSize()==11);
    }

    /**
     * Testing getNumOfGroups
     */
    public void getNumOfGroups() {

    }

}

