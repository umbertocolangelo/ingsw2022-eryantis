package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.utils.IdManager;

import java.io.Serializable;

/**
 * Expert card n.8, that grants to a player two additional points in the influence calculus
 */
public class TwoInfluenceCard implements ExpertCard, Serializable {

    /**
     * Default constructor
     */
    public TwoInfluenceCard(CardManager cardManager) {
        this.id = "45";
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
    private Integer cost = 2;

    /**
     * Reference to card manager
     */
    private CardManager manager;

    /**
     * appliance of the card effect
     */
    public void apply(Player player) {
        manager.getInfluenceManager().setTwoPointsInfluence(player);
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