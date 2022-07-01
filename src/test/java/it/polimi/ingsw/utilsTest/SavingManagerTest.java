package it.polimi.ingsw.utilsTest;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.utils.IdManager;
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
        LinkedList<Player> players = new LinkedList<>();
        SavingManager.getInstance().saveGame(game,"test.save");
        File f = new File("test.save");
        assertTrue(f.exists() && !f.isDirectory()); // checks the save file is created correctly
        // delete the file for convenience
        SavingManager.getInstance().deleteSavedGame("test.save");
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
        gameSaved.initializeGame();
        gameSaved.saveGame();
        LinkedList<String> playerNames = new LinkedList<String>();
        playerNames.add("One");
        playerNames.add("Two");
        Game gameLoaded = SavingManager.getInstance().loadGame(playerNames, true);
        gameLoaded.setInstances();
        assertTrue(gameLoaded.getPlayerList().get(0).getName().equals("One"));
        // delete the file for convenience
        SavingManager.getInstance().deleteSavedGame("eriantys_exp-One-Two.save");
    }

    /**
     * Tests the deleteSaveGame method
     */
    @Test
    public void deleteSavedGameTest(){

        Game game = new Game();
        game.saveGame();
        System.out.println(SavingManager.getInstance().deleteSavedGame("eriantys"));
        File f = new File("eriantys");
        assertTrue(!f.exists());
    }

}
