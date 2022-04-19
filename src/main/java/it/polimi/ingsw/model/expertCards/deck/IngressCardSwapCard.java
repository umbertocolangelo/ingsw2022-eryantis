package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.objectTypes.FixedObjectStudent;
import it.polimi.ingsw.model.pawns.Student;
import java.util.*;

/**
 * 
 */
public class IngressCardSwapCard implements ExpertCard, FixedObjectStudent {

    /**
     * Default constructor
     */
    public IngressCardSwapCard() {
    }

    /**
     * 
     */
    private String id;

    /**
     * 
     */
    public void apply() {
        // TODO implement here
    }

    /**
     * @return
     */
    public Integer getCost() {
        // TODO implement here
        return null;
    }

    /**
     * 
     */
    public void incrementCost() {
        // TODO implement here
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
        // TODO implement here
    }

    /**
     * @param student
     */
    public void removeStudent(Student student) {
        // TODO implement here
    }

    /**
     * @return
     */
    public LinkedList<Student> getStudents() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Integer numOfStudents() {
        // TODO implement here
        return null;
    }

}