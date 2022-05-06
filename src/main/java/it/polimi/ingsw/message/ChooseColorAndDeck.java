package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.enumerations.Wizard;

import java.io.Serializable;

public class ChooseColorAndDeck implements MessageMethod, Serializable {
    private PlayerColor playerColor;

    private Wizard wizard;

    public void apply(Game game) {
        game.chooseColorAndDeck(playerColor,wizard);
    }


    @Override
    public void setPlayerColor(PlayerColor white) {
        this.playerColor=white;
    }

    @Override
    public void setWizard(Wizard purpleWizard) {
                this.wizard=purpleWizard;
    }
}
