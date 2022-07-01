package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.utils.IdManager;

import java.io.Serializable;

/**
 * Expert card n.4, that enables a player to make move mother nature up to two islands more
 */
public class TwoJumpCard implements ExpertCard, Serializable {

    /**
     * Default constructor
     */
    public TwoJumpCard() {
        this.id = "41";
        IdManager.getInstance().addExpertCard(this);
    }

    /**
     * card id
     */
    private String id;

    /**
     * card cost
     */
    private Integer cost = 1;

    /**
     * this appliance enables to move motherNature up to 2 more position and sets the new motherNature position
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
    public void incrementCost() {
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