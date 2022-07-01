package it.polimi.ingsw.modelTest.enumerationsTest;

import it.polimi.ingsw.model.enumerations.Color;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test of Color class
 */
public class ColorTest {

    /**
     * test of getColor method
     */
    @Test
    public void getColorTest(){
        assertTrue(Color.getColor(0)==Color.YELLOW);
        assertTrue(Color.getColor(1)==Color.BLUE);
        assertTrue(Color.getColor(2)==Color.GREEN);
        assertTrue(Color.getColor(3)==Color.RED);
        assertTrue(Color.getColor(4)==Color.PINK);
        assertTrue(Color.getColor(5)==null);
    }
}
