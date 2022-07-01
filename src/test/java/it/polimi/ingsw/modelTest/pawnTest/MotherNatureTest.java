package it.polimi.ingsw.modelTest.pawnTest;

import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.islands.IslandGroup;
import it.polimi.ingsw.model.pawns.MotherNature;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test of MotherNature class
 */
public class MotherNatureTest {

    /**
     * Test of getIsland method
     */
    @Test
    public void getIslandTest()
    {
        MotherNature motherNature = new MotherNature();
        Island island = new Island();
        motherNature.setIsland(island);
        assertTrue(motherNature.getIsland()==island);
    }

    /**
     * Test of setIsland method
     */
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
