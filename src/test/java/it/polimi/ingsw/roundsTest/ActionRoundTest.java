package it.polimi.ingsw.roundsTest;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.AssistantCard;
import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.enumerations.PlayerPhase;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.expertCards.deck.HallBagSwapCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.pawns.MotherNature;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.rounds.ActionRound;
import it.polimi.ingsw.model.studentSuppliers.Cloud;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActionRoundTest {
    /**
     * Testing moveIngressToHall function
     */
    @Test
    public void moveIngressToHallTest() {
        Player player = new Player("elena");
        Player player1 = new Player("vittorio");
        Game game= new Game();
        LinkedList <Player> lista=new LinkedList<>();
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
        Student student = new Student(Color.RED);
        player.setPlayerPhase(PlayerPhase.MOVING_STUDENTS);
        player1.getSchool().getIngress().addStudent(student);
        game.moveStudentIngressToHall(student);
        assertTrue( player1.getSchool().getHall().getLine(student.getColor()).getStudents().contains(student) );

    }

    /**
     * Testing moveIngressToIsland function
     */

    @Test
    public void moveIngressToIslandTest() {
        Player player = new Player("elena");
        Player player1 = new Player("vittorio");
        Game game= new Game();
        LinkedList <Player> lista=new LinkedList<>();
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
        Student student = new Student(Color.RED);
        player.setPlayerPhase(PlayerPhase.MOVING_STUDENTS);
        player1.getSchool().getIngress().addStudent(student);
        Island island =new Island();
        game.moveStudentIngressToIsland(student,island);


        assertTrue( island.getStudents().contains(student) && !player1.getSchool().getIngress().getStudents().contains(student));
    }

    /**
     * Testing chooseCloud function
     */

    @Test
    public void chooseCloudTest() {
        Player player = new Player("elena");
        Player player1 = new Player("vittorio");
        Game game= new Game();
        LinkedList <Player> lista=new LinkedList<>();
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
        Student student = new Student(Color.RED);
        player1.setPlayerPhase(PlayerPhase.CHOOSING_CLOUD);
        Cloud cloud=new Cloud();
        cloud.addStudent(student);
        game.chooseCloud(cloud);


        assertTrue( player1.getSchool().getIngress().getStudents().contains(student));

    }

    /**
     * Testing expertMovetToBag function
     */

    @Test
    public void expertMovetToBagFunction() {
        Player player = new Player("vittorio");
        HallBagSwapCard expertCard = new HallBagSwapCard();
        Game game = new Game();
        game.setCurrentPlayer(player);
        LinkedList<Player> lista=new LinkedList<>();
        lista.add(player);
        game.setOrderedPLayerList(lista);
        player.getSchool().getHall().getLine(Color.RED).addStudent(new Student(Color.RED));
        player.getSchool().getHall().getLine(Color.RED).addStudent(new Student(Color.RED));
        player.getSchool().getHall().getLine(Color.RED).addStudent(new Student(Color.RED));
        player.getSchool().getHall().getLine(Color.RED).addStudent(new Student(Color.RED));
        game.setRound(new ActionRound(game));
        HallBagSwapCard hallBag = new HallBagSwapCard();
        hallBag.setId("3");
        game.getCurrentPlayer().setCoin(5);
        game.playExpertCard(hallBag);
        assertTrue(player.getSchool().getHall().getLine(Color.RED).getStudents().size() == 1);

    }
}
