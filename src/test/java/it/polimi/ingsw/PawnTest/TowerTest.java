package it.polimi.ingsw.PawnTest;

import it.polimi.ingsw.Model.Enumerations.Color;
import it.polimi.ingsw.Model.Enumerations.PlayerColor;
import it.polimi.ingsw.Model.Pawns.Student;
import it.polimi.ingsw.Model.Pawns.Tower;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TowerTest {

    @Test
    public void GetColorTest()
    {
        Tower tower = new Tower(PlayerColor.WHITE);
        assertTrue(tower.getColor()==PlayerColor.WHITE);
    }
}
