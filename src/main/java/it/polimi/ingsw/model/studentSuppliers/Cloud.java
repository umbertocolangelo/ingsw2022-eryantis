package it.polimi.ingsw.model.studentSuppliers;

import it.polimi.ingsw.model.objectTypes.FixedObjectStudent;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.utils.IdManager;

import java.io.Serializable;
import java.util.*;


public class Cloud implements FixedObjectStudent, Serializable {

    /**
     * Default constructor
     */
    public Cloud() {
        this.id = idCounter.toString();
        IdManager.getInstance().addCloud(this);
        idCounter++;
        if (idCounter==53) {
            idCounter = 50;
        }
    }

    /**
     * Stores the current available id
     */
    private static Integer idCounter = 50;

    /**
     * cloud id
     */
    private String id;

    /**
     * list of the students on the cloud
     */
    private LinkedList<Student> students = new LinkedList<Student>();

    /**
     * add the student to the students list
     * @param student Student
     */
    public void addStudent(Student student) {
        student.setPosition(this);
        this.students.add(student);
    }

    /**
     * remove the student from its list
     * @param student
     */
    public void removeStudent(Student student) {
        this.students.remove(this.students.indexOf(student));
    }

    /**
     * @return list of students on the cloud
     */
    public LinkedList<Student> getStudents() {
        return new LinkedList<>(this.students);
    }

    /**
     * @return number of students on the cloud
     */
    public Integer numOfStudents() { return this.students.size(); }

    /**
     * @return cloud id
     */
    public String getId() { return this.id; }

}