package it.polimi.ingsw.BoardTest;


import it.polimi.ingsw.Model.Enumerations.Color;
import it.polimi.ingsw.Model.Player.Board.Hall;
import it.polimi.ingsw.Model.Player.Board.Line;
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
