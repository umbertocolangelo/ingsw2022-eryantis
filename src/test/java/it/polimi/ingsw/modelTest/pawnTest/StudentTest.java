package it.polimi.ingsw.modelTest.pawnTest;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.pawns.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test of Student class
 */
public class StudentTest {

    /**
     * Test of getColorTest method
     */
    @Test
    public void GetColorTest()
    {
        Student student = new Student(Color.YELLOW);
        assertTrue(student.getColor()==Color.YELLOW);
    }

    /**
     * Test of getPosition method
     */
    @Test
    public void GetPositionTest()
    {
        Student student = new Student(Color.YELLOW);
        assertTrue(student.getPosition()==null);
    }

    /**
     * Test of setPosition method
     */
    @Test
    public void setPositionTest()
    {
        Student student = new Student(Color.YELLOW);
        Island island = new Island();
        student.setPosition(island);
        assertTrue(student.getPosition()==island);
    }

    /**
     * Test of getId method
     */
    @Test
    public void getIdTest(){
        Student student = new Student(Color.YELLOW);
        System.out.println(student.getId());
    }

}
