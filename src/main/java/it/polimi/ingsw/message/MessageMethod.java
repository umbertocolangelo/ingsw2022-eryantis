package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.enumerations.Wizard;

public interface MessageMethod {

    /**
     *
     * @param game
     */
    public void apply(Game game);

    /**
     *
     * @param white
     */
    void setPlayerColor(PlayerColor white);

    /**
     *
     * @param purpleWizard
     */
    void setWizard(Wizard purpleWizard);

}
