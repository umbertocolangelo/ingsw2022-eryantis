package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.objectTypes.FixedObjectStudent;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.rounds.RoundInterface;

import java.util.*;

/**
 * carta #7
 */
public class IngressCardSwapCard implements ExpertCard, FixedObjectStudent {

    /**
     * Default constructor
     */
    public IngressCardSwapCard(CardManager cardManager) {
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
    public void apply(Student studentCard, Student studentIngress) {
        removeStudent(studentCard);
        addStudent(studentIngress);
        incrementCost(); //si deve applicare una sola volta!
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
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id=id;
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