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
     *
     */
    private Integer cost = 1;

    /**
     * 
     */
    private String id;

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


}