package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.pawns.Student;

/**
 * carta #12
 */
public class HallBagSwapCard implements ExpertCard {

    /**
     * Default constructor
     */
    public HallBagSwapCard(CardManager cardManager) {
        this.manager=cardManager;
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
        this.id= id;
    }

}