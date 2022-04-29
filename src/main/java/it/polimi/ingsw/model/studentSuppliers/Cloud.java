package it.polimi.ingsw.model.studentSuppliers;

import it.polimi.ingsw.model.objectTypes.FixedObjectStudent;
import it.polimi.ingsw.model.pawns.Student;
import java.util.*;

/**
 * 
 */
public class Cloud implements FixedObjectStudent {

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
    private LinkedList<Student> students = new LinkedList<Student>();


    /**
     * @param student
     */
    public void addStudent(Student student) {

        student.setPosition(this);
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
    public Integer numOfStudents() { return this.students.size(); }

    /**
     * @return
     */
    public String getId() { return this.id; }

}