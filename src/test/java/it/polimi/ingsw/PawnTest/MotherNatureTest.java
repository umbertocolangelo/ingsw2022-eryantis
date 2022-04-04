package it.polimi.ingsw.PawnTest;

import it.polimi.ingsw.Model.Enumerations.Color;
import it.polimi.ingsw.Model.Islands.Island;
import it.polimi.ingsw.Model.Islands.IslandGroup;
import it.polimi.ingsw.Model.Pawns.MotherNature;
import it.polimi.ingsw.Model.Pawns.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MotherNatureTest {

    @Test
    public void getIslandTest()
    {
        MotherNature motherNature = new MotherNature();
        Island island = new Island();
        motherNature.setIsland(island);
        assertTrue(motherNature.getIsland()==island);
    }

    @Test
    public void setIslandTest()
    {
        MotherNature motherNature = new MotherNature();
        Island island = new Island();
        motherNature.setIsland(island);
        assertTrue(motherNature.getIsland()==island);
        IslandGroup islandGroup = new IslandGroup();
        motherNature.setIsland(islandGroup);
        assertTrue(motherNature.getIsland()==islandGroup);
    }

}
