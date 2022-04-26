package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.pawns.Student;

/**
 * carta #5
 */
public class DenyCard implements ExpertCard {

    /**
     * Default constructor
     */
    public DenyCard(CardManager cardManager) {
        this.manager=cardManager;
    }

    /**
     * 
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
    private Integer denyTokens = 4;

    /**
     * @param island
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
     *
     */
    public Integer getDenyTokens() {return this.denyTokens;}

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

    /**
     *
     * @param id
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

}