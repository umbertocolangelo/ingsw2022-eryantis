package it.polimi.ingsw.modelTest.islandTest;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.islands.IslandGroup;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.pawns.Tower;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test of IslandGroup class
 */
public class IslandGroupTest {

    /**
     * Test of addIsland method
     */
    @Test
    public void addIslandInterface() {
        Island island = new Island();
        IslandGroup islandGroup = new IslandGroup();
        IslandGroup islandGroup1 = new IslandGroup();
        Island island1 = new Island();
        Island island2 = new Island();
        islandGroup1.addIslandInterface(island1);
        islandGroup1.addIslandInterface(island2);
        islandGroup.addIslandInterface(island);
        islandGroup.addIslandInterface(islandGroup1);
        assertTrue(islandGroup.getIslandGroupElements().contains(island)); //check that islands are added to the group
        assertTrue(islandGroup.getIslandGroupElements().contains(island1));
        assertTrue(islandGroup.getIslandGroupElements().contains(island2));
        assertTrue(islandGroup.getIslandGroupElements().get(2)==island2);
    }

    /**
     * Test of NumOfStudents method
     */
    @Test
    public void numOfStudents() {
        Student student1 = new Student(Color.YELLOW);
        Student student2 = new Student(Color.YELLOW);
        Student student3 = new Student(Color.RED);
        Island island1 = new Island();
        Island island2 = new Island();
        IslandGroup islandGroup = new IslandGroup();
        island1.addStudent(student1);
        island2.addStudent(student2);
        island2.addStudent(student3);
        islandGroup.addIslandInterface(island1);
        islandGroup.addIslandInterface(island2);
        assertTrue(islandGroup.numOfStudents(Color.YELLOW) == 2); // check that students from single islands are returned by the group
        assertTrue(islandGroup.numOfStudents(Color.RED) == 1);
    }

    /**
     * Test of setDeny method
     */
    @Test
    public void setDeny() {
        IslandGroup islandGroup = new IslandGroup();
        islandGroup.addIslandInterface(new Island());
        islandGroup.setDeny();
        assertTrue(islandGroup.getDeny() == 1); // check that deny token is added
    }

    /**
     * Test of removeDeny method
     */
    @Test
    public void removeDeny() {
        IslandGroup islandGroup = new IslandGroup();
        islandGroup.addIslandInterface(new Island());
        islandGroup.removeDeny();
        assertTrue(islandGroup.getDeny() == 0); // check that minimum number of deny tokens is 0
        islandGroup.setDeny();
        assertTrue(islandGroup.getDeny() == 1); // check that deny token is added
        islandGroup.removeDeny();
        assertTrue(islandGroup.getDeny() == 0); // check that deny token is removed
    }

    /**
     * Test of numOfTowers method
     */
    @Test
    public void numOfTowers() {
        Island island1 = new Island();
        Island island2 = new Island();
        Island island3 = new Island();
        IslandGroup islandGroup = new IslandGroup();
        islandGroup.addIslandInterface(island1);
        islandGroup.addIslandInterface(island3);
        islandGroup.addIslandInterface(island2);
        assertTrue(islandGroup.numOfTowers() == 3); // check the number of towers
    }

    /**
     * Test of getInfluenceColor method
     */
    @Test
    public void getInfluenceColor() {
        Tower tower1 = new Tower(PlayerColor.WHITE);
        Tower tower2 = new Tower(PlayerColor.WHITE);
        Island island1 = new Island();
        Island island2 = new Island();
        IslandGroup islandGroup = new IslandGroup();
        island1.addTower(tower1);
        island2.addTower(tower2);
        islandGroup.addIslandInterface(island1);
        islandGroup.addIslandInterface(island2);
        assertTrue(islandGroup.getInfluenceColor().equals(PlayerColor.WHITE)); // check that right player color is returned
    }

    /**
     * Test of getTower method
     */
    @Test
    public void getTowerTest() {
        Tower tower1 = new Tower(PlayerColor.WHITE);
        Tower tower2 = new Tower(PlayerColor.WHITE);
        Island island1 = new Island();
        Island island2 = new Island();
        IslandGroup islandGroup = new IslandGroup();
        island1.addTower(tower1);
        island2.addTower(tower2);
        islandGroup.addIslandInterface(island1);
        islandGroup.addIslandInterface(island2);
        assertTrue(islandGroup.getTowers().contains(tower1)); // check that the list returned contains the towers
        assertTrue(islandGroup.getTowers().contains(tower2));
    }

    /**
     * Test of addTower method
     */
    @Test
    public void addTowerTest() {
        Tower tower1 = new Tower(PlayerColor.WHITE);
        Tower tower2 = new Tower(PlayerColor.WHITE);
        Island island1 = new Island();
        Island island2 = new Island();
        IslandGroup islandGroup = new IslandGroup();
        islandGroup.addIslandInterface(island1);
        islandGroup.addIslandInterface(island2);
        islandGroup.addTower(tower1);
        islandGroup.addTower(tower2);
        assertTrue(island1.getTowers().contains(tower1)); // check that the list returned contains the towers
        assertTrue(island2.getTowers().contains(tower2));
    }

    /**
     * Testing removeTower
     */
    @Test
    public void removeTowerTest() {
        Tower tower1 = new Tower(PlayerColor.WHITE);
        Tower tower2 = new Tower(PlayerColor.WHITE);
        Island island1 = new Island();
        Island island2 = new Island();
        IslandGroup islandGroup = new IslandGroup();
        island1.addTower(tower1);
        island2.addTower(tower2);
        islandGroup.addIslandInterface(island1);
        islandGroup.addIslandInterface(island2);
        islandGroup.removeTower(tower1);
        assertTrue(island1.getTowers()==null); // check that towers are effectively removed
    }

}