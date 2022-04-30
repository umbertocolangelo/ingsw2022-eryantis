package it.polimi.ingsw.roundsTest;


import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.AssistantCard;
import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.enumerations.PlayerPhase;
import it.polimi.ingsw.model.expertCards.deck.IngressCardSwapCard;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.Player;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IngressCardSwapActionRoundTest {
    /**
     * Testing expertIngressCardSwap function
     */

    @Test
    public void  expertIngressCardSwapTest(){
        Player player = new Player("elena");
        Player player1 = new Player("vittorio");
        Game game= new Game();
        LinkedList <Player> lista=new LinkedList<>();
        lista.add(player1);
        lista.add(player);
        game.setPlayerList(lista);
        player.setPlayerColor(PlayerColor.WHITE);
        player1.setPlayerColor(PlayerColor.GREY);
        game.setRound(game.setPianificationnRoundState());
        player.setPlayerPhase(PlayerPhase.CHOOSING_ASSISTANT);
        player1.setPlayerPhase(PlayerPhase.CHOOSING_ASSISTANT);
        game.setCurrentPlayer(player1);
        game.playAssistantCard(AssistantCard.TWO_CARD);
        game.setCurrentPlayer(player);
        game.playAssistantCard(AssistantCard.THREE_CARD);
        IngressCardSwapCard ingressCardSwapCard=new IngressCardSwapCard(game.getCardManager());
        player1.setCoin(5);
        game.playExpertCard(ingressCardSwapCard);
        Student student1=new Student(Color.RED);
        Student student=new Student(Color.YELLOW);
        System.out.println(game.getCurrentPlayer());
        System.out.println(player1);
        player1.getSchool().getIngress().addStudent(student);
        game.expertIngressCardSwap(student1,student);
        assertTrue( player1.getSchool().getIngress().getStudents().contains(student1));
    }
}
