package it.polimi.ingsw.modelTest.playerTest.boardTest;


import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.board.Hall;
import it.polimi.ingsw.model.player.board.Line;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class HallTest {
    /**
     * Test the getLine function
     */
    @Test
    public void getLineTest(){
        Hall hall=new Hall();
        for(Color color : Color.values()){
            assertTrue(hall.getLine(color).getColor()==color);
        }
    }

    @Test
    public void addStudentTest(){
        Hall hall = new Hall();
        Student student = new Student(Color.YELLOW);
        hall.addStudent(student);
        assertTrue(hall.getLine(Color.YELLOW).getStudents().contains(student));
    }

}
