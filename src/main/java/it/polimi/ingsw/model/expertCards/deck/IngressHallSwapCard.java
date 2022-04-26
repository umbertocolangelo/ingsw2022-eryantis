package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.rounds.RoundInterface;

/**
 * carta #10
 */
public class IngressHallSwapCard implements ExpertCard {

    /**
     * Default constructor
     */
    public IngressHallSwapCard(CardManager cardManager) {
        this.manager=cardManager;
    }

    /**
     * carta #10
     */
    private Integer cost = 1;

    /**
     * 
     */
    private String id;

    /**
     *
     */
    private CardManager manager;

    /**
     *
     */
    private RoundInterface round;

    /**
     * 
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