package it.polimi.ingsw.studentsSuppliers;

import it.polimi.ingsw.Model.Enumerations.Color;
import it.polimi.ingsw.Model.Pawns.Student;
import it.polimi.ingsw.Model.StudentSuppliers.Cloud;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CloudTest {
    /**
     * Test addStudent function
     */
    @Test
    public void addStudentTest(){
        Cloud cloud= new Cloud();
        Student student=new Student(Color.RED);
        cloud.addStudent(student);
        assertTrue(cloud.getStudents().contains(student));
    }

    /**
     * Test removeStudent function
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
     * Test getStudent function
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
     * Test numOfStudent function
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
