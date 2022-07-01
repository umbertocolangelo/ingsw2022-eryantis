package it.polimi.ingsw.model.player.board;

import it.polimi.ingsw.model.objectTypes.FixedObjectStudent;
import it.polimi.ingsw.model.pawns.Student;

import java.io.Serializable;
import java.util.*;

public class Ingress implements FixedObjectStudent, Serializable {

    /**
     * Default constructor
     */
    public Ingress() {

    }

    /**
     * ingress id
     */
    private String id;

    /**
     * max num of students in the ingress
     */
    private Integer maxStudentsNum;

    /**
     * list of the students in the ingress
     */
    private LinkedList<Student> students = new LinkedList<>();

    /**
     * Return the list of students in this ingress
     * @return LinkedList
     */
    public LinkedList<Student> getStudents() {
        return new LinkedList<>(this.students);
    }

    /**
     * Remove the student from the ingress
     * @param student
     */
    public void removeStudent(Student student) {
        if (this.students.contains(student)) {
            //remove the fixed object
            student.setPosition(this);
            students.remove(students.indexOf(student));
        }
    }

    /**
     * Add the student to the ingress
     * @param student
     */
    public void addStudent(Student student) {
        if (!this.students.contains(student)) {
            if (student.getPosition()!=null) {        // if the student was on a FixedObject, this object is updated
                FixedObjectStudent position = (FixedObjectStudent) student.getPosition();
                position.removeStudent(student);
            }
            student.setPosition(this);
            this.students.add(student);
        }
    }

    /**
     * Returns the number of the students
     * @return Integer
     */
    public Integer numOfStudents() {
        return this.students.size();
    }

}