package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.pawns.Student;

/**
 * card #9
 */
public class ColorInfluenceCard implements ExpertCard {

    /**
     * Default constructor
     */
    public ColorInfluenceCard(CardManager cardManager) {
        this.id = "46";
        this.manager=cardManager;
    }

    /**
     * 
     */
    private String id;

    /**
     *
     */
    private Integer cost = 3;

    /**
     *
     */
    private CardManager manager;

    /**
     *
     */
    private Color color;

    /**
     *
     */
    public void apply(Color color) {
        manager.getInfluenceManager().setColorInfluence(color);
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