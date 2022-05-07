package it.polimi.ingsw.modelTest.pawnTest;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.pawns.Professor;
import it.polimi.ingsw.model.player.board.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfessorTest {

    @BeforeEach
    public void resetProfessorPosition(){
        for(Color color : Color.values()){
            Professor.getProfessor(color).setPosition(null);
        }
    }

    /**
     * Tests the GetColorTest() method
     */
    @Test
    public void getColorTest()
    {
        Professor professor = Professor.getProfessor(Color.YELLOW);
        assertTrue(professor.getColor()==Color.YELLOW);
    }


    /**
     * Tests the getProfessor() method
     */
    @Test
    public void getProfessorTest()
    {
        Professor professor = Professor.getProfessor(Color.YELLOW);
        Professor professor1 = Professor.getProfessor(Color.YELLOW);
        assertTrue(professor==professor1);
        professor = Professor.getProfessor(Color.GREEN);
        professor1 = Professor.getProfessor(Color.GREEN);
        assertTrue(professor==professor1);
    }

    /**
     * Tests the getPosition() method
     */
    @Test
    public void getPositionTest()
    {
        Professor professor = Professor.getProfessor(Color.YELLOW);
        assertTrue(professor.getPosition()==null);
    }

    /**
     * Tests the setPosition() method
     */
    @Test
    public void setPositionTest()
    {
        Professor professor = Professor.getProfessor(Color.YELLOW);
        Line line = new Line(Color.RED);
        professor.setPosition(line);
        assertTrue(professor.getPosition()==line);
    }

}