package it.polimi.ingsw.modelTest.islandTest;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.pawns.Tower;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test of Island class
 */
public class IslandTest {

    /**
     * Test of addStudent method
      */
    @Test
    public void addStudentTest(){
        Island island= new Island();
        Island island1= new Island();
        Student student= new Student(Color.RED);
        island.addStudent(student);
        assertTrue(island.getStudents().contains(student)); //Checks that island contains student
        assertTrue(student.getPosition()==island); //Checks that student is on island
        island1.addStudent(student);
        assertTrue(!island.getStudents().contains(student)); //Checks that island no longer contains student
        assertTrue(student.getPosition()==island1); //Checks that student is on island1
        assertTrue(island1.getStudents().contains(student)); //Checks that island1 contains student
    }

    /**
     * Test of removeStudent method
     */
    @Test
    public void removeStudentTest(){
        Island island= new Island();
        Student student= new Student(Color.RED);
        island.addStudent(student);
        assertTrue(island.getStudents().contains(student));
        island.removeStudent(student);
        assertTrue(island.getStudents().isEmpty());

    }

    /**
     * Test of getStudent method
     */
    @Test
    public void getStudentTest(){
        Island island= new Island();
        Student student= new Student(Color.RED);
        island.addStudent(student);
        assertTrue(island.getStudents().contains(student) && island.getStudents().size()==1);
    }

    /**
     * Test of numOfStudent method
     */
    @Test
    public void numOfStudentsTest(){
        Island island= new Island();
        Student student= new Student(Color.RED);
        island.addStudent(student);
        assertTrue(island.getStudents().size()==1);
    }

    /**
     * Test of addTower method
     */
    @Test
    public void addTowerTest(){
        Island island= new Island();
        Tower tower= new Tower(PlayerColor.WHITE);
        island.addTower(tower);
        assertTrue(island.getTowers().contains(tower));
    }

    /**
     * Test of removeTower method
     */
    @Test
    public void removeTowerTest(){
        Island island= new Island();
        Tower tower= new Tower(PlayerColor.WHITE);
        island.addTower(tower);
        assertTrue(island.getTowers().contains(tower));
        island.removeTower(tower);
        assertTrue(island.getTowers()==null);
    }

    /**
     * Test of getTowers method
     */
    @Test
    public void getTowersTest(){
        Island island= new Island();
        Tower tower= new Tower(PlayerColor.WHITE);
        island.addTower(tower);
        assertTrue(island.getTowers().contains(tower) && island.getTowers().size()==1);
    }

    /**
     * Test of numOfStudentsByColor method
     */
    @Test
    public void numOfStudentsByColorTest(){
        Island island= new Island();
        Student student= new Student(Color.RED);
        island.addStudent(student);
        Student student1= new Student(Color.RED);
        island.addStudent(student1);
        Student student2= new Student(Color.RED);
        island.addStudent(student2);
        assertTrue(island.numOfStudents(Color.RED)==3);
    }

    /**
     * Test of setDeny method
     */
    @Test
    public void setDenyTest(){
        Island island=new Island();
        island.setDeny();
        assertTrue(island.getDeny()==1);

    }

    /**
     * Test of removeDeny method
     */
    @Test
    public void removeDenyTest(){
        Island island=new Island();
        island.setDeny();
        island.removeDeny();
        assertTrue(island.getDeny()==0);
    }

    /**
     * Test of numOfTowers method
     */
    @Test
    public void numOfTowersTest(){
        Island island=new Island();
        assertTrue(island.numOfTowers()==0);
        Tower tower=new Tower(PlayerColor.WHITE);
        island.addTower(tower);
        assertTrue(island.numOfTowers()==1);
    }

    /**
     * Test of influenceColor method
     */
    @Test
    public void influenceColorTest(){
        Island island = new Island();
        island.addTower(new Tower(PlayerColor.WHITE));
        assertTrue(island.getInfluenceColor()==PlayerColor.WHITE);
    }

}
