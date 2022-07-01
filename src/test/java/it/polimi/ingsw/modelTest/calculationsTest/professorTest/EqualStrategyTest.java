package it.polimi.ingsw.modelTest.calculationsTest.professorTest;


import it.polimi.ingsw.model.calculations.professor.EqualStrategy;
import it.polimi.ingsw.model.calculations.professor.ProfessorStrategy;
import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.pawns.Professor;
import it.polimi.ingsw.model.player.board.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test of EqualStrategy class
 */
public class EqualStrategyTest {

    /**
     * resets the position of the professors before each test
     */
    @BeforeEach
    public void resetProfessorPosition(){
        for(Color color : Color.values()){
            Professor.getProfessor(color).setPosition(null);
        }
    }

    /**
     * test the compare method in the equal strategy
     */
    @Test
    public void compareTest(){
        ProfessorStrategy strategy = new EqualStrategy();
        (new Line(Color.YELLOW)).addProfessor(Professor.getProfessor(Color.YELLOW));
        assertTrue(strategy.compare(1,1,Color.YELLOW)); // has to return true (1>=1)
        assertTrue(strategy.compare(2,1,Color.YELLOW)); // has to return true (2>=1)
        assertTrue(!strategy.compare(1,2,Color.YELLOW)); // has to return false (1>=2)
        assertTrue(!strategy.compare(1,1,Color.RED)); // has to return false (1>1)
        assertTrue(strategy.compare(2,1,Color.RED)); // has to return true (2>1)

    }
}
