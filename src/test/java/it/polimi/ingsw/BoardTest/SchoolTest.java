package it.polimi.ingsw.BoardTest;

import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.player.board.School;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


/*
We were wondering how to make a test with this class without change his constructor, we are not able to access to the private variables.
 */
public class SchoolTest {
    @Test
    public void getIngressTest(){

        School school= new School(PlayerColor.WHITE);
        //assertTrue(school.getIngress());


    }

    @Test
    public void getTowerTablesTest(){
        School school= new School(PlayerColor.WHITE);
       // assertTrue(school.getTowerTable());
    }


}
