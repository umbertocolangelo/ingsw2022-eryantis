package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;

import java.io.Serializable;

public class ChooseColorAndDeck implements MessageMethod, Serializable {

    /**
     * The player Color the player selected
     */
    private String playerColor;

    /**
     * The Wizard that the palyer selected
     */
    private String wizard;

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

    public void setPlayerColor(String playerColor) {
        this.playerColor = playerColor;
    }

    /**
     *
     * @param coloredWizard Set the Wizard
     */
    public void setWizard(String coloredWizard) { this.wizard = coloredWizard; }
}
