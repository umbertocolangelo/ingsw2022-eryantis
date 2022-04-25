package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.pawns.Student;

/**
 * carta #5
 */
public class DenyCard implements ExpertCard {

    /**
     * Default constructor
     */
    public DenyCard(CardManager cardManager) {
        this.manager=cardManager;
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
    private Integer denyTokens = 4;

    /**
     * @param island
     */
    public void apply(Island island) {
        if (denyTokens>0) {
            island.setDeny();
            denyTokens -= 1;
            incrementCost();
        }
    }

    /**
     * Adds a token
     */
    public void addToken(){
        denyTokens += 1;
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