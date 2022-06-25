package it.polimi.ingsw.modelTest.studentsSuppliers;


import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.studentSuppliers.Bag;
import it.polimi.ingsw.model.studentSuppliers.Cloud;
import org.junit.jupiter.api.Test;
import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.board.Ingress;
import java.util.Random;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BagTest {

        @Test
    public  void newStudent() {
        Bag bag = new Bag(false);
        Student student=bag.newStudent();
        assertTrue(student instanceof Student);

    }

    @Test
    public void addStudentOnCloud(){
        Bag bag = new Bag(false);
        Cloud cloud=new Cloud();
        bag.addStudentsOnCloud(cloud);
        assertTrue(cloud.getStudents().size()>0);
    }
}
