package it.polimi.ingsw.modelTest.expertCardsTest;

import it.polimi.ingsw.model.calculations.influence.InfluenceManager;
import it.polimi.ingsw.model.calculations.professor.ProfessorManager;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.islands.IslandManager;
import it.polimi.ingsw.model.pawns.MotherNature;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.studentSuppliers.Bag;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test of CardManager class
 */
public class CardManagerTest {

    /**
     * Test of getMotherNature method
     */
    @Test
    public void getInfluenceManager() {
        LinkedList<Player> players = new LinkedList<>();
        players.add(new Player("vittorio"));
        Bag bag = new Bag(false);
        MotherNature motherNature = new MotherNature();
        InfluenceManager influenceManager = new InfluenceManager(motherNature, players);
        IslandManager islandManager = new IslandManager(motherNature);
        ProfessorManager professorManager = new ProfessorManager(players);
        CardManager cardManager = new CardManager(influenceManager, islandManager, professorManager, players, bag);
        assertTrue(cardManager.getInfluenceManager() == influenceManager); // check that influence manager is returned
    }

    /**
     * Test of setCurrentCard method
     */
    @Test
    public void setCurrentCardTest() {
        LinkedList<Player> players = new LinkedList<>();
        players.add(new Player("vittorio"));
        Bag bag = new Bag(false);
        MotherNature motherNature = new MotherNature();
        InfluenceManager influenceManager = new InfluenceManager(motherNature, players);
        IslandManager islandManager = new IslandManager(motherNature);
        ProfessorManager professorManager = new ProfessorManager(players);
        CardManager cardManager = new CardManager(influenceManager, islandManager, professorManager, players, bag);
        ExpertCard expertCard = cardManager.getDeck().get(0);
        cardManager.setCurrentCard(expertCard);
        assertTrue(cardManager.getCurrentCard() == expertCard); // check that the card is assigned

    }

    /**
     * Test of getProfessorManager method
     */
    @Test
    public void getProfessorManager() {
        LinkedList<Player> players = new LinkedList<>();
        players.add(new Player("vittorio"));
        Bag bag = new Bag(false);
        MotherNature motherNature = new MotherNature();
        InfluenceManager influenceManager = new InfluenceManager(motherNature, players);
        IslandManager islandManager = new IslandManager(motherNature);
        ProfessorManager professorManager = new ProfessorManager(players);
        CardManager cardManager = new CardManager(influenceManager, islandManager, professorManager, players, bag);
        assertTrue(cardManager.getProfessorManager()==professorManager); // check that ProfessorManager is returned
    }

    /**
     * Test getCurrentCard method
     */
    @Test
    public void getCurrentCardTest() {
        LinkedList<Player> players = new LinkedList<>();
        players.add(new Player("vittorio"));
        Bag bag = new Bag(false);
        MotherNature motherNature = new MotherNature();
        InfluenceManager influenceManager = new InfluenceManager(motherNature, players);
        IslandManager islandManager = new IslandManager(motherNature);
        ProfessorManager professorManager = new ProfessorManager(players);
        CardManager cardManager = new CardManager(influenceManager, islandManager, professorManager, players, bag);
        ExpertCard expertCard = cardManager.getDeck().get(0);
        cardManager.setCurrentCard(expertCard);
        assertTrue(cardManager.getCurrentCard() == expertCard); // check that the current car is returned

    }

    /**
     * Test of getPlayerList method
     */
    @Test
    public void getPlayerListTest() {
        LinkedList<Player> players = new LinkedList<>();
        players.add(new Player("vittorio"));
        Bag bag = new Bag(false);
        MotherNature motherNature = new MotherNature();
        InfluenceManager influenceManager = new InfluenceManager(motherNature, players);
        IslandManager islandManager = new IslandManager(motherNature);
        ProfessorManager professorManager = new ProfessorManager(players);
        CardManager cardManager = new CardManager(influenceManager, islandManager, professorManager, players, bag);
        assertTrue(cardManager.getPlayerList().get(0).getName() == "vittorio"); // check that the player list is returned
    }

    /**
     * Test the getBag method
     */
    @Test
    public void getBagTest() {
        LinkedList<Player> players = new LinkedList<>();
        players.add(new Player("vittorio"));
        Bag bag = new Bag(false);
        MotherNature motherNature = new MotherNature();
        InfluenceManager influenceManager = new InfluenceManager(motherNature, players);
        IslandManager islandManager = new IslandManager(motherNature);
        ProfessorManager professorManager = new ProfessorManager(players);
        CardManager cardManager = new CardManager(influenceManager, islandManager, professorManager, players, bag);
        assertTrue(cardManager.getBag() == bag); // check that the bag is returned
    }


    /**
     * Test getThreeExpertCards method
     */
    @Test
    public void getThreeExpertCardTest() {
        LinkedList<Player> players = new LinkedList<>();
        players.add(new Player("vittorio"));
        players.get(0).setPlayerColor(PlayerColor.WHITE);
        Bag bag = new Bag(false);
        MotherNature motherNature = new MotherNature();
        InfluenceManager influenceManager = new InfluenceManager(motherNature, players);
        IslandManager islandManager = new IslandManager(motherNature);
        ProfessorManager professorManager = new ProfessorManager(players);
        CardManager cardManager = new CardManager(influenceManager, islandManager, professorManager, players, bag);
        assertTrue(cardManager.getDeck().size()==3); // check that three cards are returned
        assertTrue(cardManager.getDeck().get(0).getId()!=cardManager.getDeck().get(1).getId()); // check that the cards are different from each other
        assertTrue(cardManager.getDeck().get(1).getId()!=cardManager.getDeck().get(2).getId());
        assertTrue(cardManager.getDeck().get(0).getId()!=cardManager.getDeck().get(2).getId());

    }
}

