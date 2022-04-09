package it.polimi.ingsw.boardTest;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.pawns.Professor;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.board.Line;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LineTest {
    @Test
    public void getColorTest(){
        Line line = new Line(Color.RED);
        assertTrue(line.getColor().equals(Color.RED));

    }

    /**
     *Test the addStudent function
     */
    @Test
    public void addStudentTest(){
        Line line1 = new Line(Color.RED);
        Line line2 = new Line(Color.RED);
        Line line3 = new Line(Color.YELLOW);
        Student student= new Student(Color.RED);
        line1.addStudent(student);
        assertTrue(line1.getStudents().contains(student)); //Checks that line1 contains the student
        assertTrue(student.getPosition()==line1); //Checks that student is updated
        line2.addStudent(student);
        assertTrue(line2.getStudents().contains(student)); //Checks that line2 contains the student
        assertTrue(student.getPosition()==line2); //Checks that student is updated
        assertTrue(!line1.getStudents().contains(student)); //Checks that line1 is updated
        line3.addStudent(student);  //Action not permitted, the state should not change
        assertTrue(line2.getStudents().contains(student)); //Checks that line2 still contains the student
        assertTrue(student.getPosition()==line2); //Checks that student is not updated
        assertTrue(!line3.getStudents().contains(student)); //Checks that line3 is not updated
    }

    /**
     * Test the removeStudent function
     */
    @Test
    public void removeStudentTest(){
        Line line=new Line(Color.RED);
        Student student= new Student(Color.RED);
        line.addStudent(student);
        assertTrue(line.getStudents().contains(student));
        line.removeStudent(student);
        assertTrue(!line.getStudents().contains(student));
    }

    /**
     * Test the getStudent function
     */
    @Test
    public void getStudent(){
        Line line=new Line(Color.RED);
        Student student= new Student(Color.RED);
        line.addStudent(student);
        assertTrue(line.getStudents().contains(student));
    }

    /**
     * Test the numOfStudent function
     */
    @Test
    public void numOfStudent(){
        Line line=new Line(Color.RED);
        Student student= new Student(Color.RED);
        line.addStudent(student);
        assertTrue(line.getStudents().size()==line.numOfStudents());
    }

    /**
     * Test the addProfessor function
     */
    @Test
    public void addProfessor() {
        Line line = new Line(Color.RED);
        Professor professor=Professor.getProfessor(Color.RED);
        line.addProfessor(professor);
        assertTrue(line.isProfessor()==true);
    }


    /**
     * Test the removeProfessor function
     */
    @Test
    public void removeProfessor(){
        Line line = new Line(Color.RED);
        Professor professor=Professor.getProfessor(Color.RED);
        line.addProfessor(professor);
        assertTrue(line.isProfessor()==true);
        line.removeProfessor(professor);
        assertTrue(line.isProfessor()==false);
        line.addProfessor(professor);
        assertTrue(line.isProfessor()==true);
    }

    /**
     * Test the isProfessor function
     */
    @Test
    public void isProfessor(){
        Line line = new Line(Color.RED);
        Professor professor=Professor.getProfessor(Color.RED);
        line.addProfessor(professor);
        assertTrue(line.isProfessor()==true);
        line.removeProfessor(professor);
        assertTrue(line.isProfessor()==false);
    }


}
