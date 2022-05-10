package it.polimi.ingsw.modelTest.roundsTest;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.*;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.utils.IdManager;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentToIslandActionRoundTest {
    @Test
    public void expertStudentToIslandTest() {
        Game game = new Game();
        LinkedList<Player> lista=new LinkedList<>();
        Player player1 = new Player("one");
        lista.add(player1);
        lista.add(new Player("two"));
        game.setExpertMode();
        game.setPLayerList(lista);
        game.initializeGame();
        game.chooseColorAndDeck(PlayerColor.WHITE,Wizard.GREEN_WIZARD);
        game.chooseColorAndDeck(PlayerColor.WHITE,Wizard.BLUE_WIZARD);
        game.playAssistantCard(AssistantCard.ONE_CARD.getId());
        game.playAssistantCard(AssistantCard.THREE_CARD.getId());
        player1.setCoin(5);
        game.playExpertCard(IdManager.getInstance().getExpertCard("38"),null);
        System.out.println(game.getPreviousRound());
        Student student1 = new Student(Color.RED);
        Student student = new Student(Color.YELLOW);
        System.out.println(game.getCurrentPlayer());
        player1.getSchool().getHall().getLine(Color.RED).addStudent(student1);
        Island island = new Island();
        System.out.println(game.getCardManager().getCurrentCard());
        game.expertStudentToIsland(student,island);
        assertTrue(island.getStudents().contains(student));
    }

}