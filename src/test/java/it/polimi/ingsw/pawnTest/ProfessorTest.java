package it.polimi.ingsw.pawnTest;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.pawns.Professor;
import it.polimi.ingsw.model.player.board.Line;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfessorTest {

    /**
     * Tests the GetColorTest() method
     */
    @Test
    public void getColorTest()
    {
        Professor professor = new Professor(Color.YELLOW);
        assertTrue(professor.getColor()==Color.YELLOW);
    }

    /**
     * Tests the GetPosition() method
     */
    @Test
    public void getPositionTest()
    {
        Professor professor = new Professor(Color.YELLOW);
        assertTrue(professor.getPosition()==null);
    }

    /**
     * Tests the SetPosition() method
     */
    @Test
    public void setPositionTest()
    {
        Professor professor = new Professor(Color.YELLOW);
        Line line = new Line(Color.RED);
        professor.setPosition(line);
        assertTrue(professor.getPosition()==line);
    }

}
