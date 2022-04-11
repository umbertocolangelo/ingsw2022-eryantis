package it.polimi.ingsw.calculationsTest.professorTest;


import it.polimi.ingsw.model.calculations.professor.EqualStrategy;
import it.polimi.ingsw.model.calculations.professor.ProfessorStrategy;
import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.pawns.Professor;
import it.polimi.ingsw.model.player.board.Line;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EqualStrategyTest {

    @Test
    public void compareTest(){
        ProfessorStrategy strategy = new EqualStrategy();
        (new Line(Color.YELLOW)).addProfessor(Professor.getProfessor(Color.YELLOW));
        assertTrue(strategy.compare(1,1,Color.YELLOW));
        assertTrue(strategy.compare(2,1,Color.YELLOW));
        assertTrue(!strategy.compare(1,2,Color.YELLOW));
        assertTrue(!strategy.compare(1,1,Color.RED));
        assertTrue(strategy.compare(2,1,Color.RED));

    }
}
