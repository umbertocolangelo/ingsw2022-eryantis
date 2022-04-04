package it.polimi.ingsw.PawnTest;

import it.polimi.ingsw.Model.Enumerations.Color;
import it.polimi.ingsw.Model.Enumerations.PlayerColor;
import it.polimi.ingsw.Model.Pawns.Student;
import it.polimi.ingsw.Model.Pawns.Tower;
import it.polimi.ingsw.Model.Player.Board.TowerTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class TowerTest {

    @Test
    public void GetColorTest()
    {
        Tower tower = new Tower(PlayerColor.WHITE);
        assertTrue(tower.getColor()==PlayerColor.WHITE);
    }

    @Test
    public void GetPositionTest()
    {
        Tower tower = new Tower(PlayerColor.WHITE);
        assumeTrue(tower.getPosition()==null);
        TowerTable towerTable = new TowerTable();
        tower.setPosition(towerTable);
        assertTrue(tower.getPosition()==towerTable);
    }

}
