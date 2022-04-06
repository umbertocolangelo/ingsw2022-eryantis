package it.polimi.ingsw.boardTest;

import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.pawns.Tower;
import it.polimi.ingsw.model.player.board.TowerTable;
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
            Island island = new Island();
            Tower tower= towerTable.getTowers().get(0);
            towerTable.removeTower(tower);
            tower.setPosition(null);
            assertTrue(!towerTable.getTowers().contains(tower));
            towerTable.addTower(tower);
            assertTrue(towerTable.getTowers().contains(tower));
            assertTrue(tower.getPosition()==towerTable);
            island.addTower(tower);
            assertTrue(island.getTowers().contains(tower));
            assertTrue(tower.getPosition()==island);
            towerTable.addTower(tower);
            assertTrue(towerTable.getTowers().contains(tower));
            assertTrue(tower.getPosition()==towerTable);
            assertTrue(!island.getTowers().contains(tower));




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

