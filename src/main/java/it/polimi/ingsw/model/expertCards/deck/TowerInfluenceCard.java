package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;

/**
 * carta #6
 */
public class TowerInfluenceCard implements ExpertCard {

    /**
     * Default constructor
     */
    public TowerInfluenceCard() {
    }

    /**
     * 
     */
    private String id;

    /**
     *
     */
    private Integer cost = 3;

    /**
     *
     */
    private CardManager manager;

    /**
     * 
     */
    public void apply() {
        manager.getMotherNature().setTowerInfluence();
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

}