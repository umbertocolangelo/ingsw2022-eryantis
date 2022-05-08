package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.AssistantCard;

import java.io.Serializable;

public class ChoosingAssistant implements MessageMethod, Serializable {

    /**
     *
     */
    private AssistantCard assistantCard;

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
    public void setAssistantCard(AssistantCard assistantCard){
        this.assistantCard = assistantCard;
    }

}
