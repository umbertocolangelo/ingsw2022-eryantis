package it.polimi.ingsw.BoardTest;


import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.player.board.Hall;
import it.polimi.ingsw.model.player.board.Line;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class HallTest {
    /**
     * Test the getLine function
     */
    @Test
    public void getLineTest(){
        Hall hall=new Hall();
        Line line= new Line(Color.RED);
        assertTrue(line.getColor().equals(hall.getLine(Color.RED).getColor()));
    }

}
