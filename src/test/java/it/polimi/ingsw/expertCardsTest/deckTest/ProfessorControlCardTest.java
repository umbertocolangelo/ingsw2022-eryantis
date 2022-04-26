package it.polimi.ingsw.expertCardsTest.deckTest;

import it.polimi.ingsw.model.calculations.influence.InfluenceManager;
import it.polimi.ingsw.model.calculations.professor.ProfessorManager;
import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.deck.ProfessorControlCard;
import it.polimi.ingsw.model.expertCards.deck.TwoJumpCard;
import it.polimi.ingsw.model.islands.IslandManager;
import it.polimi.ingsw.model.pawns.MotherNature;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.studentSuppliers.Bag;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfessorControlCardTest {

    /**
     * Test apply
     */
    @Test
    public void applyTest() {
        LinkedList<Player> players = new LinkedList<>();
        players.add(new Player("vittorio"));
        Bag bag = new Bag();
        MotherNature motherNature = new MotherNature();
        InfluenceManager influenceManager = new InfluenceManager(motherNature, players);
        IslandManager islandManager = new IslandManager(motherNature);
        ProfessorManager professorManager = new ProfessorManager(players);
        CardManager cardManager = new CardManager(influenceManager, islandManager, professorManager, players, bag);
        ProfessorControlCard professorControlCard = new ProfessorControlCard(cardManager);
        cardManager.getProfessorManager().setStandardCheck();
        System.out.println(cardManager.getProfessorManager().getStrategy());
        professorControlCard.apply();
        System.out.println(cardManager.getProfessorManager().getStrategy());
        assertTrue(professorControlCard.getCost()==3);
    }
}
