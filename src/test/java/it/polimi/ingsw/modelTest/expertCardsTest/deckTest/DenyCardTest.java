package it.polimi.ingsw.modelTest.expertCardsTest.deckTest;

import it.polimi.ingsw.model.calculations.influence.InfluenceManager;
import it.polimi.ingsw.model.calculations.professor.ProfessorManager;
import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.deck.DenyCard;
import it.polimi.ingsw.model.expertCards.deck.TwoJumpCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.islands.IslandManager;
import it.polimi.ingsw.model.pawns.MotherNature;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.studentSuppliers.Bag;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test of DenyCard classs
 */
public class DenyCardTest {

    /**
     * Test of apply method
     */
    @Test
    public void applyTest() {
        LinkedList<Player> players = new LinkedList<>();
        players.add(new Player("vittorio"));
        Bag bag = new Bag(false);
        MotherNature motherNature = new MotherNature();
        InfluenceManager influenceManager = new InfluenceManager(motherNature, players);
        IslandManager islandManager = new IslandManager(motherNature);
        ProfessorManager professorManager = new ProfessorManager(players);
        CardManager cardManager = new CardManager(influenceManager, islandManager, professorManager, players, bag);
        DenyCard denyCard = new DenyCard(cardManager);
        Island island = new Island();
        denyCard.apply(island);
        assertTrue(denyCard.getCost()==3); // check that cost is incremented
        assertTrue(island.getDeny()==1); // check that deny token is applied
        assertTrue(denyCard.getDenyTokens()==3); // check that deny token is removed from the card

        denyCard.apply(island);
        assertTrue(denyCard.getCost()==4); // check that cost is incremented
        assertTrue(island.getDeny()==2); // check that deny token is applied
        assertTrue(denyCard.getDenyTokens()==2); // check that deny token is removed from the card
    }
}
