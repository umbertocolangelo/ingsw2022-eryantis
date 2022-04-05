package it.polimi.ingsw.PawnTest;

import it.polimi.ingsw.Model.Enumerations.Color;
import it.polimi.ingsw.Model.Enumerations.PlayerColor;
import it.polimi.ingsw.Model.Pawns.Student;
import it.polimi.ingsw.Model.Pawns.Tower;
import it.polimi.ingsw.Model.Player.Board.TowerTable;
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
        TowerTable towerTable = new TowerTable(PlayerColor.WHITE);
        Tower tower = new Tower(PlayerColor.WHITE);
        tower.setPosition(towerTable);
        assertTrue(tower.getPosition()==towerTable);
    }

}
