package it.polimi.ingsw.model.objectTypes;

import it.polimi.ingsw.model.pawns.Student;

import java.util.*;


public interface FixedObjectStudent extends FixedObject {

    /**
     * add student to the fixed object
     * @param student Student
     */
    public void addStudent(Student student);

    /**
     * remove student from the fixed object
     * @param student Student
     */
    public void removeStudent(Student student);

    /**
     * returns students on the fixed object
     * @return LinkedList
     */
    public LinkedList<Student> getStudents();

    /**
     * @return number of students
     */
    public Integer numOfStudents();

}