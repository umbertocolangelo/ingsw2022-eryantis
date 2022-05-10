package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;

import java.io.Serializable;

public class ChoosingAssistant implements MessageMethod, Serializable {

    /**
     *
     */
    private String assistantCard;

    /**
     * @param game
     */
    @Override
    public void apply(Game game) {
        game.playAssistantCard(assistantCard);

    }

    /**
     *
     * @param assistantCard
     */
    public void setAssistantCard(String assistantCard){
        this.assistantCard = assistantCard;
    }

}
