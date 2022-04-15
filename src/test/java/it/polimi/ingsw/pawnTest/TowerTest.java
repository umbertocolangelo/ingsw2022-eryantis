package it.polimi.ingsw.pawnTest;

import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.pawns.Tower;
import it.polimi.ingsw.model.player.board.TowerTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class TowerTest {

    /**
     * Tests the GetColorTest() method
     */
    @Test
    public void getColorTest()
    {
        Tower tower = new Tower(PlayerColor.WHITE);
        assertTrue(tower.getColor()==PlayerColor.WHITE);
    }

    /**
     * Tests the GetPosition() method
     */
    @Test
    public void getPositionTest()
    {
        Tower tower = new Tower(PlayerColor.WHITE);
        assertTrue(tower.getPosition()==null);
    }

    /**
     * Tests the SetPosition() method
     */
    @Test
    public void setPositionTest()
    {
        TowerTable towerTable = new TowerTable(PlayerColor.WHITE, false);
        Tower tower = new Tower(PlayerColor.WHITE);
        tower.setPosition(towerTable);
        assertTrue(tower.getPosition()==towerTable);
    }

}
