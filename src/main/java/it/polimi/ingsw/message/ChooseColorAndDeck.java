package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;

import java.io.Serializable;

public class ChooseColorAndDeck implements MessageMethod, Serializable {

    /**
     * The player Color the player selected
     */
    private String playerColor;

    /**
     * The Wizard that the player selected
     */
    private String wizard;

    /**
     *
     * @param game This apply calls the method chooseColorAndDeck on game
     */
    public void apply(Game game) {
        game.chooseColorAndDeck(playerColor, wizard);
    }

    /**
     * Set the playerColor
     * @param playerColor
     */
    public void setPlayerColor(String playerColor) {
        this.playerColor = playerColor;
    }

    /**
     * Set the Wizard
     * @param coloredWizard
     */
    public void setWizard(String coloredWizard) { this.wizard = coloredWizard; }

}
