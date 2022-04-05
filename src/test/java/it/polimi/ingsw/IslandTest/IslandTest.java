package it.polimi.ingsw.IslandTest;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.pawns.Tower;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IslandTest {

    /**T
     * Testing addStudent
      */
    @Test
    public void addStudentTest(){
        Island island= new Island();
        Student student= new Student(Color.RED);
        island.addStudent(student);
        assertTrue(island.getStudents().contains(student));

    }

    /**T
     * Testing removeStudent
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

    /**T
     * Testing getStudent
     */

    @Test
    public void getStudentTest(){
        Island island= new Island();
        Student student= new Student(Color.RED);
        island.addStudent(student);
        assertTrue(island.getStudents().contains(student) && island.getStudents().size()==1);
    }

    /**T
     * Testing numOfStudent
     */

    @Test
    public void numOfStudentsTest(){
        Island island= new Island();
        Student student= new Student(Color.RED);
        island.addStudent(student);
        assertTrue(island.getStudents().size()==1);
    }

    @Test
    public void addTowerTest(){
        Island island= new Island();
        Tower tower= new Tower(PlayerColor.WHITE);
        island.addTower(tower);
        assertTrue(island.getTowers().contains(tower));
    }

    @Test
    public void removeTowerTest(){
        Island island= new Island();
        Tower tower= new Tower(PlayerColor.WHITE);
        island.addTower(tower);
        assertTrue(island.getTowers().contains(tower));
        island.removeTower(tower);
        assertTrue(island.getTowers().isEmpty());
    }

    @Test
    public void getTowersTest(){
        Island island= new Island();
        Tower tower= new Tower(PlayerColor.WHITE);
        island.addTower(tower);
        assertTrue(island.getTowers().contains(tower) && island.getTowers().size()==1);
    }

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

    @Test
    public void setDenyTest(){
        Island island=new Island();
        island.setDeny();
        assertTrue(island.getDeny()==true);

    }

    @Test
    public void removeDenyTest(){
        Island island=new Island();
        island.setDeny();
        island.removeDeny();
        assertTrue(island.getDeny()==false);
    }

    @Test
    public void numOfTowersTest(){
        Island island=new Island();
        assertTrue(island.numOfTowers()==0);
        Tower tower=new Tower(PlayerColor.WHITE);
        island.addTower(tower);
        assertTrue(island.numOfTowers()==1);
    }

    @Test
    public void influenceColorTest(){
        Island island = new Island();
        island.addTower(new Tower(PlayerColor.WHITE));
        assertTrue(island.getInfluenceColor()==PlayerColor.WHITE);
    }

}
