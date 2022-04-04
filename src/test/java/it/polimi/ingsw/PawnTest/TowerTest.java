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
    public void GetColorTest()
    {
        Tower tower = new Tower(PlayerColor.WHITE,null);
        assertTrue(tower.getColor()==PlayerColor.WHITE);
    }

    /**
     * Tests the GetPosition() method
     */
    @Test
    public void GetPositionTest()
    {
        TowerTable towerTable = new TowerTable(PlayerColor.WHITE);
        Tower tower = new Tower(PlayerColor.WHITE,towerTable);
        assertTrue(tower.getPosition()==towerTable);
    }

    /**
     * Tests the SetPosition() method
     */
    @Test
    public void SetPositionTest()
    {
        TowerTable towerTable = new TowerTable(PlayerColor.WHITE);
        Tower tower = new Tower(PlayerColor.WHITE,null);
        tower.setPosition(towerTable);
        assertTrue(tower.getPosition()==towerTable);
    }

}
