package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.enumerations.Wizard;

public interface MessageMethod {

    public void apply(Game game);

    void setPlayerColor(PlayerColor white);

    void setWizard(Wizard purpleWizard);
}
