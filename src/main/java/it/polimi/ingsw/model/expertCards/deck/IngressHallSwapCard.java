package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.rounds.RoundInterface;

/**
 * card #10
 */
public class IngressHallSwapCard implements ExpertCard {

    /**
     * Default constructor
     */
    public IngressHallSwapCard() {
        this.id = "47";
    }

    /**
     *
     */
    private Integer cost = 1;

    /**
     * 
     */
    private String id;

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
     * @return
     */
    @Override
    public String getId() {
        return this.id;
    }


}