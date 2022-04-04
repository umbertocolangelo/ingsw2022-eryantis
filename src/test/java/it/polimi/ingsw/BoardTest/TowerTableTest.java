package it.polimi.ingsw.BoardTest;

import it.polimi.ingsw.Model.Enumerations.Color;
import it.polimi.ingsw.Model.Enumerations.PlayerColor;
import it.polimi.ingsw.Model.Pawns.Student;
import it.polimi.ingsw.Model.Pawns.Tower;
import it.polimi.ingsw.Model.Player.Board.Ingress;
import it.polimi.ingsw.Model.Player.Board.TowerTable;
import it.polimi.ingsw.Model.Player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TowerTableTest {


        /**
         * Test on getTower function.
         */
        @Test
        public void getTowerTest() {
            TowerTable towerTable = new TowerTable(PlayerColor.WHITE);

            assertEquals(towerTable.getTowers().size(), 6);

        }

        /**
         * Test on addTower function.
         */
        @Test
        public void addTowerTest() {
            TowerTable towerTable = new TowerTable(PlayerColor.WHITE);
            Tower tower= towerTable.getTowers().get((2));
            towerTable.removeTower(tower);
            assertTrue(!towerTable.getTowers().contains(tower));
            towerTable.addTower(tower);
            assertTrue(towerTable.getTowers().contains(tower));



        }

        /**
         * Test on removeTower function.
         */
        @Test
        public void removeTowerTest() {
            TowerTable towerTable = new TowerTable(PlayerColor.WHITE);
            Tower tower= towerTable.getTowers().get((2));
            towerTable.removeTower(tower);
            towerTable.addTower(tower);
            assertTrue(towerTable.getTowers().contains(tower));
            towerTable.removeTower(tower);
            assertTrue(!towerTable.getTowers().contains(tower));

        }

        /**
         * Test on numOfTowerTest
         */

        @Test
        public void numOfTowerTest() {
            TowerTable towerTable = new TowerTable(PlayerColor.WHITE);

            assertEquals(towerTable.getTowers().size(), 6);
            Tower tower= towerTable.getTowers().get((2));
            towerTable.removeTower(tower);

            assertEquals(towerTable.getTowers().size(), 5);
        }
    }

