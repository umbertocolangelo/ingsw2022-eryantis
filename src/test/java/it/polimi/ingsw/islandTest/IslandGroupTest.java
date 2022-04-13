package it.polimi.ingsw.islandTest;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.islands.IslandGroup;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.pawns.Tower;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IslandGroupTest {

    /**T
     * Testing addIsland
     */
    @Test
    public void addIsland() {
        Island island = new Island();
        IslandGroup islandGroup = new IslandGroup();
        islandGroup.addIsland(island);
        assertTrue(islandGroup.getIslandGroupElements().contains(island));
    }

    /**T
     * Testing addIslandGroup
     */
    @Test
    public void addIslandGroup() {
        IslandGroup islandGroup = new IslandGroup();
        IslandGroup newIslandGroup = new IslandGroup();
        Island island1 = new Island();
        Island island2 = new Island();
        Island island3 = new Island();
        islandGroup.addIsland(island2);
        newIslandGroup.addIsland(island1);
        newIslandGroup.addIsland(island3);
        islandGroup.addIslandGroup(newIslandGroup);
        for (int i=0; i< newIslandGroup.getSize(); i++) {
            assertTrue(islandGroup.getIslandGroupElements().contains(newIslandGroup.getIslandGroupElements().get(i)));
        }
    }

    /**T
     * Testing numOfStudents
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
        islandGroup.addIsland(island1);
        islandGroup.addIsland(island2);
        assertTrue(islandGroup.numOfStudents(Color.YELLOW)==2);
        assertTrue(islandGroup.numOfStudents(Color.RED)==1);
    }

    /**T
     * Testing setDeny
     */
    @Test
    public void setDeny() {
        IslandGroup islandGroup = new IslandGroup();
        islandGroup.setDeny();
        assertTrue(islandGroup.getDeny()==true);
    }

    /**T
     * Testing removeDeny
     */
    @Test
    public void removeDeny() {
        IslandGroup islandGroup = new IslandGroup();
        islandGroup.removeDeny();
        assertTrue(islandGroup.getDeny()==false);
    }

    /**T
     * Testing numOfTowers
     */
    @Test
    public void numOfTowers() {
        Island island1 = new Island();
        Island island2 = new Island();
        Island island3 = new Island();
        IslandGroup islandGroup = new IslandGroup();
        islandGroup.addIsland(island1);
        islandGroup.addIsland(island3);
        islandGroup.addIsland(island2);
        assertTrue(islandGroup.numOfTowers()==3);
    }

    /**T
     * Testing numOfTowers
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
        islandGroup.addIsland(island1);
        islandGroup.addIsland(island2);
        assertTrue(islandGroup.getInfluenceColor().equals(PlayerColor.WHITE));
        assertTrue(!islandGroup.getInfluenceColor().equals(PlayerColor.GREY));
    }

    //the other methods in IslandGroup are correct because I already used them in other tests
}