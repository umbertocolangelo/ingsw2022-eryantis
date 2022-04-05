package it.polimi.ingsw.BoardTest;

import it.polimi.ingsw.Model.Enumerations.Color;
import it.polimi.ingsw.Model.Pawns.Professor;
import it.polimi.ingsw.Model.Pawns.Student;
import it.polimi.ingsw.Model.Player.Board.Line;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LineTest {
    @Test
    public void getColorTest(){
        Line line=new Line(Color.RED);
        assertTrue(line.getColor().equals(Color.RED));

    }

    /**
     *
     *Test the addStudent function
     */
    @Test
    public void addStudentTest(){
        Line line=new Line(Color.RED);
        Student student= new Student(Color.RED);
        line.addStudent(student);
        assertTrue(line.getStudents().contains(student));
        Line line1=new Line(Color.YELLOW);
        Student student1= new Student(Color.RED);
        line1.addStudent(student1);
        assertTrue(!line.getStudents().contains(student1));
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
        Professor professor=new Professor(Color.RED);
        line.addProfessor(professor);
        assertTrue(line.isProfessor()==true);
    }


    /**
     * Test the removeProfessor function
     */
    @Test
    public void removeProfessor(){
        Line line = new Line(Color.RED);
        Professor professor=new Professor(Color.RED);
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
        Professor professor=new Professor(Color.RED);
        line.addProfessor(professor);
        assertTrue(line.isProfessor()==true);
        line.removeProfessor(professor);
        assertTrue(line.isProfessor()==false);
    }


}
