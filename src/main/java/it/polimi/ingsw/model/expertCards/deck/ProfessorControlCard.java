package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.pawns.Student;

/**
 * carta #2
 */
public class ProfessorControlCard implements ExpertCard {

    /**
     * Default constructor
     */
    public ProfessorControlCard() {
    }

    /**
     * 
     */
    private String id;

    /**
     *
     */
    private Integer cost = 2;

    /**
     *
     */
    private CardManager manager;

    /**
     * 
     */
    public void apply() {
        manager.getProfessorManager().setEqualCheck();
        incrementCost();
    }

    /**
     * @return current cost of the card
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

    /**
     * @param student
     */
    @Override
    public void removeStudent(Student student) {

    }

    /**
     * @param student
     */
    @Override
    public void addStudent(Student student) {

    }

    @Override
    public void setId(String id) {

    }

}