package it.polimi.ingsw.utilsTest;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.utils.SavingManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;

public class SavingManagerTest {

    @Test
    public void saveGameTest(){

        Game game = new Game();
        game.saveGame();
    }

    @Test
    public void loadGameTest(){

        Game gameSaved = new Game();
        LinkedList<Player> players = new LinkedList<>();
        players.add(new Player("One"));
        players.add(new Player("Two"));
        players.get(0).setPlayerColor(PlayerColor.WHITE);
        players.get(1).setPlayerColor(PlayerColor.BLACK);
        gameSaved.setPlayerList(players);
        gameSaved.saveGame();
        Game gameLoaded = SavingManager.getInstance().loadGame();
        assertTrue(gameLoaded.getPlayerList().get(0).getName().equals("One"));

    }
}
