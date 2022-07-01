package it.polimi.ingsw.modelTest;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.*;
import it.polimi.ingsw.model.expertCards.deck.IngressCardSwapCard;
import it.polimi.ingsw.model.expertCards.deck.IngressHallSwapCard;
import it.polimi.ingsw.model.expertCards.deck.StudentToHallCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.pawns.Professor;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.pawns.Tower;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.rounds.PianificationRound;
import it.polimi.ingsw.model.studentSuppliers.Bag;
import it.polimi.ingsw.utils.IdManager;
import it.polimi.ingsw.utils.SavingManager;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test of Game class
 */
public class GameTests {

    /**
     * Test of expertStudentToIsland method
     */
    @Test
    public void expertStudentToIslandTest() {
        Game game = new Game();
        LinkedList<Player> list =new LinkedList<>();
        Player player1 = new Player("one");
        list.add(player1);
        list.add(new Player("two"));
        game.setPlayerList(list);
        game.initializeGame();
        game.chooseColorAndDeck(PlayerColor.WHITE.getId(),Wizard.GREEN_WIZARD.getId());
        game.chooseColorAndDeck(PlayerColor.BLACK.getId(),Wizard.BLUE_WIZARD.getId());
        game.playAssistantCard(AssistantCard.ONE_CARD.getId());
        game.playAssistantCard(AssistantCard.THREE_CARD.getId());
        game.getCurrentPlayer().setCoin(5);
        game.playExpertCard(IdManager.getInstance().getExpertCard("38").getId(),null);
        Student student1 = new Student(Color.RED);
        Student student = new Student(Color.YELLOW);
        game.getCurrentPlayer().getSchool().getHall().getLine(Color.RED).addStudent(student1);
        Island island = new Island();
        game.expertStudentToIsland(student.getId(),island.getId());
        assertTrue(island.getStudents().contains(student));
    }

    /**
     * Test of expertStudentToHall method
     */
    @Test
    public void expertStudentToHallTest(){
        Player player = new Player("one");
        Player player1 = new Player("two");
        Game game= new Game();
        LinkedList<Player> list =new LinkedList<>();
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
        Bag bag = new Bag(false);
        StudentToHallCard ingressCardSwapCard=new StudentToHallCard(game.getCardManager());
        player1.setCoin(5);
        game.playExpertCard(ingressCardSwapCard.getId(),null);
        Student student1=new Student(Color.RED);
        Student student=new Student(Color.YELLOW);
        game.expertStudentToHall(student1.getId());
        assertTrue( player1.getSchool().getHall().getLine(Color.RED).getStudents().contains(student1));
    }

    /**
     * Test of chooseColorAndDeck method
     */
    @Test
    public void chooseColorAndDeckTest(){
        Player player = new Player("one");
        Player player1=new Player("two");
        Game game = new Game();
        game.setCurrentPlayer(player);
        LinkedList<Player> list=new LinkedList<>();
        list.add(player);
        list.add(player1);
        game.setPlayerList(list);
        game.initializeGame();
        game.chooseColorAndDeck( PlayerColor.WHITE.getId(), Wizard.BLUE_WIZARD.getId());
        assertTrue(player.getPlayerColor()==PlayerColor.WHITE && player.getWizard()== Wizard.BLUE_WIZARD);
        game.chooseColorAndDeck( PlayerColor.BLACK.getId(), Wizard.GREEN_WIZARD.getId());
        assertTrue(player1.getPlayerColor()==PlayerColor.BLACK && player1.getWizard()== Wizard.GREEN_WIZARD);
    }


