package it.polimi.ingsw.modelTest.studentsSuppliers;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.studentSuppliers.Cloud;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test of Cloud class
 */
public class CloudTest {

    /**
     * Test of addStudent method
     */
    @Test
    public void addStudentTest(){
        Cloud cloud= new Cloud();
        Student student=new Student(Color.RED);
        cloud.addStudent(student);
        assertTrue(cloud.getStudents().contains(student));
    }

    /**
     * Test of removeStudent method
     */
    @Test
    public void removeStudent(){
        Cloud cloud= new Cloud();
        Student student=new Student(Color.RED);
        cloud.addStudent(student);
        assertTrue(cloud.getStudents().contains(student));
        cloud.removeStudent(student);
        assertFalse(cloud.getStudents().contains(student));

    }

    /**
     * Test of getStudent method
     */
    @Test
    public void getStudentsTest(){
        Cloud cloud= new Cloud();
        Student student=new Student(Color.RED);
        cloud.addStudent(student);
        Student student1=new Student(Color.RED);
        cloud.addStudent(student1);
        assertTrue(cloud.getStudents().contains(student) && cloud.getStudents().contains(student1));
    }

    /**
     * Test of numOfStudent method
     */
    @Test
    public void numOfStudent(){
        Cloud cloud= new Cloud();
        Student student=new Student(Color.RED);
        cloud.addStudent(student);
        Student student1=new Student(Color.RED);
        cloud.addStudent(student1);
        assertTrue(cloud.getStudents().size()==2);
    }
}
