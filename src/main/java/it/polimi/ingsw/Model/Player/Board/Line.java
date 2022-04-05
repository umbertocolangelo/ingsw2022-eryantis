package it.polimi.ingsw.Model.Player.Board;

import it.polimi.ingsw.Model.Calculations.Professor.ProfessorCalculator;
import it.polimi.ingsw.Model.Enumerations.Color;
import it.polimi.ingsw.Model.ObjectTypes.fixedObjectProfessor;
import it.polimi.ingsw.Model.ObjectTypes.fixedObjectStudent;
import it.polimi.ingsw.Model.Pawns.Professor;
import it.polimi.ingsw.Model.Pawns.Student;
import it.polimi.ingsw.Model.Player.Player;
import java.util.*;

/**
 * 
 */
public class Line implements fixedObjectStudent, fixedObjectProfessor {

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
    private ProfessorCalculator professorCalculator;


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
    public void setStandardCheck() {
        // TODO implement here
    }

    /**
     * 
     */
    public void setEqualCheck() {
        // TODO implement here
    }

    /**
     * @param student       Add the student to the LinkedList
     */
    public void addStudent(Student student) {
        if(student.getColor().equals(this.getColor())) {
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
       return this.students;
    }

    /**
     * @return int          Return the number of students
     */
    public Integer numOfStudents() {
        return students.size();
    }

    /**
     * @param professor     Add the professor to the Line
     */
    public void addProfessor(Professor professor) {
        if(professor.getColor().equals(this.getColor())) {
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