package it.polimi.ingsw.modelTest.roundsTest;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.enumerations.Wizard;
import it.polimi.ingsw.model.player.Player;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test of SetUpRound class
 */
public class SetUpRoundTest {

    /**
     * Test of chooseColorAndDeck method
     */
    @Test
    public void chooseColorAndDeckTest(){
        Player player = new Player("a");
        Player player1=new Player("b");
        Game game = new Game();
        game.setCurrentPlayer(player);
        LinkedList<Player> lista=new LinkedList<>();
        lista.add(player);
        lista.add(player1);
        game.setPlayerList(lista);
        game.initializeGame();
        assertTrue(game.getCurrentRound().chooseColorAndDeck(player, PlayerColor.WHITE, Wizard.BLUE_WIZARD)); // check that round permits the action
    }


}
