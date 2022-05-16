
package it.polimi.ingsw.modelTest.islandTest;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.calculations.influence.InfluenceManager;
import it.polimi.ingsw.model.calculations.professor.ProfessorManager;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.islands.IslandGroup;
import it.polimi.ingsw.model.islands.IslandInterface;
import it.polimi.ingsw.model.islands.IslandManager;
import it.polimi.ingsw.model.pawns.MotherNature;
import it.polimi.ingsw.model.pawns.Tower;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.studentSuppliers.Bag;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IslandManagerTest {

    /**T
     * Testing checkGroup
     */
    @Test
    public void checkGroup() {
        LinkedList<Player> players = new LinkedList<>();
        players.add(new Player("vittorio"));
        MotherNature motherNature = new MotherNature();
        IslandManager islandManager = new IslandManager(motherNature);
        Game game = new Game();
        Tower tower1 = new Tower(PlayerColor.WHITE);
        Tower tower2 = new Tower(PlayerColor.WHITE);
        Tower tower3 = new Tower(PlayerColor.BLACK);
        game.getIslandManager().getIslands().get(0).addTower(tower1);
        game.getIslandManager().getIslands().get(1).addTower(tower2);
        game.getIslandManager().getIslands().get(2).addTower(new Tower(PlayerColor.WHITE));
        game.getIslandManager().getIslands().get(3).addTower(new Tower(PlayerColor.WHITE));
        game.getIslandManager().getIslands().get(4).addTower(tower3);
        game.getIslandManager().getIslands().get(11).addTower(new Tower(PlayerColor.BLACK));
        System.out.println("Step 0");
        System.out.println(game.getIslandManager().getIslands().size());
        for (IslandInterface islandInterface: game.getIslandManager().getIslands()) {System.out.println(islandInterface);}
        System.out.println();
        System.out.println(game.getIslandManager().getIslands().get(0).getInfluenceColor());
        System.out.println(game.getIslandManager().getIslands().get(1).getInfluenceColor());
        System.out.println(game.getIslandManager().getIslands().get(4).getInfluenceColor());

        game.getIslandManager().checkGroup(game.getIslandManager().getIslands().get(1));

        System.out.println();
        System.out.println("Step 1");
        System.out.println(game.getIslandManager().getIslands().size());
        for (IslandInterface islandInterface: game.getIslandManager().getIslands()) {System.out.println(islandInterface);}
        System.out.println(game.getIslandManager().getIslands().get(0).getInfluenceColor());
        System.out.println(game.getIslandManager().getIslands().get(1).getInfluenceColor());
        System.out.println(game.getIslandManager().getIslands().get(3).getInfluenceColor());

        game.getIslandManager().checkGroup(islandManager.getIslands().get(1));

        System.out.println();
        System.out.println("Step 2");
        System.out.println(game.getIslandManager().getIslands().size());
        for (IslandInterface islandInterface: game.getIslandManager().getIslands()) {System.out.println(islandInterface);}

    }

    /**T
     * Testing getNumOfGroups
     */
    @Test
    public void getNumOfGroups() {
        MotherNature motherNature = new MotherNature();
        IslandManager islandManager = new IslandManager(motherNature);
        islandManager.getNumOfGroups();
        assertTrue(islandManager.getNumOfGroups()==0);
        islandManager.getIslands().get(5).setIsGrouped();
        islandManager.getNumOfGroups();
        assertTrue(islandManager.getNumOfGroups()==0);
        islandManager.getIslands().remove(11);
        assertTrue(islandManager.getNumOfGroups()==1);
    }

    /**T
     * Testing setNewGroup
     */
    @Test
    public void setNewGroup() {
        MotherNature motherNature = new MotherNature();
        IslandManager islandManager = new IslandManager(motherNature);
        IslandGroup islandGroup = new IslandGroup();
        islandManager.setNewGroupTest(islandGroup, islandManager.getIslands().get(0));
        assertTrue(islandGroup.getIslandGroupElements().contains(islandManager.getIslands().get(0)));
        assertTrue(islandGroup.getIslandGroupElements().contains(islandManager.getIslands().get(1)));
        assertTrue(!islandGroup.getIslandGroupElements().contains(islandManager.getIslands().get(2)));
        IslandGroup islandGroup1 = new IslandGroup();
        IslandInterface temp0 = islandManager.getIslands().get(0);
        islandManager.getIslands().remove(0);
        IslandInterface temp1 = islandManager.getIslands().get(0);
        islandManager.getIslands().remove(0);
        islandManager.getIslands().add(0, islandGroup);
        islandGroup1.addIslandInterface(islandManager.getIslands().get(1));
        islandGroup1.addIslandInterface(islandManager.getIslands().get(2));
        /*
        System.out.println(islandManager.getIslands().size());
        for (int i=0; i<islandManager.getIslands().size(); i++) {
            System.out.println(islandManager.getIslands().get(i));
        }
         */
        IslandInterface temp2 = islandManager.getIslands().get(1);
        islandManager.getIslands().remove(1);
        IslandInterface temp3 = islandManager.getIslands().get(1);
        islandManager.getIslands().remove(1);
        islandManager.getIslands().add(1, islandGroup1);
        /*
        System.out.println();
        System.out.println(islandManager.getIslands().size());
        for (int i=0; i<islandManager.getIslands().size(); i++) {
            System.out.println(islandManager.getIslands().get(i));
        }
         */
        assertTrue(islandGroup1.getIslandGroupElements().get(0).equals(temp2));
        islandManager.setNewGroupTest(islandGroup, islandGroup1);
        assertTrue(islandGroup.getIslandGroupElements().get(0).equals(temp0));
        assertTrue(islandGroup.getIslandGroupElements().get(2).equals(temp2));
        /*
        System.out.println("IslandGroup");
        for (Island island: islandGroup.getIslandGroupElements()) {
            System.out.println(island);
        }
        System.out.println("IslandGroup1");
        for (Island island: islandGroup1.getIslandGroupElements()) {
            System.out.println(island);
        }
         */
    }

    /**T
     * Testing rightIsland
     */
    @Test
    public void rightIsland() {
        MotherNature motherNature = new MotherNature();
        IslandManager islandManager = new IslandManager(motherNature);
        assertTrue(islandManager.rightIslandTest(islandManager.getIslands().get(0)).equals(islandManager.getIslands().get(1)));
        assertTrue(islandManager.rightIslandTest(islandManager.getIslands().get(11)).equals(islandManager.getIslands().get(0)));
        islandManager.getIslands().remove(11);
        islandManager.getIslands().add(11, new IslandGroup());
        assertTrue(islandManager.rightIslandTest(islandManager.getIslands().get(10)).equals(islandManager.getIslands().get(11)));
        System.out.println(islandManager.rightIslandTest(islandManager.getIslands().get(10)));
    }

    /**T
     * Testing leftIsland
     */
    @Test
    public void leftIsland() {
        MotherNature motherNature = new MotherNature();
        IslandManager islandManager = new IslandManager(motherNature);
        assertTrue(islandManager.leftIslandTest(islandManager.getIslands().get(0)).equals(islandManager.getIslands().get(11)));
        assertTrue(islandManager.leftIslandTest(islandManager.getIslands().get(5)).equals(islandManager.getIslands().get(4)));
        islandManager.getIslands().remove(11);
        assertTrue(islandManager.leftIslandTest(islandManager.getIslands().get(0)).equals(islandManager.getIslands().get(10)));
    }

    /**T
     * Testing islandsUpdate
     */
    @Test
    public void islandUpdate() {
        MotherNature motherNature = new MotherNature();
        IslandManager islandManager = new IslandManager(motherNature);
        System.out.println(islandManager.getIslands().size());
        for (int i=0; i<islandManager.getIslands().size(); i++) {
            System.out.println(islandManager.getIslands().get(i));
        }

        islandManager.islandsUpdateTest(0);
        System.out.println();
        System.out.println(islandManager.getIslands().size());
        for (int i=0; i<islandManager.getIslands().size(); i++) {
            System.out.println(islandManager.getIslands().get(i));
        }
        assertTrue(islandManager.getIslands().size()==11);

        islandManager.islandsUpdateTest(10);
        System.out.println();
        System.out.println(islandManager.getIslands().size());
        for (int i=0; i<islandManager.getIslands().size(); i++) {
            System.out.println(islandManager.getIslands().get(i));
        }
        assertTrue(islandManager.getIslands().size()==10);

        islandManager.islandsUpdateTest(0);
        System.out.println();
        System.out.println(islandManager.getIslands().size());
        for (int i=0; i<islandManager.getIslands().size(); i++) {
            System.out.println(islandManager.getIslands().get(i));
        }
        assertTrue(islandManager.getIslands().size()==9);

        islandManager.islandsUpdateTest(0);
        System.out.println();
        System.out.println(islandManager.getIslands().size());
        for (int i=0; i<islandManager.getIslands().size(); i++) {
            System.out.println(islandManager.getIslands().get(i));
        }
        assertTrue(islandManager.getIslands().size()==8);

    }

    /**
     * Testing nextIsland
     */
    @Test
    public void nextIslandTest() {

        MotherNature motherNature = new MotherNature();
        IslandManager islandManager = new IslandManager(motherNature);
        motherNature.setIsland(islandManager.getIslands().get(0));
        motherNature.setIsland(islandManager.nextIsland(5));
        assertTrue(motherNature.getIsland()==islandManager.getIslands().get(5));
        motherNature.setIsland(islandManager.getIslands().get(10));
        motherNature.setIsland(islandManager.nextIsland(4));
        assertTrue(motherNature.getIsland()==islandManager.getIslands().get(2));

    }

}

