package it.polimi.ingsw.expertCardsTest;

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

public class CardManagerTest {

    /**
     * Test the getMotherNature method
     */
    @Test
    public void getInfluenceManager() {
        LinkedList<Player> players = new LinkedList<>();
        players.add(new Player("vittorio"));
        Bag bag = new Bag();
        MotherNature motherNature = new MotherNature();
        InfluenceManager influenceManager = new InfluenceManager(motherNature, players);
        IslandManager islandManager = new IslandManager(motherNature);
        ProfessorManager professorManager = new ProfessorManager(players);
        CardManager cardManager = new CardManager(influenceManager, islandManager, professorManager, players, bag);
        assertTrue(cardManager.getInfluenceManager() == influenceManager);
    }

    /**
     * Test setCurrentCard method
     */
    @Test
    public void setCurrentCardTest() {
        LinkedList<Player> players = new LinkedList<>();
        players.add(new Player("vittorio"));
        Bag bag = new Bag();
        MotherNature motherNature = new MotherNature();
        InfluenceManager influenceManager = new InfluenceManager(motherNature, players);
        IslandManager islandManager = new IslandManager(motherNature);
        ProfessorManager professorManager = new ProfessorManager(players);
        CardManager cardManager = new CardManager(influenceManager, islandManager, professorManager, players, bag);
        ExpertCard expertCard = cardManager.getThreeExpertCards().get(0);
        cardManager.setCurrentCard(expertCard);
        assertTrue(cardManager.getCurrentCard() == expertCard);

    }

    /**
     * Test getProfessorManager
     */
    @Test
    public void getProfessorManager() {
        LinkedList<Player> players = new LinkedList<>();
        players.add(new Player("vittorio"));
        Bag bag = new Bag();
        MotherNature motherNature = new MotherNature();
        InfluenceManager influenceManager = new InfluenceManager(motherNature, players);
        IslandManager islandManager = new IslandManager(motherNature);
        ProfessorManager professorManager = new ProfessorManager(players);
        CardManager cardManager = new CardManager(influenceManager, islandManager, professorManager, players, bag);
        assertTrue(cardManager.getProfessorManager()==professorManager);
    }

    /**
     * Test getCurrentCard method
     */
    @Test
    public void getCurrentCardTest() {
        LinkedList<Player> players = new LinkedList<>();
        players.add(new Player("vittorio"));
        Bag bag = new Bag();
        MotherNature motherNature = new MotherNature();
        InfluenceManager influenceManager = new InfluenceManager(motherNature, players);
        IslandManager islandManager = new IslandManager(motherNature);
        ProfessorManager professorManager = new ProfessorManager(players);
        CardManager cardManager = new CardManager(influenceManager, islandManager, professorManager, players, bag);
        ExpertCard expertCard = cardManager.getThreeExpertCards().get(0);
        cardManager.setCurrentCard(expertCard);
        assertTrue(cardManager.getCurrentCard() == expertCard);

    }

    /**
     * Test the gePlayerList method
     */

    @Test
    public void getPlayerListTest() {
        LinkedList<Player> players = new LinkedList<>();
        players.add(new Player("vittorio"));
        Bag bag = new Bag();
        MotherNature motherNature = new MotherNature();
        InfluenceManager influenceManager = new InfluenceManager(motherNature, players);
        IslandManager islandManager = new IslandManager(motherNature);
        ProfessorManager professorManager = new ProfessorManager(players);
        CardManager cardManager = new CardManager(influenceManager, islandManager, professorManager, players, bag);
        assertTrue(cardManager.getPlayerList().get(0).getName() == "vittorio");
    }

    /**
     * Test the getBag method
     */
    @Test
    public void getBagTest() {
        LinkedList<Player> players = new LinkedList<>();
        players.add(new Player("vittorio"));
        Bag bag = new Bag();
        MotherNature motherNature = new MotherNature();
        InfluenceManager influenceManager = new InfluenceManager(motherNature, players);
        IslandManager islandManager = new IslandManager(motherNature);
        ProfessorManager professorManager = new ProfessorManager(players);
        CardManager cardManager = new CardManager(influenceManager, islandManager, professorManager, players, bag);
        assertTrue(cardManager.getBag() == bag);
    }


    /**
     * Test getThreeExpertCards method
     */

    @Test
    public void getThreeExpertCardTest() {
        LinkedList<Player> players = new LinkedList<>();
        players.add(new Player("vittorio"));
        players.get(0).setPlayerColor(PlayerColor.WHITE);
        Bag bag = new Bag();
        MotherNature motherNature = new MotherNature();
        InfluenceManager influenceManager = new InfluenceManager(motherNature, players);
        IslandManager islandManager = new IslandManager(motherNature);
        ProfessorManager professorManager = new ProfessorManager(players);
        CardManager cardManager = new CardManager(influenceManager, islandManager, professorManager, players, bag);
        LinkedList<ExpertCard> newDeck = cardManager.getThreeExpertCards();
        assertTrue(newDeck.size() == 3);
        for (int i=0; i<3; i++) {
            assertTrue(newDeck.get(i).equals(cardManager.getDeck().get(i)));
        }
    }
}

