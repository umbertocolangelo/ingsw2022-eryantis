package it.polimi.ingsw.modelTest.playerTest.boardTest;

import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.player.board.Ingress;
import it.polimi.ingsw.model.player.board.School;
import it.polimi.ingsw.model.player.board.TowerTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test of School class
 */
public class SchoolTest {

    /**
     * Test of getIngress method
     */
    @Test
    public void getIngressTest(){

        School school= new School(PlayerColor.WHITE,false);
        assertTrue(school.getIngress() instanceof Ingress); // check that ingress is created and returned


    }

    /**
     * Test of GetTowerTable method
     */
    @Test
    public void getTowerTablesTest(){
        School school= new School(PlayerColor.WHITE, false);
        assertTrue(school.getTowerTable() instanceof TowerTable); // check that tower table is created and returned
    }

}
