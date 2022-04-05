package it.polimi.ingsw.pawnTest;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.pawns.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentTest {

    /**
     * Tests the GetColorTest() method
     */
    @Test
    public void GetColorTest()
    {
        Student student = new Student(Color.YELLOW);
        assertTrue(student.getColor()==Color.YELLOW);
    }

    /**
     * Tests the GetPosition() method
     */
    @Test
    public void GetPositionTest()
    {
        Student student = new Student(Color.YELLOW);
        assertTrue(student.getPosition()==null);
    }

    /**
     * Tests the SetPosition() method
     */
    @Test
    public void setPositionTest()
    {
        Student student = new Student(Color.YELLOW);
        Island island = new Island();
        student.setPosition(island);
        assertTrue(student.getPosition()==island);
    }

}
