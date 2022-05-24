package it.polimi.ingsw.modelTest.roundsTest;


import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.*;
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

        game.initializeGame();
        System.out.println("First player is " + game.getCurrentPlayer().getName());
        game.chooseColorAndDeck(PlayerColor.GREY.getId(), Wizard.BLUE_WIZARD.getId());
        game.chooseColorAndDeck(PlayerColor.WHITE.getId(),Wizard.GREEN_WIZARD.getId());
        System.out.println("First player is " + game.getCurrentPlayer().getName());
        game.playAssistantCard(AssistantCard.TWO_CARD.getId());
        game.playAssistantCard(AssistantCard.THREE_CARD.getId());
        IngressCardSwapCard ingressCardSwapCard=new IngressCardSwapCard(game.getCardManager());
        System.out.println("First player is " + game.getCurrentPlayer().getName());
        game.getCurrentPlayer().setCoin(5);
        game.playExpertCard(ingressCardSwapCard.getId(),null);
        Student student1=new Student(Color.RED);
        Student student=new Student(Color.YELLOW);
        System.out.println(game.getCurrentPlayer());
        System.out.println(player1);
        game.getCurrentPlayer().getSchool().getIngress().addStudent(student);
        game.expertIngressCardSwap(student1.getId(),student.getId());
        assertTrue( game.getCurrentPlayer().getSchool().getIngress().getStudents().contains(student1));
    }
}
