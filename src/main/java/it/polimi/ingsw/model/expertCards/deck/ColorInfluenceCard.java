package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.utils.IdManager;

import java.io.Serializable;

/**
 * card #9
 */
public class ColorInfluenceCard implements ExpertCard, Serializable {

    /**
     * Default constructor
     */
    public ColorInfluenceCard(CardManager cardManager) {
        this.id = "46";
        this.manager=cardManager;
        IdManager.getInstance().addExpertCard(this);
    }

    /**
     * Keep the reference to the id
     */
    private String id;

    /**
     *K
     */
    private Integer cost = 3;

    /**
     *
     */
    private CardManager manager;

    /**
     *
     */
    public void apply(Color color) {
        manager.getInfluenceManager().setColorInfluence(color);
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
     * @return
     */
    @Override
    public String getId() {
        return this.id;
    }


}