package it.polimi.ingsw.model.objectTypes;

import it.polimi.ingsw.model.pawns.Student;

import java.util.*;

/**
 * Interface used to represent an object on witch student pawns can stay
 */
public interface FixedObjectStudent extends FixedObject {

    /**
     * add student to the fixed object
     * @param student Student
     */
    void addStudent(Student student);

    /**
     * remove student from the fixed object
     * @param student Student
     */
    void removeStudent(Student student);

    /**
     * returns students on the fixed object
     * @return LinkedList
     */
    LinkedList<Student> getStudents();

    /**
     * @return number of students
     */
    Integer numOfStudents();

}