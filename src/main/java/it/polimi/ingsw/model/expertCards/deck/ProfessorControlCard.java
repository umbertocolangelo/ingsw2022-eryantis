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
    public ProfessorControlCard(CardManager cardManager) {
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
    private void incrementCost() {
        cost = cost + 1;
    }

    /**
     *
     * @return
     */
    @Override
    public String getId() {
        return this.id;
    }

    /**
     *
     * @param id
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

}