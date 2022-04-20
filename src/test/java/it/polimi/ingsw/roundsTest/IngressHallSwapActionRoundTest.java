package it.polimi.ingsw.roundsTest;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.AssistantCard;
import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.enumerations.PlayerPhase;
import it.polimi.ingsw.model.expertCards.deck.IngressCardSwapCard;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.Player;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IngressHallSwapActionRoundTest {
    /**
     * Testing expertHallIngressSwap function
     */
    @Test
    public void expertHallIngressSwapTest() {
        Player player = new Player("elena");
        Player player1 = new Player("vittorio");
        Game game = new Game();
        LinkedList<Player> lista = new LinkedList<>();
        lista.add(player1);
        lista.add(player);
        game.setPlayerList(lista);
        game.setRound(game.setPianificationnRoundState());
        player.setPlayerPhase(PlayerPhase.CHOOSING_ASSISTANT);
        player1.setPlayerPhase(PlayerPhase.CHOOSING_ASSISTANT);
        game.setCurrentPlayer(player1);
        game.playAssistantCard(AssistantCard.TWO_CARD);
        game.setCurrentPlayer(player);
        game.playAssistantCard(AssistantCard.THREE_CARD);
        IngressCardSwapCard ingressCardSwapCard = new IngressCardSwapCard();
        ingressCardSwapCard.setId("5");
        game.playExpertCard(ingressCardSwapCard);
        Student student1 = new Student(Color.RED);
        Student student = new Student(Color.YELLOW);
        System.out.println(game.getCurrentPlayer());
        player1.getSchool().getHall().getLine(Color.RED).addStudent(student1);
        player1.getSchool().getIngress().addStudent(student);
        game.expertIngressHallSwap(student1, student);
        assertTrue(player1.getSchool().getIngress().getStudents().contains(student1) && !player1.getSchool().getIngress().getStudents().contains(student) && player1.getSchool().getHall().getLine(Color.YELLOW).getStudents().contains(student) && !player1.getSchool().getHall().getLine(Color.RED).getStudents().contains(student1));
    }
}