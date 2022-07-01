package it.polimi.ingsw.modelTest.calculationsTest.professorTest;

import it.polimi.ingsw.model.calculations.professor.ProfessorManager;
import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.pawns.Professor;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.player.board.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Test of ProfessorManager class
 */
public class ProfessorMangerTest {

    /**
     * resets the position of the professors
     */
    @BeforeEach
    public void resetProfessorPosition(){
        for(Color color : Color.values()){
            Professor.getProfessor(color).setPosition(null);
        }
    }


    /**
     * Tests the checkProfessor method with two players with the equal strategy
     */
    @Test
    public void checkProfessorsTwoPlayersEqual(){
        Player player1 = new Player("A");
        player1.setPlayerColor(PlayerColor.BLACK);
        Player player2 = new Player("B");
        player2.setPlayerColor(PlayerColor.WHITE);
        Collection<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        ProfessorManager professorManager = new ProfessorManager(players);
        professorManager.setEqualCheck();

        professorManager.checkProfessor(player1);
        assertTrue(Professor.getProfessor(Color.YELLOW).getPosition()==null); //Check that no action is taken
        assertTrue(Professor.getProfessor(Color.BLUE).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.GREEN).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.RED).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.PINK).getPosition()==null);

        professorManager.setEqualCheck();
        player1.getSchool().getHall().addStudent(new Student(Color.YELLOW)); //adds a yellow student to player1's school
        professorManager.checkProfessor(player1);
        assertTrue(Professor.getProfessor(Color.YELLOW).getPosition()==player1.getSchool().getHall().getLine(Color.YELLOW)); //Checks that only yellow professor is on player1's school
        assertTrue(Professor.getProfessor(Color.BLUE).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.GREEN).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.RED).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.PINK).getPosition()==null);

        professorManager.setEqualCheck();
        player2.getSchool().getHall().addStudent(new Student(Color.YELLOW)); //adds a yellow student to player2's school
        professorManager.checkProfessor(player2);
        assertTrue(Professor.getProfessor(Color.YELLOW).getPosition()==player2.getSchool().getHall().getLine(Color.YELLOW)); //Check that the yellow professor has been moved
        assertTrue(Professor.getProfessor(Color.BLUE).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.GREEN).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.RED).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.PINK).getPosition()==null);

        professorManager.setEqualCheck();
        player2.getSchool().getHall().addStudent(new Student(Color.YELLOW)); //adds a second yellow student to player2's school
        professorManager.checkProfessor(player2);
        assertTrue(Professor.getProfessor(Color.YELLOW).getPosition()==player2.getSchool().getHall().getLine(Color.YELLOW)); //Check that no action is taken
        assertTrue(Professor.getProfessor(Color.BLUE).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.GREEN).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.RED).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.PINK).getPosition()==null);

        professorManager.setEqualCheck();
        player1.getSchool().getHall().addStudent(new Student(Color.RED)); //adds a red student to player1's school
        professorManager.checkProfessor(player1);
        assertTrue(Professor.getProfessor(Color.YELLOW).getPosition()==player2.getSchool().getHall().getLine(Color.YELLOW)); //Check that yellow professor is still on player2's school
        assertTrue(Professor.getProfessor(Color.BLUE).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.GREEN).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.RED).getPosition()==player1.getSchool().getHall().getLine(Color.RED)); // Check that red professor is now on player1's school
        assertTrue(Professor.getProfessor(Color.PINK).getPosition()==null);

    }

    /**
     * Tests the checkProfessor method with two players with the standard strategy
     */
    @Test
    public void checkProfessorsTwoPlayersStandard(){
        Player player1 = new Player("A");
        player1.setPlayerColor(PlayerColor.BLACK);
        Player player2 = new Player("B");
        player2.setPlayerColor(PlayerColor.WHITE);
        Collection<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        ProfessorManager professorManager = new ProfessorManager(players);

        professorManager.checkProfessor(player1);
        assertTrue(Professor.getProfessor(Color.YELLOW).getPosition()==null); //Check that no action is taken
        assertTrue(Professor.getProfessor(Color.BLUE).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.GREEN).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.RED).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.PINK).getPosition()==null);

        player1.getSchool().getHall().addStudent(new Student(Color.YELLOW)); //adds a yellow student to player1's school
        professorManager.checkProfessor(player1);
        assertTrue(Professor.getProfessor(Color.YELLOW).getPosition()==player1.getSchool().getHall().getLine(Color.YELLOW)); //Checks that only yellow professor is on player1's school
        assertTrue(Professor.getProfessor(Color.BLUE).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.GREEN).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.RED).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.PINK).getPosition()==null);

        player2.getSchool().getHall().addStudent(new Student(Color.YELLOW)); //adds a yellow student to player2's school
        professorManager.checkProfessor(player2);
        assertTrue(Professor.getProfessor(Color.YELLOW).getPosition()==player1.getSchool().getHall().getLine(Color.YELLOW)); //Check that no action is taken
        assertTrue(Professor.getProfessor(Color.BLUE).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.GREEN).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.RED).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.PINK).getPosition()==null);

        player2.getSchool().getHall().addStudent(new Student(Color.YELLOW)); //adds a second yellow student to player2's school
        professorManager.checkProfessor(player2);
        assertTrue(Professor.getProfessor(Color.YELLOW).getPosition()==player2.getSchool().getHall().getLine(Color.YELLOW)); //Check that yellow professor is now on player2's school
        assertTrue(Professor.getProfessor(Color.BLUE).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.GREEN).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.RED).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.PINK).getPosition()==null);

        player1.getSchool().getHall().addStudent(new Student(Color.RED)); //adds a red student to player1's school
        professorManager.checkProfessor(player1);
        assertTrue(Professor.getProfessor(Color.YELLOW).getPosition()==player2.getSchool().getHall().getLine(Color.YELLOW)); //Check that yellow professor is still on player2's school
        assertTrue(Professor.getProfessor(Color.BLUE).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.GREEN).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.RED).getPosition()==player1.getSchool().getHall().getLine(Color.RED)); // Check that red professor is now on player1's school
        assertTrue(Professor.getProfessor(Color.PINK).getPosition()==null);

    }

    /**
     * Tests the checkProfessor method with three players with the equal strategy
     */
    @Test
    public void checkProfessorsThreePlayersEqual(){
        Player player1 = new Player("A");
        player1.setPlayerColor(PlayerColor.BLACK);
        Player player2 = new Player("B");
        player2.setPlayerColor(PlayerColor.WHITE);
        Player player3 = new Player("C");
        player3.setPlayerColor(PlayerColor.GREY);
        Collection<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        ProfessorManager professorManager = new ProfessorManager(players);
        professorManager.setEqualCheck();

        professorManager.checkProfessor(player1);
        assertTrue(Professor.getProfessor(Color.YELLOW).getPosition()==null); //Check that no action is taken
        assertTrue(Professor.getProfessor(Color.BLUE).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.GREEN).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.RED).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.PINK).getPosition()==null);


        professorManager.setEqualCheck();
        player1.getSchool().getHall().addStudent(new Student(Color.YELLOW)); //adds a yellow student to player1's school
        professorManager.checkProfessor(player1);
        assertTrue(Professor.getProfessor(Color.YELLOW).getPosition()==player1.getSchool().getHall().getLine(Color.YELLOW)); //Checks that only yellow professor is on player1's school
        assertTrue(Professor.getProfessor(Color.BLUE).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.GREEN).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.RED).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.PINK).getPosition()==null);


        professorManager.setEqualCheck();
        player2.getSchool().getHall().addStudent(new Student(Color.YELLOW)); //adds a yellow student to player2's school
        professorManager.checkProfessor(player2);
        assertTrue(Professor.getProfessor(Color.YELLOW).getPosition()==player2.getSchool().getHall().getLine(Color.YELLOW)); //Check that the yellow professor has been moved
        assertTrue(Professor.getProfessor(Color.BLUE).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.GREEN).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.RED).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.PINK).getPosition()==null);


        professorManager.setEqualCheck();
        player2.getSchool().getHall().addStudent(new Student(Color.YELLOW)); //adds a second yellow student to player2's school
        professorManager.checkProfessor(player2);
        assertTrue(Professor.getProfessor(Color.YELLOW).getPosition()==player2.getSchool().getHall().getLine(Color.YELLOW)); //Check that no action is taken
        assertTrue(Professor.getProfessor(Color.BLUE).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.GREEN).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.RED).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.PINK).getPosition()==null);

        professorManager.setEqualCheck();
        player1.getSchool().getHall().addStudent(new Student(Color.RED)); //adds a red student to player1's school
        professorManager.checkProfessor(player1);
        assertTrue(Professor.getProfessor(Color.YELLOW).getPosition()==player2.getSchool().getHall().getLine(Color.YELLOW)); //Check that yellow professor is still on player2's school
        assertTrue(Professor.getProfessor(Color.BLUE).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.GREEN).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.RED).getPosition()==player1.getSchool().getHall().getLine(Color.RED)); // Check that red professor is now on player1's school
        assertTrue(Professor.getProfessor(Color.PINK).getPosition()==null);

        professorManager.setEqualCheck();
        player3.getSchool().getHall().addStudent(new Student(Color.BLUE));
        player3.getSchool().getHall().addStudent(new Student(Color.BLUE));
        player3.getSchool().getHall().addStudent(new Student(Color.BLUE)); //adds three blue students to player3's school
        professorManager.checkProfessor(player3);
        assertTrue(Professor.getProfessor(Color.YELLOW).getPosition()==player2.getSchool().getHall().getLine(Color.YELLOW)); //Check that yellow professor is still on player2's school
        assertTrue(Professor.getProfessor(Color.BLUE).getPosition()==player3.getSchool().getHall().getLine(Color.BLUE));
        assertTrue(Professor.getProfessor(Color.GREEN).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.RED).getPosition()==player1.getSchool().getHall().getLine(Color.RED)); // Check that red professor is now on player1's school
        assertTrue(Professor.getProfessor(Color.PINK).getPosition()==null);

    }

    /**
     * Tests the checkProfessor method with three players with the equal strategy
     */
    @Test
    public void checkProfessorsThreePlayersStandard(){
        Player player1 = new Player("A");
        player1.setPlayerColor(PlayerColor.BLACK);
        Player player2 = new Player("B");
        player2.setPlayerColor(PlayerColor.WHITE);
        Player player3 = new Player("C");
        player3.setPlayerColor(PlayerColor.GREY);
        Collection<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        ProfessorManager professorManager = new ProfessorManager(players);

        professorManager.checkProfessor(player1);
        assertTrue(Professor.getProfessor(Color.YELLOW).getPosition()==null); //Check that no action is taken
        assertTrue(Professor.getProfessor(Color.BLUE).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.GREEN).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.RED).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.PINK).getPosition()==null);

        player1.getSchool().getHall().addStudent(new Student(Color.YELLOW)); //adds a yellow student to player1's school
        professorManager.checkProfessor(player1);
        assertTrue(Professor.getProfessor(Color.YELLOW).getPosition()==player1.getSchool().getHall().getLine(Color.YELLOW)); //Checks that only yellow professor is on player1's school
        assertTrue(Professor.getProfessor(Color.BLUE).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.GREEN).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.RED).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.PINK).getPosition()==null);

        player2.getSchool().getHall().addStudent(new Student(Color.YELLOW)); //adds a yellow student to player2's school
        professorManager.checkProfessor(player2);
        assertTrue(Professor.getProfessor(Color.YELLOW).getPosition()==player1.getSchool().getHall().getLine(Color.YELLOW)); //Check that no action is taken
        assertTrue(Professor.getProfessor(Color.BLUE).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.GREEN).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.RED).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.PINK).getPosition()==null);

        player2.getSchool().getHall().addStudent(new Student(Color.YELLOW)); //adds a second yellow student to player2's school
        professorManager.checkProfessor(player2);
        assertTrue(Professor.getProfessor(Color.YELLOW).getPosition()==player2.getSchool().getHall().getLine(Color.YELLOW)); //Check that yellow professor is now on player2's school
        assertTrue(Professor.getProfessor(Color.BLUE).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.GREEN).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.RED).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.PINK).getPosition()==null);

        player3.getSchool().getHall().addStudent(new Student(Color.RED)); //adds a red student to player3's school
        professorManager.checkProfessor(player3);
        assertTrue(Professor.getProfessor(Color.YELLOW).getPosition()==player2.getSchool().getHall().getLine(Color.YELLOW)); //Check that yellow professor is still on player2's school
        assertTrue(Professor.getProfessor(Color.BLUE).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.GREEN).getPosition()==null);
        assertTrue(Professor.getProfessor(Color.RED).getPosition()==player3.getSchool().getHall().getLine(Color.RED)); // Check that red professor is now on player1's school
        assertTrue(Professor.getProfessor(Color.PINK).getPosition()==null);

    }


}
