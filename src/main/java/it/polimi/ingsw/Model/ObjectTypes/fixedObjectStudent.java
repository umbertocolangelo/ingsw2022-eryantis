package it.polimi.ingsw.Model.ObjectTypes;

import it.polimi.ingsw.Model.Pawns.Student;

import java.util.*;

/**
 * 
 */
public interface fixedObjectStudent {

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
    public ArrayList<Student> getStudents();

    /**
     * @return
     */
    public Integer numOfStudents();

}