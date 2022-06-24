package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.utils.IdManager;

import java.io.Serializable;

/**
 * card #4
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
     * 
     */
    private String id;

    /**
     *
     */
    private Integer cost = 1;


    /**
     * this appliance enables to move motherNature up to 2 more position and sets the new motherNature position
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
    public void incrementCost() {
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

}