    /**
     * Test of getPlayerOrdered method
     */
    @Test
    public void getPlayerListOrderedTest() {
        Player player = new Player("one");
        Player player1 = new Player("two");
        Player player2 = new Player("three");
        Game game= new Game();
        LinkedList <Player> list=new LinkedList<>();
        list.add(player1);
        list.add(player);
        list.add(player2);
        game.setPlayerList(list);
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

    /**
     * Test of playAssistantCard method
     */
    @Test
    public void playAssistantCardTest() {
        Player player = new Player("one");
        Player player1 = new Player("two");
        Game game= new Game();
        LinkedList <Player> list=new LinkedList<>();
        list.add(player1);
        list.add(player);
        game.setPlayerList(list);
        game.initializeGame();
        player.setPlayerColor(PlayerColor.WHITE);
        player1.setPlayerColor(PlayerColor.GREY);
        game.setPianificationRoundState();
        player.setPlayerPhase(PlayerPhase.CHOOSING_ASSISTANT);
        player1.setPlayerPhase(PlayerPhase.CHOOSING_ASSISTANT);
        game.setCurrentPlayer(player1);
        game.playAssistantCard(AssistantCard.TWO_CARD.getId());
        game.setCurrentPlayer(player);
        game.playAssistantCard(AssistantCard.THREE_CARD.getId());
        assertTrue(game.getOrderedPlayerList().get(0)==player1 && game.getOrderedPlayerList().get(1)==player);
    }

    /**
     * Test of moveMotherNature method
     */
    @Test
    public void moveMotherNatureTest(){
        Player player = new Player("one");
        Player player1 = new Player("two");
        Game game= new Game();
        LinkedList <Player> list=new LinkedList<>();
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
        player.setPlayerPhase(PlayerPhase.MOVING_MOTHERNATURE);
        game.initializeGame();
        Island island= (Island) game.getMotherNature().getIsland();
        game.moveMotherNature(1);
        assertTrue((Island) game.getMotherNature().getIsland()==island);
    }


    /**
     * Test of moveIngressToHall method
     */
    @Test
    public void moveIngressToHallTest() {
        Game game= new Game();
        LinkedList <Player> list = new LinkedList<>();
        Player player = new Player("one");
        list.add(player);
        list.add(list.size(), new Player("two"));
        game.setPlayerList(list);
        game.initializeGame();
        game.chooseColorAndDeck(PlayerColor.GREY.getId(), Wizard.BLUE_WIZARD.getId());
        game.chooseColorAndDeck(PlayerColor.WHITE.getId(), Wizard.GREEN_WIZARD.getId());
        game.playAssistantCard(AssistantCard.TWO_CARD.getId());
        game.playAssistantCard(AssistantCard.THREE_CARD.getId());
        Student student = new Student(Color.RED);
        game.getCurrentPlayer().getSchool().getIngress().addStudent(student);
        game.moveStudentIngressToHall(student.getId());
        assertTrue( game.getCurrentPlayer().getSchool().getHall().getLine(student.getColor()).getStudents().contains(student) );
    }

    /**
     * Test of moveIngressToIsland method
     */
    @Test
    public void moveIngressToIslandTest() {
        Player player = new Player("one");
        Player player1 = new Player("two");
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
        game.getCurrentPlayer().getSchool().getIngress().addStudent(student);
        game.moveStudentIngressToIsland(student.getId(),"30");
        assertTrue( IdManager.getInstance().getIsland("30").getStudents().contains(student) && !game.getCurrentPlayer().getSchool().getIngress().getStudents().contains(student));
    }

    /**
     * Test of chooseCloud method
     */
    @Test
    public void chooseCloudTest() {
        Player player = new Player("one");
        Player player1 = new Player("two");
        Game game= new Game();
        LinkedList <Player> list=new LinkedList<>();
        list.add(player1);
        list.add(player);
        game.setPlayerList(list);
        game.initializeGame();
        game.chooseColorAndDeck(PlayerColor.WHITE.getId(),Wizard.GREEN_WIZARD.getId());
        game.chooseColorAndDeck(PlayerColor.BLACK.getId(),Wizard.BLUE_WIZARD.getId());
        game.playAssistantCard(AssistantCard.TWO_CARD.getId());
        game.playAssistantCard(AssistantCard.THREE_CARD.getId());
        game.getCurrentPlayer().getSchool().getIngress().removeStudent(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(0));
        game.getCurrentPlayer().getSchool().getIngress().removeStudent(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(0));
        game.getCurrentPlayer().getSchool().getIngress().removeStudent(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(0));
        LinkedList<Student> students0 = game.getClouds().get(0).getStudents();
        LinkedList<Student> students1 = game.getClouds().get(1).getStudents();
        game.chooseCloud(game.getClouds().get(0).getId());
        assertTrue(game.getClouds().get(0).getStudents().size()==3); // no student has to be moved
        game.getCurrentPlayer().setPlayerPhase(PlayerPhase.CHOOSING_CLOUD);
        game.chooseCloud(game.getClouds().get(0).getId());
        game.getCurrentPlayer().setPlayerPhase(PlayerPhase.CHOOSING_CLOUD);
        game.chooseCloud(game.getClouds().get(1).getId());
        assertTrue(game.getCurrentPlayer().getSchool().getIngress().getStudents().contains(students0.get(0))); // all the students have to be moved for the first player
        assertTrue(game.getCurrentPlayer().getSchool().getIngress().getStudents().contains(students0.get(1)));
        assertTrue(game.getCurrentPlayer().getSchool().getIngress().getStudents().contains(students0.get(2)));
        if(game.getCurrentPlayer()==player){game.setCurrentPlayer(player1);}else{game.setCurrentPlayer(player);}
        assertTrue(!game.getCurrentPlayer().getSchool().getIngress().getStudents().contains(students1.get(0))); //no student have to be moved for the second player cause is ingress is full
        assertTrue(!game.getCurrentPlayer().getSchool().getIngress().getStudents().contains(students1.get(1)));
        assertTrue(!game.getCurrentPlayer().getSchool().getIngress().getStudents().contains(students1.get(2)));
    }

    /**
     * Test of expertMoveToBag method
     */
    @Test
    public void expertMoveToBagFunction() {
        Player player = new Player("one");
        Game game = new Game();
        LinkedList<Player> list=new LinkedList<>();
        list.add(player);
        list.add(new Player("two"));
        game.setPlayerList(list);
        game.initializeGame();
        game.chooseColorAndDeck(PlayerColor.WHITE.getId(),Wizard.GREEN_WIZARD.getId());
        game.chooseColorAndDeck(PlayerColor.WHITE.getId(),Wizard.BLUE_WIZARD.getId());
        game.playAssistantCard(AssistantCard.ONE_CARD.getId());
        game.playAssistantCard(AssistantCard.THREE_CARD.getId());
        player.getSchool().getHall().getLine(Color.RED).addStudent(new Student(Color.RED));
        player.getSchool().getHall().getLine(Color.RED).addStudent(new Student(Color.RED));
        player.getSchool().getHall().getLine(Color.RED).addStudent(new Student(Color.RED));
        player.getSchool().getHall().getLine(Color.RED).addStudent(new Student(Color.RED));
        game.getCurrentPlayer().setCoin(5);
        game.playExpertCard(IdManager.getInstance().getExpertCard("49").getId(), Color.RED.getId());
        assertTrue(player.getSchool().getHall().getLine(Color.RED).getStudents().size() == 1);
    }

    /**
     * Test of checkWinner method when a player places all the towers (two players)
     */
    @Test
    public void checkWinnerTowers(){
        Player player1 = new Player("one");
        Player player2 = new Player("two");
        Game game= new Game();
        LinkedList <Player> list = new LinkedList<>();
        list.add(player1);
        list.add(player2);
        game.setPlayerList(list);
        game.initializeGame();
        game.chooseColorAndDeck(PlayerColor.WHITE.getId(), Wizard.GREEN_WIZARD.getId());
        game.chooseColorAndDeck(PlayerColor.BLACK.getId(),Wizard.BLUE_WIZARD.getId());
        // remove all the towers form player one school
        for (Tower t : player1.getSchool().getTowerTable().getTowers()){
            player1.getSchool().getTowerTable().removeTower(t);
        }
        game.checkWinner();
        // player one wins
        assertTrue(player1.getIsWinner());
        assertTrue(!player2.getIsWinner());
    }

    /**
     * Test of checkWinner method when a player places all the towers (three players)
     */
    @Test
    public void checkWinnerTowersThree(){
        Player player1 = new Player("one");
        Player player2 = new Player("two");
        Player player3 = new Player("three");
        Game game= new Game();
        LinkedList <Player> list = new LinkedList<>();
        list.add(player1);
        list.add(player2);
        list.add(player3);
        game.setPlayerList(list);
        game.initializeGame();
        game.chooseColorAndDeck(PlayerColor.WHITE.getId(), Wizard.GREEN_WIZARD.getId());
        game.chooseColorAndDeck(PlayerColor.BLACK.getId(),Wizard.BLUE_WIZARD.getId());
        game.chooseColorAndDeck(PlayerColor.WHITE.getId(),Wizard.PURPLE_WIZARD.getId());
        // remove all the towers form player two school
        for (Tower t : player2.getSchool().getTowerTable().getTowers()){
            player2.getSchool().getTowerTable().removeTower(t);
        }
        game.checkWinner();
        // player two wins
        assertTrue(!player1.getIsWinner());
        assertTrue(player2.getIsWinner());
        assertTrue(!player3.getIsWinner());
    }

    /**
     * Test of checkWinner method when the cards end (two players)
     */
    @Test
    public void checkWinnerCards(){
        Player player1 = new Player("one");
        Player player2 = new Player("two");
        Game game= new Game();
        LinkedList <Player> list = new LinkedList<>();
        list.add(player1);
        list.add(player2);
        game.setPlayerList(list);
        game.initializeGame();
        game.chooseColorAndDeck(PlayerColor.WHITE.getId(), Wizard.GREEN_WIZARD.getId());
        game.chooseColorAndDeck(PlayerColor.BLACK.getId(),Wizard.BLUE_WIZARD.getId());
        // remove all the assistant cards
        for (Player p : list){
            for(AssistantCard c : AssistantCard.values() ){
                p.playAssistantCard(c);
            }
        }
        player1.resetAssistantCard();
        player2.resetAssistantCard();
        // Player 1 has placed a tower
        player1.getSchool().getTowerTable().removeTower(player1.getSchool().getTowerTable().getTowers().get(0));
        game.checkWinner();
        // player one wins
        assertTrue(player1.getIsWinner());
        assertTrue(!player2.getIsWinner());

    }

    /**
     * Test of checkWinner method when the cards end (three players)
     */
    @Test
    public void checkWinnerCardsThree(){
        Player player1 = new Player("one");
        Player player2 = new Player("two");
        Player player3 = new Player("three");
        Game game= new Game();
        LinkedList <Player> list = new LinkedList<>();
        list.add(player1);
        list.add(player2);
        list.add(player3);
        game.setPlayerList(list);
        game.initializeGame();
        game.chooseColorAndDeck(PlayerColor.WHITE.getId(), Wizard.GREEN_WIZARD.getId());
        game.chooseColorAndDeck(PlayerColor.BLACK.getId(),Wizard.BLUE_WIZARD.getId());
        game.chooseColorAndDeck(PlayerColor.WHITE.getId(),Wizard.PURPLE_WIZARD.getId());
        // remove all the assistant cards
        for (Player p : list){
            for(AssistantCard c : AssistantCard.values() ){
                p.playAssistantCard(c);
            }
        }
        player1.resetAssistantCard();
        player2.resetAssistantCard();
        player3.resetAssistantCard();
        // Player 3 has placed a tower, players 1 and 2 have placed no towers
        player3.getSchool().getTowerTable().removeTower(player3.getSchool().getTowerTable().getTowers().get(0));
        game.checkWinner();
        // player three wins
        assertTrue(!player1.getIsWinner());
        assertTrue(!player2.getIsWinner());
        assertTrue(player3.getIsWinner());

    }

    /**
     * Test of checkWinner method when the cards end and player have the same number of towers (two players)
     */
    @Test
    public void checkWinnerCardsTie(){
        Player player1 = new Player("one");
        Player player2 = new Player("two");
        Game game= new Game();
        LinkedList <Player> list = new LinkedList<>();
        list.add(player1);
        list.add(player2);
        game.setPlayerList(list);
        game.initializeGame();
        game.chooseColorAndDeck(PlayerColor.WHITE.getId(), Wizard.GREEN_WIZARD.getId());
        game.chooseColorAndDeck(PlayerColor.BLACK.getId(),Wizard.BLUE_WIZARD.getId());
        // remove all the assistant cards
        for (Player p : list){
            for(AssistantCard c : AssistantCard.values() ){
                p.playAssistantCard(c);
            }
        }
        player1.resetAssistantCard();
        player2.resetAssistantCard();
        // Player 1 has three professors, player 2 has two professors
        player1.getSchool().getHall().getLine(Color.RED).addProfessor(Professor.getProfessor(Color.RED));
        player1.getSchool().getHall().getLine(Color.GREEN).addProfessor(Professor.getProfessor(Color.GREEN));
        player1.getSchool().getHall().getLine(Color.BLUE).addProfessor(Professor.getProfessor(Color.BLUE));
        player2.getSchool().getHall().getLine(Color.PINK).addProfessor(Professor.getProfessor(Color.PINK));
        player2.getSchool().getHall().getLine(Color.YELLOW).addProfessor(Professor.getProfessor(Color.YELLOW));
        game.checkWinner();
        // player one wins
        assertTrue(player1.getIsWinner());
        assertTrue(!player2.getIsWinner());

    }

    /**
     * Test of checkWinner method when the cards end and player have the same number of towers (three players)
     */
    @Test
    public void checkWinnerCardsTieThree() {
        Player player1 = new Player("one");
        Player player2 = new Player("two");
        Player player3 = new Player("three");
        Game game = new Game();
        LinkedList<Player> list = new LinkedList<>();
        list.add(player1);
        list.add(player2);
        list.add(player3);
        game.setPlayerList(list);
        game.initializeGame();
        game.chooseColorAndDeck(PlayerColor.WHITE.getId(), Wizard.GREEN_WIZARD.getId());
        game.chooseColorAndDeck(PlayerColor.BLACK.getId(), Wizard.BLUE_WIZARD.getId());
        game.chooseColorAndDeck(PlayerColor.WHITE.getId(), Wizard.PURPLE_WIZARD.getId());
        // remove all the assistant cards
        for (Player p : list) {
            for (AssistantCard c : AssistantCard.values()) {
                p.playAssistantCard(c);
            }
        }
        player1.resetAssistantCard();
        player2.resetAssistantCard();
        player3.resetAssistantCard();
        // Player one has 3 professors, player two has 1 professor and player three has 1 professor
        player1.getSchool().getHall().getLine(Color.RED).addProfessor(Professor.getProfessor(Color.RED));
        player1.getSchool().getHall().getLine(Color.GREEN).addProfessor(Professor.getProfessor(Color.GREEN));
        player1.getSchool().getHall().getLine(Color.BLUE).addProfessor(Professor.getProfessor(Color.BLUE));
        player2.getSchool().getHall().getLine(Color.PINK).addProfessor(Professor.getProfessor(Color.PINK));
        player3.getSchool().getHall().getLine(Color.YELLOW).addProfessor(Professor.getProfessor(Color.YELLOW));
        game.checkWinner();
        // player one wins
        assertTrue(player1.getIsWinner());
        assertTrue(!player2.getIsWinner());
        assertTrue(!player3.getIsWinner());
    }

    /**
     * Test of expertIngressCardSwap method
     */
    @Test
    public void  expertIngressCardSwapTest(){
        Player player = new Player("one");
        Player player1 = new Player("two");
        Game game= new Game();
        LinkedList <Player> list=new LinkedList<>();
        list.add(player1);
        list.add(player);
        game.setPlayerList(list);
        game.initializeGame();
        game.chooseColorAndDeck(PlayerColor.GREY.getId(), Wizard.BLUE_WIZARD.getId());
        game.chooseColorAndDeck(PlayerColor.WHITE.getId(),Wizard.GREEN_WIZARD.getId());
        game.playAssistantCard(AssistantCard.TWO_CARD.getId());
        game.playAssistantCard(AssistantCard.THREE_CARD.getId());
        IngressCardSwapCard ingressCardSwapCard=new IngressCardSwapCard(game.getCardManager());
        game.getCurrentPlayer().setCoin(5);
        game.playExpertCard(ingressCardSwapCard.getId(),null);
        Student student1=new Student(Color.RED);
        Student student=new Student(Color.YELLOW);
        game.getCurrentPlayer().getSchool().getIngress().addStudent(student);
        game.expertIngressCardSwap(student1.getId(),student.getId());
        assertTrue( game.getCurrentPlayer().getSchool().getIngress().getStudents().contains(student1));
    }

    /**
     * Test of expertHallIngressSwap method
     */
    @Test
    public void expertHallIngressSwapTest() {
        Player player = new Player("one");
        Player player1 = new Player("two");
        Game game = new Game();
        LinkedList<Player> list = new LinkedList<>();
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
        Bag bag=new Bag(false);
        IngressHallSwapCard ingressCardSwapCard = new IngressHallSwapCard();
        player1.setCoin(5);
        game.playExpertCard(ingressCardSwapCard.getId(),null);
        Student student1 = new Student(Color.RED);
        Student student = new Student(Color.YELLOW);
        System.out.println(game.getCurrentPlayer());
        player1.getSchool().getHall().getLine(Color.RED).addStudent(student1);
        player1.getSchool().getIngress().addStudent(student);
        game.expertIngressHallSwap(student1.getId(), student.getId());
        assertTrue(player1.getSchool().getIngress().getStudents().contains(student1) && !player1.getSchool().getIngress().getStudents().contains(student) && player1.getSchool().getHall().getLine(Color.YELLOW).getStudents().contains(student) && !player1.getSchool().getHall().getLine(Color.RED).getStudents().contains(student1));
    }


    /**
     * Test of deleteGame method
     */
    @Test
    public void deleteGameTest() {
        Player player1 = new Player("a");
        Player player2 = new Player("b");
        Game game= new Game();
        LinkedList <Player> list = new LinkedList<>();
        list.add(player1);
        list.add(player2);
        game.setPlayerList(list);
        game.initializeGame();
        game.chooseColorAndDeck(PlayerColor.WHITE.getId(),Wizard.GREEN_WIZARD.getId());
        game.chooseColorAndDeck(PlayerColor.BLACK.getId(),Wizard.BLUE_WIZARD.getId());
        game.saveGame();
        game.deleteGame();
    }

    /**
     * Test of saveGame method
     */
    @Test
    public void saveGameTest(){

        // for two players in expert mode
        Game gameSaved = new Game();
        LinkedList<Player> players = new LinkedList<>();
        players.add(new Player("B"));
        players.add(new Player("A"));
        players.get(0).setPlayerColor(PlayerColor.WHITE);
        players.get(1).setPlayerColor(PlayerColor.BLACK);
        gameSaved.setPlayerList(players);
        gameSaved.initializeGame();
        gameSaved.saveGame();
        File f = new File("eriantys_exp-A-B.save");
        assertTrue(f.exists() && !f.isDirectory()); // checks the save file is created correctly
        // delete the file for convenience
        SavingManager.getInstance().deleteSavedGame("eriantys_exp-A-B.save");

        // for three players in classic/normal mode
        gameSaved = new Game();
        players = new LinkedList<>();
        players.add(new Player("C"));
        players.add(new Player("B"));
        players.add(new Player("A"));
        players.get(0).setPlayerColor(PlayerColor.WHITE);
        players.get(1).setPlayerColor(PlayerColor.BLACK);
        players.get(2).setPlayerColor(PlayerColor.GREY);
        gameSaved.setPlayerList(players);
        gameSaved.setNormalMode();
        gameSaved.initializeGame();
        gameSaved.saveGame();
        f = new File("eriantys_cls-A-B-C.save");
        assertTrue(f.exists() && !f.isDirectory()); // checks the save file is created correctly
        // delete the file for convenience
        SavingManager.getInstance().deleteSavedGame("eriantys_cls-A-B-C.save");
    }

}

