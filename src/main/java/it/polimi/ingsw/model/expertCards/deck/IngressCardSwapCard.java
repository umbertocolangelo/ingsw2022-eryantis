package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.objectTypes.FixedObjectStudent;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.rounds.RoundInterface;

import java.util.*;

/**
 * card #7
 */
public class IngressCardSwapCard implements ExpertCard, FixedObjectStudent {

    /**
     * Default constructor
     */
    public IngressCardSwapCard(CardManager cardManager) {
        this.id = "44";
        this.manager=cardManager;
        students = new LinkedList<Student>();
        for (int i=0; i<6; i++) {
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
    private LinkedList<Student> students;

    /**
     *
     */
    private CardManager manager;

    /**
     *
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
     * @param student
     */
    public void addStudent(Student student) {
        this.students.add(student);
    }

    /**
     * @param student
     */
    public void removeStudent(Student student) {
        this.students.remove(student);
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