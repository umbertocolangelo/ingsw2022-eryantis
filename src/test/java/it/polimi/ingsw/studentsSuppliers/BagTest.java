package it.polimi.ingsw.studentsSuppliers;

import it.polimi.ingsw.Model.Islands.Island;
import it.polimi.ingsw.Model.Pawns.Student;
import it.polimi.ingsw.Model.StudentSuppliers.Bag;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BagTest {

        @Test
    public  void newStudent() {
        Bag bag = new Bag();
        Student student=bag.newStudent();
        assertTrue(student instanceof Student);

    }

    @Test
    public void addStudentOnIsland(){
        Bag bag = new Bag();
        Island island=new Island();
        bag.addStudentsOnIsland(island);
        assertTrue(island.getStudents().size()>0);
    }


    @Test
    public void addStudentOnCloud(){
        Bag bag = new Bag();
        Cloud cloud=new Island();
        bag.addStudentsOnIsland(island);
        assertTrue(island.getStudents().size()>0);
    }



}
