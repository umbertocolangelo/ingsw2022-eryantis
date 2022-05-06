package it.polimi.ingsw.modelTest.calculationsTest.professorTest;

import it.polimi.ingsw.model.calculations.professor.EqualStrategy;
import it.polimi.ingsw.model.calculations.professor.ProfessorStrategy;
import it.polimi.ingsw.model.calculations.professor.StandardStrategy;
import it.polimi.ingsw.model.enumerations.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StandardStrategyTest {

    @Test
    public void compareTest(){
        ProfessorStrategy strategy = new StandardStrategy();
        assertTrue(!strategy.compare(1,1, Color.YELLOW));
        assertTrue(strategy.compare(2,1,Color.YELLOW));
        assertTrue(!strategy.compare(1,2,Color.YELLOW));

    }
}
