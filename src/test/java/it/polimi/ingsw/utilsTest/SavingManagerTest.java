package it.polimi.ingsw.utilsTest;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.utils.SavingManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.LinkedList;

/**
 * Tests the methods of SavingManager
 */
public class SavingManagerTest {

    /**
     * Tests the saveGame method
     */
    @Test
    public void saveGameTest(){

        Game game = new Game();
        game.saveGame();
        File f = new File("eriantys.save");
        assertTrue(f.exists() && !f.isDirectory());
    }

    /**
     * Tests the loadGame method
     */
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

    /**
     * Tests the deleteSaveGame method
     */
    @Test
    public void deleteSavedGameTest(){

        Game game = new Game();
        game.saveGame();
        SavingManager.getInstance().deleteSavedGame();
        File f = new File("eriantys.save");
        assertTrue(!f.exists());
    }

}
