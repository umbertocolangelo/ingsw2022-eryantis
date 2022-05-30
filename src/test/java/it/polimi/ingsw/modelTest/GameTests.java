package it.polimi.ingsw.modelTest;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.AssistantCard;
import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.enumerations.Wizard;
import it.polimi.ingsw.model.pawns.Professor;
import it.polimi.ingsw.model.pawns.Tower;
import it.polimi.ingsw.model.player.Player;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTests {

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
        System.out.println(player1.getSchool().getTowerTable().numOfTowers());
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
        System.out.println(player1.getSchool().getTowerTable().numOfTowers());
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
}

