package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.enumerations.Color;

/**
 * 
 */
public class ColorInfluenceCard implements ExpertCard {

    /**
     * Default constructor
     */
    public ColorInfluenceCard() {
    }

    /**
     * 
     */
    private String id;

    /**
     * @param color
     */
    public void apply(Color color) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Integer getCost() {
        // TODO implement here
        return null;
    }

    /**
     * 
     */
    public void incrementCost() {
        // TODO implement here
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(String id) {

    }

}