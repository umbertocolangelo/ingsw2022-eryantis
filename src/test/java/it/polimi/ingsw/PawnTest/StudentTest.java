package it.polimi.ingsw.PawnTest;

import it.polimi.ingsw.Model.Enumerations.Color;
import it.polimi.ingsw.Model.Pawns.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentTest {

    @Test
    public void GetColorTest()
    {
        Student student = new Student(Color.YELLOW);
        assertTrue(student.getColor()==Color.YELLOW);
    }
}
