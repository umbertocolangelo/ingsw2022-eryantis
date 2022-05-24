package it.polimi.ingsw.modelTest.roundsTest;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.enumerations.Wizard;
import it.polimi.ingsw.model.player.Player;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetUpRoundTest {

    @Test
    public void chooseColorAndDeckTest(){
        Player player = new Player("vittorio");
        Player player1=new Player("elena");
        Game game = new Game();
        game.setCurrentPlayer(player);
        LinkedList<Player> lista=new LinkedList<>();
        lista.add(player);
        lista.add(player1);
        game.setPlayerList(lista);
        game.initializeGame();
        game.chooseColorAndDeck( PlayerColor.WHITE.getId(), Wizard.BLUE_WIZARD.getId());
        assertTrue(player.getPlayerColor()==PlayerColor.WHITE && player.getWizard()== Wizard.BLUE_WIZARD);
        game.chooseColorAndDeck( PlayerColor.BLACK.getId(), Wizard.GREEN_WIZARD.getId());
        assertTrue(player1.getPlayerColor()==PlayerColor.BLACK && player1.getWizard()== Wizard.GREEN_WIZARD);
    }


}
