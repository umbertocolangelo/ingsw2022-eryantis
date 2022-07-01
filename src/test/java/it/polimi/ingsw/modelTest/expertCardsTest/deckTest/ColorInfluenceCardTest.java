package it.polimi.ingsw.modelTest.expertCardsTest.deckTest;

import it.polimi.ingsw.model.calculations.influence.ColorInfluence;
import it.polimi.ingsw.model.calculations.influence.InfluenceManager;
import it.polimi.ingsw.model.calculations.influence.StandardInfluence;
import it.polimi.ingsw.model.calculations.professor.ProfessorManager;
import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.deck.ColorInfluenceCard;
import it.polimi.ingsw.model.islands.IslandManager;
import it.polimi.ingsw.model.pawns.MotherNature;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.studentSuppliers.Bag;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test of ColorInfluenceCard class
 */
public class ColorInfluenceCardTest {

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
        ColorInfluenceCard colorInfluenceCard = new ColorInfluenceCard(cardManager);
        cardManager.getInfluenceManager().setStandardInfluence();
        System.out.println(cardManager.getInfluenceManager().getInfluence());
        colorInfluenceCard.apply(Color.YELLOW);
        System.out.println(cardManager.getInfluenceManager().getInfluence());
        assertTrue(colorInfluenceCard.getCost()==4); // check that cost is incremented
        assertTrue(influenceManager.getInfluence() instanceof ColorInfluence); // check that correct influence state is applied
        colorInfluenceCard.apply(Color.RED);
        assertTrue(colorInfluenceCard.getCost()==5); // check that cost is incremented
    }

}
