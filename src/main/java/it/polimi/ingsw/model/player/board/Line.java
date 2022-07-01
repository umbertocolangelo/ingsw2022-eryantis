package it.polimi.ingsw.model.player.board;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.objectTypes.FixedObjectProfessor;
import it.polimi.ingsw.model.objectTypes.FixedObjectStudent;
import it.polimi.ingsw.model.pawns.Professor;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.Player;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Line implements FixedObjectStudent, FixedObjectProfessor, Serializable {

    /**
     * Default constructor
     */
    public Line(Color color) {
        this.color = color;
    }

    /**
     * line color
     */
    private Color color;

    /**
     * students in the line
     */
    private LinkedList<Student> students = new LinkedList<>();

    /**
     * number of students in the line
     */
    private Integer studentsNum;

    /**
     * professor of the line
     */
    private Professor professor;

    /**
     * @return boolean true if the number of students make gain a coin and return true
     */
    public boolean checkCoin() {
        if(students.size()==3 || students.size()==6 || students.size()==9){
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return color of the line
     */
    public Color getColor() {
        return this.color;
    }


    /**
     * Add the student to student list of the line
     * @param student
     */
    public void addStudent(Student student) {
        if (student.getColor().equals(this.getColor())) {
            if (student.getPosition()!=null) {        // if the student was on a FixedObject, this object is updated
                FixedObjectStudent position = (FixedObjectStudent) student.getPosition();
                position.removeStudent(student);
            }
            student.setPosition(this);
            this.students.add(student);
        }
    }

    /**
     * Remove the student from the students list
     * @param student
     */
    public void removeStudent(Student student) {
        this.students.remove(students.indexOf(student));
    }

    /**
     * returns students in the line
     * @return LinkedList<Student>
     */
    public LinkedList<Student> getStudents() {
       return new LinkedList<>(this.students);
    }

    /**
     * Number of students
     * @return Integer
     */
    public Integer numOfStudents() {
        return this.students.size();
    }

    /**
     * Add the professor to the Line
     * @param professor
     */
    public void addProfessor(Professor professor) {
        if (professor.getColor().equals(this.getColor())) {
            if (professor.getPosition()!=null) {        // if the professor was on a FixedObject, this object is updated
                FixedObjectProfessor position = (FixedObjectProfessor) professor.getPosition();
                position.removeProfessor(professor);
            }
            professor.setPosition(this);
            this.professor = professor;
        }
    }

    /**
     * Remove the professor from the line
     * @param professor
     */
    public void removeProfessor(Professor professor) {
        this.professor = null;
    }

    /**
     * @return true if the professor is present on the line, else returns false
     */
    public Boolean isProfessor() {
        if (this.professor!=null) {
            return true;
        } else {
            return false;
        }
    }

}