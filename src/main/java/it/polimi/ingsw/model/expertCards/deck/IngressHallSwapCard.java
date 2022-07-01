package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.utils.IdManager;

import java.io.Serializable;

/**
 * card #10
 */
public class IngressHallSwapCard implements ExpertCard, Serializable {

    /**
     * Default constructor
     */
    public IngressHallSwapCard() {
        this.id = "47";
        IdManager.getInstance().addExpertCard(this);
    }

    /**
     * card cost
     */
    private Integer cost = 1;

    /**
     * card id
     */
    private String id;

    /**
     * appliance of the effect of the card
     */
    public void apply() {
        incrementCost();
    }

    /**
     * @return card cost
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