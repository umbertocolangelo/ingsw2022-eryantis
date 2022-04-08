package it.polimi.ingsw.islandTest;

import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.islands.IslandGroup;
import it.polimi.ingsw.model.islands.IslandInterface;
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
        Tower tower1 = new Tower(PlayerColor.WHITE);
        Tower tower2 = new Tower(PlayerColor.WHITE);
        Tower tower3 = new Tower(PlayerColor.BLACK);
        LinkedList<IslandInterface> islands = new LinkedList<IslandInterface>();
        Island island1 = new Island();
        IslandGroup islandGroup = new IslandGroup();
        Island island2 = new Island();
        Island island3 = new Island();
        Island island4 = new Island();
        island1.addTower(tower1);
        island2.addTower(tower2);
        island3.addTower(tower2);
        island4.addTower(tower3);
        islandGroup.addIsland(island2);
        islandGroup.addIsland(island3);
        islands.add(island1);
        islands.add(islandGroup);
        islands.add(island4);
        checkGroup();
        assertTrue(islands.size()==2);
    }
}
