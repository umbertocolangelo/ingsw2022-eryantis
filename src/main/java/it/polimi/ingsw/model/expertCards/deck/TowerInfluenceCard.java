package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.utils.IdManager;

import java.io.Serializable;

/**
 * Expert card n.6, that enables the calculus of influence without considering the towers present on the island
 */
public class TowerInfluenceCard implements ExpertCard, Serializable {

    /**
     * Default constructor
     */
    public TowerInfluenceCard(CardManager cardManager) {
        this.id = "43";
        this.manager = cardManager;
        IdManager.getInstance().addExpertCard(this);
    }

    /**
     * card id
     */
    private String id;

    /**
     * card cost
     */
    private Integer cost = 3;

    /**
     * Reference to card manager
     */
    private CardManager manager;

    /**
     * appliance of the card effect
     */
    public void apply() {
        manager.getInfluenceManager().setTowerInfluence();
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