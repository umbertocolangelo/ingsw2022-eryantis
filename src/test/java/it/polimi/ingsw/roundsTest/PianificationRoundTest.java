package it.polimi.ingsw.roundsTest;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.AssistantCard;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.enumerations.PlayerPhase;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.rounds.PianificationRound;
import org.junit.jupiter.api.Test;


import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PianificationRoundTest {
    /**
     *Testing playAssistantCard function
     */
    @Test
    public void playAssistantCArdTest() {
        Player player = new Player("elena");
        Player player1 = new Player("vittorio");
        Game game= new Game();
        LinkedList <Player> lista=new LinkedList<>();
        lista.add(player1);
        lista.add(player);
        game.setPlayerList(lista);
        player.setPlayerColor(PlayerColor.WHITE);
        player1.setPlayerColor(PlayerColor.GREY);
      game.setRound(game.setPianificationRoundState());
        player.setPlayerPhase(PlayerPhase.CHOOSING_ASSISTANT);
        player1.setPlayerPhase(PlayerPhase.CHOOSING_ASSISTANT);
       game.setCurrentPlayer(player1);
       game.playAssistantCard(AssistantCard.TWO_CARD);
        game.setCurrentPlayer(player);
       game.playAssistantCard(AssistantCard.THREE_CARD);







         /**System.out.println(pianificationRound.getAssistantCards().get(1));
         System.out.println(pianificationRound.getAssistantCards().get(2));
         System.out.println(pianificationRound.getAssistantCards().get(3));
         */
        assertTrue(game.getOrderedPLayerList().get(0)==player1 && game.getOrderedPLayerList().get(1)==player);
    }

    /**
     *
     */

    @Test
    public void getPlayerListOrderedTest() {
        Player player = new Player("elena");
        Player player1 = new Player("vittorio");
        Game game= new Game();
        LinkedList <Player> lista=new LinkedList<>();
        lista.add(player1);
        lista.add(player);
        game.setPlayerList(lista);
        game.setRound(game.setPianificationRoundState());
        player.setPlayerPhase(PlayerPhase.CHOOSING_ASSISTANT);
        player1.setPlayerPhase(PlayerPhase.CHOOSING_ASSISTANT);
        game.setCurrentPlayer(player1);
        game.playAssistantCard(AssistantCard.TWO_CARD);
        game.setCurrentPlayer(player);
        game.playAssistantCard(AssistantCard.THREE_CARD);

        assertTrue(game.getOrderedPLayerList().get(0)==player1 && game.getOrderedPLayerList().get(1)==player);
    }

    @Test
    public void getAssistantCardsTest() {
        Player player = new Player("elena");
        Player player1 = new Player("vittorio");
        Game game= new Game();
        PianificationRound pianificationRound = new PianificationRound(game);
        player.setPlayerPhase(PlayerPhase.CHOOSING_ASSISTANT);
        player1.setPlayerPhase(PlayerPhase.CHOOSING_ASSISTANT);
        pianificationRound.playAssistantCard(AssistantCard.TWO_CARD, player);
        pianificationRound.playAssistantCard(AssistantCard.THREE_CARD, player1);

        assertTrue(pianificationRound.getAssistantCards().get(0).getNum() == 2 && pianificationRound.getAssistantCards().get(1).getNum() == 3 );
    }




}
