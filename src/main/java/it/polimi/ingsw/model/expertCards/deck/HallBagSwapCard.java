package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.enumerations.Color;

/**
 * carta #12
 */
public class HallBagSwapCard implements ExpertCard {

    /**
     * Default constructor
     */
    public HallBagSwapCard() {
    }

    /**
     *
     */
    private Integer cost = 3;

    /**
     * 
     */
    private String id;

    /**
     *
     */
    private CardManager manager;

    /**
     * @param color
     */
    public void apply(Color color) {

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
    public void incrementCost() {
        cost = cost + 1;
    }

    @Override
    public String getId() {
        return this.id;

    }

    @Override
    public void setId(String id) {
        this.id= id;

    }

}