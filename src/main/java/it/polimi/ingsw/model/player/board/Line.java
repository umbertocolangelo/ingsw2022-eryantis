package it.polimi.ingsw.model.player.board;

import it.polimi.ingsw.model.calculations.professor.ProfessorCalculator;
import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.objectTypes.FixedObjectProfessor;
import it.polimi.ingsw.model.objectTypes.FixedObjectStudent;
import it.polimi.ingsw.model.pawns.Professor;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.Player;
import java.util.*;

/**
 * 
 */
public class Line implements FixedObjectStudent, FixedObjectProfessor {

    /**
     * Default constructor
     */
    public Line(Color color) {
        this.color=color;

    }
    /**
     *
     */
    private Color color;

    /**
     * 
     */
    private LinkedList<Student> students=new LinkedList<>();

    /**
     * 
     */
    private Integer studentsNum;

    /**
     * 
     */
    private Professor professor;

    /**
     * 
     */
    private Player player;

    /**
     * 
     */
    private static ProfessorCalculator professorCalculator;


    /**
     * @return boolean      Check if the students make gain a coin and return true
     */
    private boolean checkCoin() {
        if(students.size()==2 || students.size()==5 || students.size()==8){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 
     */
    private void checkProfessor() {
        // TODO implement here
    }

    /**
     *
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * 
     */
    public static void setStandardCheck() {
        // TODO implement here
    }

    /**
     * 
     */
    public static void setEqualCheck() {
        // TODO implement here
    }

    /**
     * @param student       Add the student to the LinkedList
     */
    public void addStudent(Student student) {
        if(student.getColor().equals(this.getColor())) {
            if(student.getPosition()!=null){        // If the student was on a FixedObject, this object is updated
                FixedObjectStudent position = (FixedObjectStudent) student.getPosition();
                position.removeStudent(student);
            }
            student.setPosition(this);
            this.students.add(student);
        }
    }

    /**
     * @param student       Remoe the student from the LinkedList
     */
    public void removeStudent(Student student) {
        this.students.remove(students.indexOf(student));
    }

    /**
     * @return LinkedList<Student>      Return LinkedList<Student>
     */
    public LinkedList<Student> getStudents() {
       return new LinkedList<>(this.students);
    }

    /**
     * @return int          Return the number of students
     */
    public Integer numOfStudents() {
        return this.students.size();
    }

    /**
     * @param professor     Add the professor to the Line
     */
    public void addProfessor(Professor professor) {
        if(professor.getColor().equals(this.getColor())) {
            professor.setPosition(this);
            this.professor=professor;
        }
    }

    /**
     * @param professor         Remove the professor from the line
     */
    public void removeProfessor(Professor professor) {
        this.professor=null;
    }

    /**
     * @return boolean      Return if the professor is present on the line
     */
    public Boolean isProfessor() {
        if(this.professor!=null){
            return true;
           }
        else{
            return false;
             }
    }

}