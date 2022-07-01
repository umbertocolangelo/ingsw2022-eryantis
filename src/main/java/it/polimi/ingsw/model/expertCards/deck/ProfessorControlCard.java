package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.utils.IdManager;

import java.io.Serializable;

/**
 * Expert card n.2, that enables a player to gain control of a professor if the owner of the professor has the same students as him
 */
public class ProfessorControlCard implements ExpertCard, Serializable {

    /**
     * Default constructor
     */
    public ProfessorControlCard(CardManager cardManager) {
        this.id = "39";
        this.manager=cardManager;
        IdManager.getInstance().addExpertCard(this);
    }

    /**
     * card id
     */
    private String id;

    /**
     * card cost
     */
    private Integer cost = 2;

    /**
     * Reference to card manager
     */
    private CardManager manager;

    /**
     * appliance of the card effect
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
     * increments card cost
     */
    private void incrementCost() {
        cost = cost + 1;
    }

    /**
     * @return card id
     */
    @Override
    public String getId() {
        return this.id;
    }

}