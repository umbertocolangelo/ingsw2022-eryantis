package it.polimi.ingsw.BoardTest;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.board.Ingress;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IngressTest {

    /**
     * Test on getStudent function.
     */
    @Test
    public void getStudentsTest() {
        Ingress ingress = new Ingress();
        Student student = new Student(Color.RED);
        ingress.addStudent(student);
        assertTrue(ingress.getStudents().contains(student));

    }

    /**
     * Test on removeStudent function.
     */
    @Test
    public void addStudentTest() {
        Ingress ingress = new Ingress();
        Student student = new Student(Color.RED);
        ingress.addStudent(student);
        assertTrue(ingress.getStudents().contains(student));

    }

    /**
     * Test on removeStudent function.
     */
    @Test
    public void removeStudentTest() {
        Ingress ingress = new Ingress();
        Student student = new Student(Color.RED);
        ingress.addStudent(student);
        assertTrue(ingress.getStudents().contains(student));
        ingress.removeStudent(student);
        assertTrue(!ingress.getStudents().contains(student));

    }

    /**
     * Test on numOfStudents.
     */

    @Test
    public void numOfStudentsTest() {
        Ingress ingress = new Ingress();
        Student student = new Student(Color.RED);
        Student student1 = new Student(Color.RED);
        ingress.addStudent(student);
        ingress.addStudent(student1);
        assertTrue(ingress.numOfStudents()==2);

    }
}