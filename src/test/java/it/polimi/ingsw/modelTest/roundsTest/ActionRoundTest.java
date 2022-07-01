package it.polimi.ingsw.modelTest.roundsTest;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.*;
import it.polimi.ingsw.model.expertCards.deck.DenyCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.utils.IdManager;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test of ActionRound class
 */
public class ActionRoundTest {

    /**
     * Test of moveIngressToHall method
     */
    @Test
    public void moveIngressToHallTest() {
        Game game= new Game();
        LinkedList <Player> list = new LinkedList<>();
        Player player = new Player("elena");
        list.add(player);
        list.add(list.size(), new Player("vittorio"));
        game.setPlayerList(list);
        game.initializeGame();
        game.chooseColorAndDeck(PlayerColor.GREY.getId(), Wizard.BLUE_WIZARD.getId());
        game.chooseColorAndDeck(PlayerColor.WHITE.getId(), Wizard.GREEN_WIZARD.getId());
        game.playAssistantCard(AssistantCard.TWO_CARD.getId());
        game.playAssistantCard(AssistantCard.THREE_CARD.getId());
        Student student = new Student(Color.RED);
        assertTrue(!game.getCurrentRound().moveStudentIngressToHall(student)); // check that round refuses action
        game.getCurrentPlayer().getSchool().getIngress().addStudent(student);
        assertTrue(game.getCurrentRound().moveStudentIngressToHall(student)); // check that round permits the action
    }

    /**
     * Test of moveMotherNature method
     */
    @Test
    public void moveMotherNatureTest(){
        Player player = new Player("one");
        Player player1 = new Player("two");
        Game game= new Game();
        LinkedList <Player> list =new LinkedList<>();
        list.add(player1);
        list.add(player);
        game.setPlayerList(list);
        player.setPlayerColor(PlayerColor.WHITE);
        player1.setPlayerColor(PlayerColor.GREY);
        game.initializeGame();
        game.setPianificationRoundState();
        player.setPlayerPhase(PlayerPhase.CHOOSING_ASSISTANT);
        player1.setPlayerPhase(PlayerPhase.CHOOSING_ASSISTANT);
        game.setCurrentPlayer(player1);
        game.playAssistantCard(AssistantCard.TWO_CARD.getId());
        game.setCurrentPlayer(player);
        game.playAssistantCard(AssistantCard.THREE_CARD.getId());
        assertTrue(!game.getCurrentRound().moveMotherNature(1)); // check that round refuses the action
        player.setPlayerPhase(PlayerPhase.MOVING_MOTHERNATURE);
        assertTrue(!game.getCurrentRound().moveMotherNature(5)); // check that round refuses the action
        assertTrue(!game.getCurrentRound().moveMotherNature(2)); // check that round permits the action
    }

    /**
     * Test of moveIngressToIsland method
     */
    @Test
    public void moveIngressToIslandTest() {
        Player player = new Player("elena");
        Player player1 = new Player("vittorio");
        Game game= new Game();
        LinkedList <Player> lista = new LinkedList<>();
        lista.add(player1);
        lista.add(player);
        game.setPlayerList(lista);
        game.initializeGame();
        game.chooseColorAndDeck(PlayerColor.WHITE.getId(),Wizard.GREEN_WIZARD.getId());
        game.chooseColorAndDeck(PlayerColor.BLACK.getId(),Wizard.BLUE_WIZARD.getId());
        game.playAssistantCard(AssistantCard.TWO_CARD.getId());
        game.playAssistantCard(AssistantCard.THREE_CARD.getId());
        Student student = new Student(Color.RED);
        // check that round refuses the action
        assertTrue(!game.getCurrentRound().moveStudentIngressToIsland(student,(Island)game.getIslandManager().getIslands().get(0)));
        game.getCurrentPlayer().getSchool().getIngress().addStudent(student);
        // check that round permits the action
        assertTrue(game.getCurrentRound().moveStudentIngressToIsland(student,(Island)game.getIslandManager().getIslands().get(0)));
    }

    /**
     * Test of chooseCloud method
     */

    @Test
    public void chooseCloudTest() {
        Player player = new Player("A");
        Player player1 = new Player("B");
        Game game= new Game();
        LinkedList <Player> list = new LinkedList<>();
        list.add(player1);
        list.add(player);
        game.setPlayerList(list);
        game.initializeGame();
        game.chooseColorAndDeck(PlayerColor.WHITE.getId(),Wizard.GREEN_WIZARD.getId());
        game.chooseColorAndDeck(PlayerColor.BLACK.getId(),Wizard.BLUE_WIZARD.getId());
        game.playAssistantCard(AssistantCard.TWO_CARD.getId());
        game.playAssistantCard(AssistantCard.THREE_CARD.getId());
        assertTrue(!game.getCurrentRound().chooseCloud(game.getClouds().get(0))); // check that round refuses the action
        game.getCurrentPlayer().setPlayerPhase(PlayerPhase.CHOOSING_CLOUD);
        assertTrue(game.getCurrentRound().chooseCloud(game.getClouds().get(0))); // check that round permits the action
    }

    /**
     * Test of playExpertCard method
     */

    @Test
    public void playExpertCard() {
        Player player = new Player("vittorio");
        Game game = new Game();
        LinkedList<Player> lista=new LinkedList<>();
        lista.add(player);
        lista.add(new Player("two"));
        game.setPlayerList(lista);
        game.initializeGame();
        game.chooseColorAndDeck(PlayerColor.WHITE.getId(),Wizard.GREEN_WIZARD.getId());
        game.chooseColorAndDeck(PlayerColor.BLACK.getId(),Wizard.BLUE_WIZARD.getId());
        game.playAssistantCard(AssistantCard.ONE_CARD.getId());
        game.playAssistantCard(AssistantCard.THREE_CARD.getId());
        game.getCurrentPlayer().setCoin(0);
        assertTrue(!game.getCurrentRound().playExpertCard(new DenyCard(game.getCardManager()))); // check that round refuses the action
        game.getCurrentPlayer().setCoin(5);
        assertTrue(game.getCurrentRound().playExpertCard(new DenyCard(game.getCardManager()))); // check that round permits the action
    }

}
