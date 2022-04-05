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
    private LinkedList<Student> students=new LinkedList<Student>();

    /**
     * 
     */
    private Boolean isFourPlayers=false;

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
        if(!isFourPlayers && students.size()<4)
        this.students.add(student);
    }

    /**
     * @param student
     */
    public void removeStudent(Student student) {
        this.students.remove(this.students.indexOf(student));
    }

    /**
     * @return
     */
    public LinkedList<Student> getStudents() {
        return new LinkedList<>(this.students);
    }

    /**
     * @return
     */
    public Integer numOfStudents() {

        return this.students.size();
    }

}