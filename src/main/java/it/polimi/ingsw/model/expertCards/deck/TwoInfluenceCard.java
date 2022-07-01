package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.utils.IdManager;

import java.io.Serializable;

/**
 * card #8
 */
public class TwoInfluenceCard implements ExpertCard, Serializable {

    /**
     * Default constructor
     */
    public TwoInfluenceCard(CardManager cardManager) {
        this.id = "45";
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
    private Integer cost = 2;

    /**
     *
     */
    private CardManager manager;

    /**
     * 
     */
    public void apply(Player player) {
        manager.getInfluenceManager().setTwoPointsInfluence(player);
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