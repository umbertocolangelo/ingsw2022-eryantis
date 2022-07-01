package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;

import java.io.Serializable;

public class ChoosingAssistant implements MessageMethod, Serializable {

    /**
     * Assistant card chosen by the player
     */
    private String assistantCard;

    /**
     * Applies the change to the model
     * @param game Game
     */
    @Override
    public void apply(Game game) {
        game.playAssistantCard(assistantCard);
    }

    /**
     * Sets the assistant card chosen
     * @param assistantCard String
     */
    public void setAssistantCard(String assistantCard){
        this.assistantCard = assistantCard;
    }

}
