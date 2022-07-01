package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.utils.IdManager;

import java.io.Serializable;

/**
 * card #5
 */
public class DenyCard implements ExpertCard, Serializable {

    /**
     * Default constructor
     * @param cardManager CardManager
     */
    public DenyCard(CardManager cardManager) {
        this.id = "42";
        this.manager = cardManager;
        IdManager.getInstance().addExpertCard(this);
        cardManager.getInfluenceManager().setDenyCard(this);
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
     * Reference to deny tokens
     */
    private Integer denyTokens = 4;

    /**
     * Applies the effect of the card
     * @param island to deny
     */
    public void apply(Island island) {
        if (denyTokens>0) {
            island.setDeny();
            this.denyTokens = denyTokens-1;
            incrementCost();
        }
    }

    /**
     * Adds a token
     */
    public void addToken() {
        this.denyTokens = denyTokens+1;
    }

    /**
     * @return deny tokens
     */
    public Integer getDenyTokens() {return this.denyTokens;}

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