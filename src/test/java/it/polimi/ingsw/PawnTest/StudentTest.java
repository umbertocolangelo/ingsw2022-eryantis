package it.polimi.ingsw.PawnTest;

import it.polimi.ingsw.Model.Enumerations.Color;
import it.polimi.ingsw.Model.Enumerations.PlayerColor;
import it.polimi.ingsw.Model.Islands.Island;
import it.polimi.ingsw.Model.Pawns.Student;
import it.polimi.ingsw.Model.Pawns.Tower;
import it.polimi.ingsw.Model.Player.Board.TowerTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentTest {

    /**
     * Tests the GetColorTest() method
     */
    @Test
    public void GetColorTest()
    {
        Student student = new Student(Color.YELLOW,null);
        assertTrue(student.getColor()==Color.YELLOW);
    }

    /**
     * Tests the GetPosition() method
     */
    @Test
    public void GetPositionTest()
    {
        Island island = new Island();
        Student student = new Student(Color.YELLOW,island);
        assertTrue(student.getPosition()==island);
    }

    /**
     * Tests the SetPosition() method
     */
    @Test
    public void setPositionTest()
    {
        Student student = new Student(Color.YELLOW,null);
        Island island = new Island();
        student.setPosition(island);
        assertTrue(student.getPosition()==island);
    }

}
