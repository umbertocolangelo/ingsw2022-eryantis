package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;

public interface MessageMethod {

    /**
     * Applies the changes to the model
     * @param game Game
     */
    public void apply(Game game);

}
