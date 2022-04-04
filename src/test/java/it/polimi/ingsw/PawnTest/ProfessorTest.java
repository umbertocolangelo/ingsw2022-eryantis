package it.polimi.ingsw.PawnTest;

import it.polimi.ingsw.Model.Enumerations.Color;
import it.polimi.ingsw.Model.Pawns.Professor;
import it.polimi.ingsw.Model.Pawns.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfessorTest {

    @Test
    public void GetColorTest()
    {
        Professor professor = new Professor(Color.YELLOW);
        assertTrue(professor.getColor()==Color.YELLOW);
    }
}
