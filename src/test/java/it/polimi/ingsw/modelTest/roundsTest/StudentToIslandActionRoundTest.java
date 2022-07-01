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

/**
 * Test of StudentToIslandActionRound class
 */
public class StudentToIslandActionRoundTest {

    /**
     * Test of expertStudentToIsland method
     */
    @Test
    public void expertStudentToIslandTest() {
        Game game = new Game();
        LinkedList<Player> lista=new LinkedList<>();
        Player player1 = new Player("one");
        lista.add(player1);
        lista.add(new Player("two"));
        game.setPlayerList(lista);
        game.initializeGame();
        game.chooseColorAndDeck(PlayerColor.WHITE.getId(),Wizard.GREEN_WIZARD.getId());
        game.chooseColorAndDeck(PlayerColor.BLACK.getId(),Wizard.BLUE_WIZARD.getId());
        game.playAssistantCard(AssistantCard.ONE_CARD.getId());
        game.playAssistantCard(AssistantCard.THREE_CARD.getId());
        game.getCurrentPlayer().setCoin(5);
        game.playExpertCard(IdManager.getInstance().getExpertCard("38").getId(),null);
        System.out.println(game.getPreviousRound());
        Student student1 = new Student(Color.RED);
        Student student = new Student(Color.YELLOW);
        System.out.println(game.getCurrentPlayer());
        game.getCurrentPlayer().getSchool().getHall().getLine(Color.RED).addStudent(student1);
        Island island = new Island();
        System.out.println(game.getCardManager().getCurrentCard());
        game.expertStudentToIsland(student.getId(),island.getId());
        assertTrue(island.getStudents().contains(student)); // check that round has permitted the action
    }

}