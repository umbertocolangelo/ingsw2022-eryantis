package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;

import java.io.Serializable;

public class PlayExpertCard implements Serializable,MessageMethod {
    /**
     * Id of the expertCArd played
     */
    private String expertCard;

    /**
     *
     */
    private String parameter=null;
    /**
     * @param game
     */
    @Override
    public void apply(Game game) {
        game.playExpertCard(expertCard,parameter);
    }

    /**
     *
     * @param expert
     */
    public void setExpertCard(String expert){
        this.expertCard=expert;
    }


    public void setParameter(String object){
        parameter=object;
    }

}
