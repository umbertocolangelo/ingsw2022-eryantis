package it.polimi.ingsw.utilsTest;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.player.Player;
import org.junit.jupiter.api.Test;

public class SavingManagerTest {

    @Test
    public void saveGameTest(){

        Game game = new Game();
        game.saveGame();
    }
}
