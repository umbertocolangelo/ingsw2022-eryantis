package it.polimi.ingsw.calculationsTest.influenceTest;

import it.polimi.ingsw.model.calculations.influence.InfluenceManager;
import it.polimi.ingsw.model.calculations.professor.ProfessorManager;
import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.islands.IslandInterface;
import it.polimi.ingsw.model.objectTypes.FixedObjectStudent;
import it.polimi.ingsw.model.objectTypes.FixedObjectTower;
import it.polimi.ingsw.model.pawns.MotherNature;
import it.polimi.ingsw.model.pawns.Professor;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InfluenceManagerTest {

    /**
     * resets the position of the professors
     */

    @BeforeEach
    public void resetProfessorPosition() {
        for (Color color : Color.values()) {
            Professor.getProfessor(color).setPosition(null);
        }
    }


    /**
     * test of method calculateInfluence with 3 players
     */
    @Test
    public void calculateStandardInfluence3Test() {

        //creation of three players with motherNature positioned on an island
        MotherNature motherNature = new MotherNature();
        LinkedList<Player> playerList = new LinkedList<Player>();
        playerList.add(new Player("one"));
        playerList.add(new Player("two"));
        playerList.add(new Player("three"));
        playerList.get(0).setThreePlayers();
        playerList.get(1).setThreePlayers();
        playerList.get(2).setThreePlayers();
        playerList.get(0).setPlayerColor(PlayerColor.WHITE);
        playerList.get(1).setPlayerColor(PlayerColor.BLACK);
        playerList.get(2).setPlayerColor(PlayerColor.GREY);
        InfluenceManager influenceManager = new InfluenceManager(motherNature, playerList);
        FixedObjectStudent island = new Island();
        motherNature.setIsland((IslandInterface) island);
        ProfessorManager professorManager = new ProfessorManager(playerList);


        // one blue student on the island, no one has control of the island and professors

        island.addStudent(new Student(Color.BLUE));
        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().isEmpty() == true && ((Island) island).getInfluenceColor() == null);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 6);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 6);
        assertTrue(playerList.get(2).getSchool().getTowerTable().getTowers().size() == 6);

        // player one has one student so now has control over the blue professor and gets control of the island

        playerList.get(0).getSchool().getHall().addStudent(new Student(Color.BLUE));
        professorManager.checkProfessor(playerList.get(0));

        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().get(0).getColor() == playerList.get(0).getPlayerColor());
        assertTrue(((Island) island).getInfluenceColor() == PlayerColor.WHITE);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 5);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 6);
        assertTrue(playerList.get(2).getSchool().getTowerTable().getTowers().size() == 6);

        // player two has now two blue students (player one still has control of the island even if he lost the professor)

        playerList.get(1).getSchool().getHall().addStudent(new Student(Color.BLUE));
        playerList.get(1).getSchool().getHall().addStudent(new Student(Color.BLUE));
        professorManager.checkProfessor(playerList.get(1));

        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().get(0).getColor() == playerList.get(0).getPlayerColor());
        assertTrue(((Island) island).getInfluenceColor() == PlayerColor.WHITE);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 5);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 6);
        assertTrue(playerList.get(2).getSchool().getTowerTable().getTowers().size() == 6);

        // player three has now 3 blue students and a student is added on the island (player three gets control over the professor and the island)

        island.addStudent(new Student(Color.BLUE));
        playerList.get(2).getSchool().getHall().addStudent(new Student(Color.BLUE));
        playerList.get(2).getSchool().getHall().addStudent(new Student(Color.BLUE));
        playerList.get(2).getSchool().getHall().addStudent(new Student(Color.BLUE));
        professorManager.checkProfessor(playerList.get(2));

        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().get(0).getColor() == playerList.get(2).getPlayerColor());
        assertTrue(((Island) island).getInfluenceColor() == PlayerColor.GREY);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 6);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 6);
        assertTrue(playerList.get(2).getSchool().getTowerTable().getTowers().size() == 5);

        // player one has a yellow student and 4 yellow students are added on the island so player one takes control

        playerList.get(0).getSchool().getHall().addStudent(new Student(Color.YELLOW));
        island.addStudent(new Student(Color.YELLOW));
        island.addStudent(new Student(Color.YELLOW));
        island.addStudent(new Student(Color.YELLOW));
        island.addStudent(new Student(Color.YELLOW));

        professorManager.checkProfessor(playerList.get(0));
        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().get(0).getColor() == playerList.get(0).getPlayerColor());
        assertTrue(((Island) island).getInfluenceColor() == PlayerColor.WHITE);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 5);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 6);
        assertTrue(playerList.get(2).getSchool().getTowerTable().getTowers().size() == 6);

    }


    /**
     * test of method calculateInfluence with 2 players
     */
    @Test
    public void calculateStandardInfluence2Test() {

        //creation of two players with motherNature positioned on an island
        MotherNature motherNature = new MotherNature();
        LinkedList<Player> playerList = new LinkedList<Player>();
        playerList.add(new Player("one"));
        playerList.add(new Player("two"));
        playerList.get(0).setPlayerColor(PlayerColor.WHITE);
        playerList.get(1).setPlayerColor(PlayerColor.BLACK);
        InfluenceManager influenceManager = new InfluenceManager(motherNature, playerList);
        FixedObjectStudent island = new Island();
        motherNature.setIsland((IslandInterface) island);
        ProfessorManager professorManager = new ProfessorManager(playerList);


        assertTrue(playerList.get(0).getSchool().getHall().getLine(Color.BLUE).numOfStudents() == 0);
        assertTrue(playerList.get(1).getSchool().getHall().getLine(Color.BLUE).numOfStudents() == 0);

        // one blue student on the island, no one has control of the island and professors

        island.addStudent(new Student(Color.BLUE));
        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().isEmpty() == true && ((Island) island).getInfluenceColor() == null);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 8);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 8);

        // player one has one student so now has control over the blue professor and gets control of the island

        playerList.get(0).getSchool().getHall().addStudent(new Student(Color.BLUE));
        professorManager.checkProfessor(playerList.get(0));

        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().get(0).getColor() == playerList.get(0).getPlayerColor());
        assertTrue(((Island) island).getInfluenceColor() == PlayerColor.WHITE);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 7);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 8);

        // player two has now two blue students (player one still has control of the island even if he lost the professor)

        playerList.get(1).getSchool().getHall().addStudent(new Student(Color.BLUE));
        playerList.get(1).getSchool().getHall().addStudent(new Student(Color.BLUE));
        professorManager.checkProfessor(playerList.get(1));

        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().get(0).getColor() == playerList.get(0).getPlayerColor());
        assertTrue(((Island) island).getInfluenceColor() == PlayerColor.WHITE);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 7);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 8);

        // a student is added on the island (player two gets control over the island)

        island.addStudent(new Student(Color.BLUE));

        professorManager.checkProfessor(playerList.get(1));

        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().get(0).getColor() == playerList.get(1).getPlayerColor());
        assertTrue(((Island) island).getInfluenceColor() == PlayerColor.BLACK);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 8);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 7);

        // player one has a yellow student and 4 yellow students are added on the island so player one takes control

        playerList.get(0).getSchool().getHall().addStudent(new Student(Color.YELLOW));
        island.addStudent(new Student(Color.YELLOW));
        island.addStudent(new Student(Color.YELLOW));
        island.addStudent(new Student(Color.YELLOW));
        island.addStudent(new Student(Color.YELLOW));

        professorManager.checkProfessor(playerList.get(0));
        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().get(0).getColor() == playerList.get(0).getPlayerColor());
        assertTrue(((Island) island).getInfluenceColor() == PlayerColor.WHITE);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 7);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 8);

    }


    /**
     * test of method calculateInfluence with 3 players
     */
    @Test
    public void calculateColorInfluence3Test() {

        //creation of three players with motherNature positioned on an island
        MotherNature motherNature = new MotherNature();
        LinkedList<Player> playerList = new LinkedList<Player>();
        playerList.add(new Player("one"));
        playerList.add(new Player("two"));
        playerList.add(new Player("three"));
        playerList.get(0).setThreePlayers();
        playerList.get(1).setThreePlayers();
        playerList.get(2).setThreePlayers();
        playerList.get(0).setPlayerColor(PlayerColor.WHITE);
        playerList.get(1).setPlayerColor(PlayerColor.BLACK);
        playerList.get(2).setPlayerColor(PlayerColor.GREY);
        InfluenceManager influenceManager = new InfluenceManager(motherNature, playerList);
        FixedObjectStudent island = new Island();
        motherNature.setIsland((IslandInterface) island);
        ProfessorManager professorManager = new ProfessorManager(playerList);


        // one blue student on the island, no one has control of the island and professors

        island.addStudent(new Student(Color.BLUE));
        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().isEmpty() == true && ((Island) island).getInfluenceColor() == null);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 6);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 6);
        assertTrue(playerList.get(2).getSchool().getTowerTable().getTowers().size() == 6);

        // player one has one student so now has control over the blue professor and gets control of the island

        playerList.get(0).getSchool().getHall().addStudent(new Student(Color.BLUE));
        professorManager.checkProfessor(playerList.get(0));

        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().get(0).getColor() == playerList.get(0).getPlayerColor());
        assertTrue(((Island) island).getInfluenceColor() == PlayerColor.WHITE);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 5);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 6);
        assertTrue(playerList.get(2).getSchool().getTowerTable().getTowers().size() == 6);

        // player two has now two blue students (player one still has control of the island even if he lost the professor)

        playerList.get(1).getSchool().getHall().addStudent(new Student(Color.BLUE));
        playerList.get(1).getSchool().getHall().addStudent(new Student(Color.BLUE));
        professorManager.checkProfessor(playerList.get(1));

        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().get(0).getColor() == playerList.get(0).getPlayerColor());
        assertTrue(((Island) island).getInfluenceColor() == PlayerColor.WHITE);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 5);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 6);
        assertTrue(playerList.get(2).getSchool().getTowerTable().getTowers().size() == 6);

        // player three has now 3 blue students and a student is added on the island (player three gets control over the professor and the island)

        island.addStudent(new Student(Color.BLUE));
        playerList.get(2).getSchool().getHall().addStudent(new Student(Color.BLUE));
        playerList.get(2).getSchool().getHall().addStudent(new Student(Color.BLUE));
        playerList.get(2).getSchool().getHall().addStudent(new Student(Color.BLUE));
        professorManager.checkProfessor(playerList.get(2));

        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().get(0).getColor() == playerList.get(2).getPlayerColor());
        assertTrue(((Island) island).getInfluenceColor() == PlayerColor.GREY);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 6);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 6);
        assertTrue(playerList.get(2).getSchool().getTowerTable().getTowers().size() == 5);

        // two yellow student are placed on the island, player one has a yellow student and uses the color ExpertCard with blue color so player one takes control

        playerList.get(0).getSchool().getHall().addStudent(new Student(Color.YELLOW));
        island.addStudent(new Student(Color.YELLOW));
        island.addStudent(new Student(Color.YELLOW));

        professorManager.checkProfessor(playerList.get(0));

        influenceManager.setColorInfluence(Color.BLUE);
        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().get(0).getColor() == playerList.get(0).getPlayerColor());
        assertTrue(((Island) island).getInfluenceColor() == PlayerColor.WHITE);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 5);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 6);
        assertTrue(playerList.get(2).getSchool().getTowerTable().getTowers().size() == 6);

        // two blue students are added on the island and player one takes control of the island

        island.addStudent(new Student(Color.BLUE));
        island.addStudent(new Student(Color.BLUE));

        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().get(0).getColor() == playerList.get(2).getPlayerColor());
        assertTrue(((Island) island).getInfluenceColor() == PlayerColor.GREY);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 6);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 6);
        assertTrue(playerList.get(2).getSchool().getTowerTable().getTowers().size() == 5);


    }


    /**
     * test of method calculateInfluence with 2 players
     */
    @Test
    public void calculateColorInfluence2Test() {

        //creation of two players with motherNature positioned on an island
        MotherNature motherNature = new MotherNature();
        LinkedList<Player> playerList = new LinkedList<Player>();
        playerList.add(new Player("one"));
        playerList.add(new Player("two"));
        playerList.get(0).setPlayerColor(PlayerColor.WHITE);
        playerList.get(1).setPlayerColor(PlayerColor.BLACK);
        InfluenceManager influenceManager = new InfluenceManager(motherNature, playerList);
        FixedObjectStudent island = new Island();
        motherNature.setIsland((IslandInterface) island);
        ProfessorManager professorManager = new ProfessorManager(playerList);


        assertTrue(playerList.get(0).getSchool().getHall().getLine(Color.BLUE).numOfStudents() == 0);
        assertTrue(playerList.get(1).getSchool().getHall().getLine(Color.BLUE).numOfStudents() == 0);

        // one blue student on the island, no one has control of the island and professors

        island.addStudent(new Student(Color.BLUE));
        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().isEmpty() == true && ((Island) island).getInfluenceColor() == null);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 8);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 8);

        // player one has one student so now has control over the blue professor and gets control of the island

        playerList.get(0).getSchool().getHall().addStudent(new Student(Color.BLUE));
        professorManager.checkProfessor(playerList.get(0));

        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().get(0).getColor() == playerList.get(0).getPlayerColor());
        assertTrue(((Island) island).getInfluenceColor() == PlayerColor.WHITE);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 7);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 8);

        // player two has now two blue students (player one still has control of the island even if he lost the professor)

        playerList.get(1).getSchool().getHall().addStudent(new Student(Color.BLUE));
        playerList.get(1).getSchool().getHall().addStudent(new Student(Color.BLUE));
        professorManager.checkProfessor(playerList.get(1));

        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().get(0).getColor() == playerList.get(0).getPlayerColor());
        assertTrue(((Island) island).getInfluenceColor() == PlayerColor.WHITE);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 7);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 8);

        // a student is added on the island (player two gets control over the island)

        island.addStudent(new Student(Color.BLUE));

        professorManager.checkProfessor(playerList.get(1));

        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().get(0).getColor() == playerList.get(1).getPlayerColor());
        assertTrue(((Island) island).getInfluenceColor() == PlayerColor.BLACK);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 8);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 7);

        // player one has a yellow student and 2 yellow students are added on the island, player one uses color ExpertCard and takes control of the island

        playerList.get(0).getSchool().getHall().addStudent(new Student(Color.YELLOW));
        island.addStudent(new Student(Color.YELLOW));
        island.addStudent(new Student(Color.YELLOW));

        professorManager.checkProfessor(playerList.get(0));
        influenceManager.setColorInfluence(Color.BLUE);
        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().get(0).getColor() == playerList.get(0).getPlayerColor());
        assertTrue(((Island) island).getInfluenceColor() == PlayerColor.WHITE);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 7);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 8);

        // a blue student is added on the island and player one still has control

        island.addStudent(new Student(Color.BLUE));
        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().get(0).getColor() == playerList.get(0).getPlayerColor());
        assertTrue(((Island) island).getInfluenceColor() == PlayerColor.WHITE);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 7);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 8);


    }


    /**
     * test of method calculateInfluence with 3 players
     */
    @Test
    public void calculateTwoPointsInfluence3Test() {

        //creation of three players with motherNature positioned on an island
        MotherNature motherNature = new MotherNature();
        LinkedList<Player> playerList = new LinkedList<Player>();
        playerList.add(new Player("one"));
        playerList.add(new Player("two"));
        playerList.add(new Player("three"));
        playerList.get(0).setThreePlayers();
        playerList.get(1).setThreePlayers();
        playerList.get(2).setThreePlayers();
        playerList.get(0).setPlayerColor(PlayerColor.WHITE);
        playerList.get(1).setPlayerColor(PlayerColor.BLACK);
        playerList.get(2).setPlayerColor(PlayerColor.GREY);
        InfluenceManager influenceManager = new InfluenceManager(motherNature, playerList);
        FixedObjectStudent island = new Island();
        motherNature.setIsland((IslandInterface) island);
        ProfessorManager professorManager = new ProfessorManager(playerList);


        // one blue student on the island, no one has control of the island and professors

        island.addStudent(new Student(Color.BLUE));
        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().isEmpty() == true && ((Island) island).getInfluenceColor() == null);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 6);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 6);
        assertTrue(playerList.get(2).getSchool().getTowerTable().getTowers().size() == 6);

        // player one has one student so now has control over the blue professor and gets control of the island

        playerList.get(0).getSchool().getHall().addStudent(new Student(Color.BLUE));
        professorManager.checkProfessor(playerList.get(0));

        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().get(0).getColor() == playerList.get(0).getPlayerColor());
        assertTrue(((Island) island).getInfluenceColor() == PlayerColor.WHITE);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 5);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 6);
        assertTrue(playerList.get(2).getSchool().getTowerTable().getTowers().size() == 6);

        // player two has now two blue students and uses the two points ExpertCard and takes control of the island

        playerList.get(1).getSchool().getHall().addStudent(new Student(Color.BLUE));
        playerList.get(1).getSchool().getHall().addStudent(new Student(Color.BLUE));
        professorManager.checkProfessor(playerList.get(1));

        influenceManager.setTwoPointsInfluence(playerList.get(1));
        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().get(0).getColor() == playerList.get(1).getPlayerColor());
        assertTrue(((Island) island).getInfluenceColor() == PlayerColor.BLACK);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 6);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 5);
        assertTrue(playerList.get(2).getSchool().getTowerTable().getTowers().size() == 6);

        // player three has now 3 blue students and a student is added on the island (player three gets control over the professor and the island)

        island.addStudent(new Student(Color.BLUE));
        playerList.get(2).getSchool().getHall().addStudent(new Student(Color.BLUE));
        playerList.get(2).getSchool().getHall().addStudent(new Student(Color.BLUE));
        playerList.get(2).getSchool().getHall().addStudent(new Student(Color.BLUE));
        professorManager.checkProfessor(playerList.get(2));

        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().get(0).getColor() == playerList.get(2).getPlayerColor());
        assertTrue(((Island) island).getInfluenceColor() == PlayerColor.GREY);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 6);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 6);
        assertTrue(playerList.get(2).getSchool().getTowerTable().getTowers().size() == 5);

        // player one has a yellow student and 4 yellow students are added on the island so player one takes control

        playerList.get(0).getSchool().getHall().addStudent(new Student(Color.YELLOW));
        island.addStudent(new Student(Color.YELLOW));
        island.addStudent(new Student(Color.YELLOW));
        island.addStudent(new Student(Color.YELLOW));
        island.addStudent(new Student(Color.YELLOW));

        professorManager.checkProfessor(playerList.get(0));
        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().get(0).getColor() == playerList.get(0).getPlayerColor());
        assertTrue(((Island) island).getInfluenceColor() == PlayerColor.WHITE);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 5);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 6);
        assertTrue(playerList.get(2).getSchool().getTowerTable().getTowers().size() == 6);

    }


    /**
     * test of method calculateInfluence with 2 players
     */
    @Test
    public void calculateTwoPointsInfluence2Test() {

        //creation of two players with motherNature positioned on an island
        MotherNature motherNature = new MotherNature();
        LinkedList<Player> playerList = new LinkedList<Player>();
        playerList.add(new Player("one"));
        playerList.add(new Player("two"));
        playerList.get(0).setPlayerColor(PlayerColor.WHITE);
        playerList.get(1).setPlayerColor(PlayerColor.BLACK);
        InfluenceManager influenceManager = new InfluenceManager(motherNature, playerList);
        FixedObjectStudent island = new Island();
        motherNature.setIsland((IslandInterface) island);
        ProfessorManager professorManager = new ProfessorManager(playerList);


        assertTrue(playerList.get(0).getSchool().getHall().getLine(Color.BLUE).numOfStudents() == 0);
        assertTrue(playerList.get(1).getSchool().getHall().getLine(Color.BLUE).numOfStudents() == 0);

        // one blue student on the island, no one has control of the island and professors

        island.addStudent(new Student(Color.BLUE));
        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().isEmpty() == true && ((Island) island).getInfluenceColor() == null);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 8);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 8);

        // player one has one student so now has control over the blue professor and gets control of the island

        playerList.get(0).getSchool().getHall().addStudent(new Student(Color.BLUE));
        professorManager.checkProfessor(playerList.get(0));

        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().get(0).getColor() == playerList.get(0).getPlayerColor());
        assertTrue(((Island) island).getInfluenceColor() == PlayerColor.WHITE);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 7);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 8);

        // player two has now two blue students and uses the two points ExpertCard and takes control of the island

        playerList.get(1).getSchool().getHall().addStudent(new Student(Color.BLUE));
        playerList.get(1).getSchool().getHall().addStudent(new Student(Color.BLUE));
        professorManager.checkProfessor(playerList.get(1));

        influenceManager.setTwoPointsInfluence(playerList.get(1));
        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().get(0).getColor() == playerList.get(1).getPlayerColor());
        assertTrue(((Island) island).getInfluenceColor() == PlayerColor.BLACK);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 8);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 7);

        // player one has a yellow student and 4 yellow students are added on the island so player one takes control

        playerList.get(0).getSchool().getHall().addStudent(new Student(Color.YELLOW));
        island.addStudent(new Student(Color.YELLOW));
        island.addStudent(new Student(Color.YELLOW));
        island.addStudent(new Student(Color.YELLOW));
        island.addStudent(new Student(Color.YELLOW));

        professorManager.checkProfessor(playerList.get(0));
        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().get(0).getColor() == playerList.get(0).getPlayerColor());
        assertTrue(((Island) island).getInfluenceColor() == PlayerColor.WHITE);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 7);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 8);

    }

    /**
     * test of method calculateInfluence with 3 players
     */
    @Test
    public void calculateTowerInfluence3Test() {

        //creation of three players with motherNature positioned on an island
        MotherNature motherNature = new MotherNature();
        LinkedList<Player> playerList = new LinkedList<Player>();
        playerList.add(new Player("one"));
        playerList.add(new Player("two"));
        playerList.add(new Player("three"));
        playerList.get(0).setThreePlayers();
        playerList.get(1).setThreePlayers();
        playerList.get(2).setThreePlayers();
        playerList.get(0).setPlayerColor(PlayerColor.WHITE);
        playerList.get(1).setPlayerColor(PlayerColor.BLACK);
        playerList.get(2).setPlayerColor(PlayerColor.GREY);
        InfluenceManager influenceManager = new InfluenceManager(motherNature, playerList);
        FixedObjectStudent island = new Island();
        motherNature.setIsland((IslandInterface) island);
        ProfessorManager professorManager = new ProfessorManager(playerList);


        // one blue student on the island, no one has control of the island and professors

        island.addStudent(new Student(Color.BLUE));
        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().isEmpty() == true && ((Island) island).getInfluenceColor() == null);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 6);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 6);
        assertTrue(playerList.get(2).getSchool().getTowerTable().getTowers().size() == 6);

        // player one has one student so now has control over the blue professor and gets control of the island

        playerList.get(0).getSchool().getHall().addStudent(new Student(Color.BLUE));
        professorManager.checkProfessor(playerList.get(0));

        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().get(0).getColor() == playerList.get(0).getPlayerColor());
        assertTrue(((Island) island).getInfluenceColor() == PlayerColor.WHITE);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 5);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 6);
        assertTrue(playerList.get(2).getSchool().getTowerTable().getTowers().size() == 6);

        // player two has now two blue students and uses the tower ExpertCard and takes control of the island

        playerList.get(1).getSchool().getHall().addStudent(new Student(Color.BLUE));
        playerList.get(1).getSchool().getHall().addStudent(new Student(Color.BLUE));
        professorManager.checkProfessor(playerList.get(1));

        influenceManager.setTowerInfluence();
        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().get(0).getColor() == playerList.get(1).getPlayerColor());
        assertTrue(((Island) island).getInfluenceColor() == PlayerColor.BLACK);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 6);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 5);
        assertTrue(playerList.get(2).getSchool().getTowerTable().getTowers().size() == 6);

        // player three has now 3 blue students and a student is added on the island (player three gets control over the professor and the island)

        island.addStudent(new Student(Color.BLUE));
        playerList.get(2).getSchool().getHall().addStudent(new Student(Color.BLUE));
        playerList.get(2).getSchool().getHall().addStudent(new Student(Color.BLUE));
        playerList.get(2).getSchool().getHall().addStudent(new Student(Color.BLUE));
        professorManager.checkProfessor(playerList.get(2));

        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().get(0).getColor() == playerList.get(2).getPlayerColor());
        assertTrue(((Island) island).getInfluenceColor() == PlayerColor.GREY);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 6);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 6);
        assertTrue(playerList.get(2).getSchool().getTowerTable().getTowers().size() == 5);

        // player one has a yellow student and 4 yellow students are added on the island so player one takes control

        playerList.get(0).getSchool().getHall().addStudent(new Student(Color.YELLOW));
        island.addStudent(new Student(Color.YELLOW));
        island.addStudent(new Student(Color.YELLOW));
        island.addStudent(new Student(Color.YELLOW));
        island.addStudent(new Student(Color.YELLOW));

        professorManager.checkProfessor(playerList.get(0));
        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().get(0).getColor() == playerList.get(0).getPlayerColor());
        assertTrue(((Island) island).getInfluenceColor() == PlayerColor.WHITE);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 5);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 6);
        assertTrue(playerList.get(2).getSchool().getTowerTable().getTowers().size() == 6);

    }


    /**
     * test of method calculateInfluence with 2 players
     */
    @Test
    public void calculateTowerInfluence2Test() {

        //creation of two players with motherNature positioned on an island
        MotherNature motherNature = new MotherNature();
        LinkedList<Player> playerList = new LinkedList<Player>();
        playerList.add(new Player("one"));
        playerList.add(new Player("two"));
        playerList.get(0).setPlayerColor(PlayerColor.WHITE);
        playerList.get(1).setPlayerColor(PlayerColor.BLACK);
        InfluenceManager influenceManager = new InfluenceManager(motherNature, playerList);
        FixedObjectStudent island = new Island();
        motherNature.setIsland((IslandInterface) island);
        ProfessorManager professorManager = new ProfessorManager(playerList);


        assertTrue(playerList.get(0).getSchool().getHall().getLine(Color.BLUE).numOfStudents() == 0);
        assertTrue(playerList.get(1).getSchool().getHall().getLine(Color.BLUE).numOfStudents() == 0);

        // one blue student on the island, no one has control of the island and professors

        island.addStudent(new Student(Color.BLUE));
        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().isEmpty() == true && ((Island) island).getInfluenceColor() == null);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 8);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 8);

        // player one has one student so now has control over the blue professor and gets control of the island

        playerList.get(0).getSchool().getHall().addStudent(new Student(Color.BLUE));
        professorManager.checkProfessor(playerList.get(0));

        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().get(0).getColor() == playerList.get(0).getPlayerColor());
        assertTrue(((Island) island).getInfluenceColor() == PlayerColor.WHITE);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 7);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 8);

        // player two has now two blue students and uses the tower ExpertCard and takes control of the island

        playerList.get(1).getSchool().getHall().addStudent(new Student(Color.BLUE));
        playerList.get(1).getSchool().getHall().addStudent(new Student(Color.BLUE));
        professorManager.checkProfessor(playerList.get(1));

        influenceManager.setTowerInfluence();
        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().get(0).getColor() == playerList.get(1).getPlayerColor());
        assertTrue(((Island) island).getInfluenceColor() == PlayerColor.BLACK);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 8);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 7);

        // player one has a yellow student and 4 yellow students are added on the island so player one takes control

        playerList.get(0).getSchool().getHall().addStudent(new Student(Color.YELLOW));
        island.addStudent(new Student(Color.YELLOW));
        island.addStudent(new Student(Color.YELLOW));
        island.addStudent(new Student(Color.YELLOW));
        island.addStudent(new Student(Color.YELLOW));

        professorManager.checkProfessor(playerList.get(0));
        influenceManager.calculateInfluence();

        assertTrue(((FixedObjectTower) island).getTowers().get(0).getColor() == playerList.get(0).getPlayerColor());
        assertTrue(((Island) island).getInfluenceColor() == PlayerColor.WHITE);
        assertTrue(playerList.get(0).getSchool().getTowerTable().getTowers().size() == 7);
        assertTrue(playerList.get(1).getSchool().getTowerTable().getTowers().size() == 8);

    }
}
