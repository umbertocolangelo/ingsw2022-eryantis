package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.AssistantCard;

import java.io.Serializable;

public class ChoosingAssistant implements MessageMethod, Serializable {
    /**
     * @param game  This apply call the method playAssistantCArd in game
     */

    private AssistantCard assistantCard;
    @Override
    public void apply(Game game) {
        game.playAssistantCard(assistantCard);

    }

    public void setAssistantCard(AssistantCard assistantCard){
        this.assistantCard=assistantCard;
    }
}
