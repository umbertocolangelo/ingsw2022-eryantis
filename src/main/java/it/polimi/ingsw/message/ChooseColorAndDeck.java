package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.enumerations.Wizard;

import java.io.Serializable;

public class ChooseColorAndDeck implements MessageMethod, Serializable {

    /**
     * The player Color the player selected
     */
    private PlayerColor playerColor;

    /**
     * The Wizard that the palyer selected
     */
    private Wizard wizard;

    /**
     *
     * @param game This apply call the method chooseColorAndDeck on game
     */
    public void apply(Game game) {
        game.chooseColorAndDeck(playerColor, wizard);
    }

    /**
     *
     * @param playerColor   Set the playerColor
     */

    public void setPlayerColor(PlayerColor playerColor) {
        this.playerColor = playerColor;
    }

    /**
     *
     * @param coloredWizard Set the Wizard
     */
    public void setWizard(Wizard coloredWizard) { this.wizard = coloredWizard; }
}
