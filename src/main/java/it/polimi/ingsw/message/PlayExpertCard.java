package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;

import java.io.Serializable;

public class PlayExpertCard implements Serializable,MessageMethod {

    /**
     * ID of the expertCard played
     */
    private String expertCard;

    /**
     * Parameter required in expert card effect
     */
    private String parameter = null;

    /**
     * Applies the changes to the model
     * @param game
     */
    @Override
    public void apply(Game game) {
        game.playExpertCard(expertCard, parameter);
    }

    /**
     * Sets the expert card
     * @param expertCard
     */
    public void setExpertCard(String expertCard){
        this.expertCard = expertCard;
    }

    /**
     * Sets the parameter
     * @param object
     */
    public void setParameter(String object){
        this.parameter = object;
    }

}
