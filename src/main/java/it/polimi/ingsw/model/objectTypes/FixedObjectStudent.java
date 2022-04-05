package it.polimi.ingsw.model.objectTypes;

import it.polimi.ingsw.model.pawns.Student;

import java.util.*;

/**
 * 
 */
public interface FixedObjectStudent extends FixedObject {

    /**
     * @param student
     */
    public void addStudent(Student student);

    /**
     * @param student
     */
    public void removeStudent(Student student);

    /**
     * @return
     */
    public LinkedList<Student> getStudents();

    /**
     * @return
     */
    public Integer numOfStudents();

}