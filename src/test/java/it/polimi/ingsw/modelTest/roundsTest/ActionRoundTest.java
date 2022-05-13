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

public class ActionRoundTest {
    /**
     * Testing moveIngressToHall function
     */
    @Test
    public void moveIngressToHallTest() {
        Game game= new Game();
        LinkedList <Player> lista = new LinkedList<>();
        Player player = new Player("elena");
        lista.add(player);
        lista.add(lista.size(), new Player("vittorio"));
        game.setPlayerList(lista);
        game.initializeGame();
        game.chooseColorAndDeck(PlayerColor.GREY, Wizard.BLUE_WIZARD);
        game.chooseColorAndDeck(PlayerColor.WHITE, Wizard.GREEN_WIZARD);
        game.playAssistantCard(AssistantCard.TWO_CARD.getId());
        game.playAssistantCard(AssistantCard.THREE_CARD.getId());
        Student student = new Student(Color.RED);
        game.getCurrentPlayer().getSchool().getIngress().addStudent(student);
        System.out.println(game.getCurrentPlayer().getSchool().getIngress().numOfStudents());
        game.moveStudentIngressToHall(student.getId());
        System.out.println(game.getOrderedPLayerList());
        assertTrue( game.getCurrentPlayer().getSchool().getHall().getLine(student.getColor()).getStudents().contains(student) );

    }
    /**
     *
     */
    @Test
    public void moveMotherNatureTest(){
        Player player = new Player("elena");
        Player player1 = new Player("vittorio");
        Game game= new Game();
        LinkedList <Player> lista=new LinkedList<>();
        lista.add(player1);
        lista.add(player);
        game.setPlayerList(lista);
        player.setPlayerColor(PlayerColor.WHITE);
        player1.setPlayerColor(PlayerColor.GREY);
        game.initializeGame();
        game.setRound(game.setPianificationRoundState());
        player.setPlayerPhase(PlayerPhase.CHOOSING_ASSISTANT);
        player1.setPlayerPhase(PlayerPhase.CHOOSING_ASSISTANT);
        game.setCurrentPlayer(player1);
        game.playAssistantCard(AssistantCard.TWO_CARD.getId());
        game.setCurrentPlayer(player);
        game.playAssistantCard(AssistantCard.THREE_CARD.getId());
        player.setPlayerPhase(PlayerPhase.MOVING_MOTHERNATURE);
        game.initializeGame();
        Island island= (Island) game.getMotherNature().getIsland();
        game.moveMotherNature(1);
        assertTrue((Island) game.getMotherNature().getIsland()==island);
    }
    /**
     * Testing moveIngressToIsland function
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
        game.chooseColorAndDeck(PlayerColor.WHITE,Wizard.GREEN_WIZARD);
        game.chooseColorAndDeck(PlayerColor.BLACK,Wizard.BLUE_WIZARD);
        game.playAssistantCard(AssistantCard.TWO_CARD.getId());
        game.playAssistantCard(AssistantCard.THREE_CARD.getId());
        Student student = new Student(Color.RED);
        game.getCurrentPlayer().getSchool().getIngress().addStudent(student);
        game.moveStudentIngressToIsland(student.getId(),"30");
        assertTrue( IdManager.getInstance().getIsland("30").getStudents().contains(student) && !game.getCurrentPlayer().getSchool().getIngress().getStudents().contains(student));
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
        game.initializeGame();
        game.chooseColorAndDeck(PlayerColor.WHITE,Wizard.GREEN_WIZARD);
        game.chooseColorAndDeck(PlayerColor.BLACK,Wizard.BLUE_WIZARD);
        game.playAssistantCard(AssistantCard.TWO_CARD.getId());
        game.playAssistantCard(AssistantCard.THREE_CARD.getId());
        System.out.println(game.getCurrentPlayer().getName() + "chooses cloud");
        game.getCurrentPlayer().setPlayerPhase(PlayerPhase.CHOOSING_CLOUD);
        System.out.println(game.getCurrentPlayer().getName() + "chooses cloud");
        LinkedList<Student> students = game.getClouds().get(0).getStudents();
        game.chooseCloud(game.getClouds().get(0).getId());
        game.getCurrentPlayer().setPlayerPhase(PlayerPhase.CHOOSING_CLOUD);
        System.out.println(game.getCurrentPlayer().getName() + "chooses cloud");
        game.chooseCloud(game.getClouds().get(1).getId());
        System.out.println(game.getCurrentPlayer().getName() + "is the current player");
        assertTrue(game.getCurrentPlayer().getSchool().getIngress().getStudents().contains(students.get(0)));
        assertTrue(game.getCurrentPlayer().getSchool().getIngress().getStudents().contains(students.get(1)));
        assertTrue(game.getCurrentPlayer().getSchool().getIngress().getStudents().contains(students.get(2)));
    }

    /**
     * Testing expertMoveToBag function
     */

    @Test
    public void expertMoveToBagFunction() {
        Player player = new Player("vittorio");

        Game game = new Game();
        LinkedList<Player> lista=new LinkedList<>();
        lista.add(player);
        lista.add(new Player("two"));
        game.setExpertMode();
        game.setPLayerList(lista);
        game.initializeGame();
        game.chooseColorAndDeck(PlayerColor.WHITE,Wizard.GREEN_WIZARD);
        game.chooseColorAndDeck(PlayerColor.WHITE,Wizard.BLUE_WIZARD);
        game.playAssistantCard(AssistantCard.ONE_CARD.getId());
        game.playAssistantCard(AssistantCard.THREE_CARD.getId());
        player.getSchool().getHall().getLine(Color.RED).addStudent(new Student(Color.RED));
        player.getSchool().getHall().getLine(Color.RED).addStudent(new Student(Color.RED));
        player.getSchool().getHall().getLine(Color.RED).addStudent(new Student(Color.RED));
        player.getSchool().getHall().getLine(Color.RED).addStudent(new Student(Color.RED));
        //game.setCurrentPlayer(player);
        game.getCurrentPlayer().setCoin(5);
        game.playExpertCard(IdManager.getInstance().getExpertCard("49").getId(), Color.RED.getId());
        System.out.println(player.getSchool().getHall().getLine(Color.RED).getStudents().size());
        assertTrue(player.getSchool().getHall().getLine(Color.RED).getStudents().size() == 1);

    }

}
