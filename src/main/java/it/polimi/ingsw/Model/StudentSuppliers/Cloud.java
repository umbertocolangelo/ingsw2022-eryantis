package it.polimi.ingsw.Model.StudentSuppliers;

import it.polimi.ingsw.Model.ObjectTypes.fixedObjectStudent;
import it.polimi.ingsw.Model.Pawns.Student;
import java.util.*;

/**
 * 
 */
public class Cloud implements fixedObjectStudent {

    /**
     * Default constructor
     */
    public Cloud() {
    }

    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private Collection<Student> students;

    /**
     * 
     */
    private Boolean isFourPlayers;

    /**
     * @return
     */
    public Boolean isFourPlayers() {
        // TODO implement here
        return null;
    }

    /**
     * @param student
     */
    public void addStudent(Student student) {
        // TODO implement here
    }

    /**
     * @param student
     */
    public void removeStudent(Student student) {
        // TODO implement here
    }

    /**
     * @return
     */
    public LinkedList<Student> getStudents() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Integer numOfStudents() {
        // TODO implement here
        return null;
    }

}