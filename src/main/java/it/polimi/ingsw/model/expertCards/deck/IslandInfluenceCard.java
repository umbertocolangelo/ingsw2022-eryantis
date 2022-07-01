package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.islands.IslandInterface;
import it.polimi.ingsw.utils.IdManager;

import java.io.Serializable;

/**
 * Expert card n.3, that triggers the immediate influence calculus on an island choose by the player
 */
public class IslandInfluenceCard implements ExpertCard, Serializable {

    /**
     * Default constructor
     */
    public IslandInfluenceCard(CardManager cardManager) {
        this.id = "40";
        this.manager=cardManager;
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
     * @param island
     */
    public void apply(IslandInterface island) {
        manager.getInfluenceManager().calculateInfluence(island); // the influence calculus is immediately applied on the chosen island
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