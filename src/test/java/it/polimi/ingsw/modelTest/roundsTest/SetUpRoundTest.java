package it.polimi.ingsw.modelTest.roundsTest;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.enumerations.PlayerPhase;
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
        player.setPlayerPhase(PlayerPhase.SET_UP_PHASE);
        game.setOrderedPLayerList(lista);
        game.setRound(game.setSetUpRound());
        game.chooseColorAndDeck( PlayerColor.WHITE, Wizard.BLUE_WIZARD);
        assertTrue(game.getCurrentPlayer().getPlayerColor()==PlayerColor.WHITE && game.getCurrentPlayer().getWizard()== Wizard.BLUE_WIZARD);
        //game.setCurrentPlayer(player1);
        //game.chooseColorAndDeck( PlayerColor.BLACK, Wizard.BLUE_WIZARD);
        //assertTrue(game.getCurrentPlayer().getPlayerColor()==null&& game.getCurrentPlayer().getWizard()== null);
        //game.getCurrentPlayer().setPlayerPhase(PlayerPhase.SET_UP_PHASE);
        //game.chooseColorAndDeck( PlayerColor.WHITE, Wizard.BLUE_WIZARD);
        //assertTrue(game.getCurrentPlayer().getPlayerColor()==null && game.getCurrentPlayer().getWizard()== null);
        game.chooseColorAndDeck( PlayerColor.BLACK, Wizard.GREEN_WIZARD);
        assertTrue(game.getCurrentPlayer().getPlayerColor()==PlayerColor.BLACK && game.getCurrentPlayer().getWizard()== Wizard.GREEN_WIZARD);
    }


}
