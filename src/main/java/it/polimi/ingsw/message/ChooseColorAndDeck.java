package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.enumerations.Wizard;

import java.io.Serializable;

public class ChooseColorAndDeck implements MessageMethod, Serializable {

    /**
     *
     */
    private PlayerColor playerColor;

    /**
     *
     */
    private Wizard wizard;

    /**
     *
     * @param game
     */
    public void apply(Game game) {
        game.chooseColorAndDeck(playerColor, wizard);
    }

    /**
     *
     * @param playerColor
     */
    @Override
    public void setPlayerColor(PlayerColor playerColor) {
        this.playerColor = playerColor;
    }

    /**
     *
     * @param coloredWizard
     */
    @Override
    public void setWizard(Wizard coloredWizard) { this.wizard = coloredWizard; }
}
