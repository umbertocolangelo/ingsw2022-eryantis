package it.polimi.ingsw.modelTest.roundsTest;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.AssistantCard;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.enumerations.PlayerPhase;
import it.polimi.ingsw.model.enumerations.Wizard;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.rounds.PianificationRound;
import org.junit.jupiter.api.Test;


import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test of PianificationRound class
 */
public class PianificationRoundTest {

    /**
     *Test of playAssistantCard method
     */
    @Test
    public void playAssistantCardTest() {
        Player player = new Player("elena");
        Player player1 = new Player("vittorio");
        Game game= new Game();
        LinkedList <Player> lista=new LinkedList<>();
        lista.add(player1);
        lista.add(player);
        game.setPlayerList(lista);
        game.initializeGame();
        game.chooseColorAndDeck(PlayerColor.WHITE.getId(),Wizard.BLUE_WIZARD.getId());
        game.chooseColorAndDeck(PlayerColor.BLACK.getId(),Wizard.GREEN_WIZARD.getId());
        assertTrue(game.getCurrentRound().playAssistantCard(AssistantCard.TWO_CARD,player)); // check that round permits the action
        assertTrue(!game.getCurrentRound().playAssistantCard(AssistantCard.TWO_CARD,player)); // check that round refuses the action
        assertTrue(!game.getCurrentRound().playAssistantCard(AssistantCard.TWO_CARD,player1)); // check that round refuses the action
        assertTrue(game.getCurrentRound().playAssistantCard(AssistantCard.FOUR_CARD,player1)); // check that round permits the action
    }

    /**
     * Test of getPlayerListOrdered method
     */
    @Test
    public void getPlayerListOrderedTest() {
        Player player = new Player("elena");
        Player player1 = new Player("vittorio");
        Player player2 = new Player("");
        Game game= new Game();
        LinkedList <Player> lista=new LinkedList<>();
        lista.add(player1);
        lista.add(player);
        lista.add(player2);
        game.setPlayerList(lista);
        game.initializeGame();
        game.setPianificationRoundState();
        player.setPlayerPhase(PlayerPhase.CHOOSING_ASSISTANT);
        player1.setPlayerPhase(PlayerPhase.CHOOSING_ASSISTANT);
        player2.setPlayerPhase(PlayerPhase.CHOOSING_ASSISTANT);
        game.playAssistantCard(AssistantCard.FOUR_CARD.getId());
        game.playAssistantCard(AssistantCard.THREE_CARD.getId());
        game.playAssistantCard(AssistantCard.TWO_CARD.getId());
        assertTrue(game.getOrderedPlayerList().get(0)==player2 && game.getOrderedPlayerList().get(1)==player && game.getOrderedPlayerList().get(2)==player1);
    }

}
