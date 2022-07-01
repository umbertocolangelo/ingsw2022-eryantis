package it.polimi.ingsw.modelTest.pawnTest;

import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.pawns.Tower;
import it.polimi.ingsw.model.player.board.TowerTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * Test of Tower class
 */
public class TowerTest {

    /**
     * Test of getColor method
     */
    @Test
    public void getColorTest()
    {
        Tower tower = new Tower(PlayerColor.WHITE);
        assertTrue(tower.getColor()==PlayerColor.WHITE);
    }

    /**
     * Test of getPosition method
     */
    @Test
    public void getPositionTest()
    {
        Tower tower = new Tower(PlayerColor.WHITE);
        assertTrue(tower.getPosition()==null);
    }

    /**
     * Test of setPosition method
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
