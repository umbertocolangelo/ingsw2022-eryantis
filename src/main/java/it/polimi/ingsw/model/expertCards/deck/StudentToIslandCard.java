package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.objectTypes.FixedObjectStudent;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.rounds.RoundInterface;

import java.util.*;

/**
 * carta #1
 */
public class StudentToIslandCard implements ExpertCard, FixedObjectStudent {

    /**
     * Default constructor
     */
    public StudentToIslandCard(CardManager cardManager) {
        this.manager = cardManager;
        students = new LinkedList<Student>();
        for (int i=0; i<4; i++) {
            addStudent(manager.getBag().newStudent());
        }
    }

    /**
     * 
     */
    private String id;

    /**
     *
     */
    private Integer cost = 1;

    /**
     *
     */
    private RoundInterface round;

    /**
     *
     */
    private CardManager manager;

    /**
     *
     */
    private LinkedList<Student> students;

    /**
     * move student to island (student has to be chosen by player)
     */
    public void apply(Island island, Student student) {
        round.expertStudentToIsland(student, island);
        removeStudent(student);
        addStudent(manager.getBag().newStudent());
        incrementCost();
    }

    /**
     * @return
     */
    public Integer getCost() {
        return this.cost;
    }

    /**
     * 
     */
    public void incrementCost() {
        cost = cost + 1;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(String id) {

    }

    /**
     * @param student
     */
    public void addStudent(Student student) {
        this.students.add(student);
    }

    /**
     * @param student is removed by the card
     */
    public void removeStudent(Student student) {
        students.remove(student);
    }

    /**
     * @return
     */
    public LinkedList<Student> getStudents() {
        return new LinkedList<Student>(this.students);
    }

    /**
     * @return
     */
    public Integer numOfStudents() {
        return this.students.size();
    }

}