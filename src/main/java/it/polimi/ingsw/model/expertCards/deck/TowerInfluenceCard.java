package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.utils.IdManager;

import java.io.Serializable;

/**
 * card #6
 */
public class TowerInfluenceCard implements ExpertCard, Serializable {

    /**
     * Default constructor
     */
    public TowerInfluenceCard(CardManager cardManager) {
        this.id = "43";
        this.manager=cardManager;
        IdManager.getInstance().addExpertCard(this);
    }

    /**
     * Keep the reference to the id
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
        manager.getInfluenceManager().setTowerInfluence();
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
     *
     * @return
     */
    @Override
    public String getId() {
        return this.id;
    }


}