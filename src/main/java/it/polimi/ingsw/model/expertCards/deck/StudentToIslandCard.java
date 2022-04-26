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
    private CardManager manager;

    /**
     *
     */
    private LinkedList<Student> students;

    /**
     * move student to island (student has to be chosen by player)
     */
    public void apply() {
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
    private void incrementCost() {
        cost = cost + 1;
    }

    /**
     * @return
     */
    @Override
    public String getId() {
        return this.id;
    }

    /**
     * @param id
     */
    @Override
    public void setId(String id) {
        this.id = id;
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