package it.polimi.ingsw.expertCardsTest.deckTest;

import it.polimi.ingsw.model.calculations.influence.InfluenceManager;
import it.polimi.ingsw.model.calculations.professor.ProfessorManager;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.deck.IslandInfluenceCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.islands.IslandManager;
import it.polimi.ingsw.model.pawns.MotherNature;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.studentSuppliers.Bag;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IslandInfluenceCardTest {


    /**
     * Test apply
     */
    @Test
    public void applyTest() {
        LinkedList<Player> players = new LinkedList<>();
        players.add(new Player("vittorio"));
        players.get(0).setPlayerColor(PlayerColor.WHITE);
        Bag bag = new Bag(false);
        MotherNature motherNature = new MotherNature();
        InfluenceManager influenceManager = new InfluenceManager(motherNature, players);
        IslandManager islandManager = new IslandManager(motherNature);
        ProfessorManager professorManager = new ProfessorManager(players);
        CardManager cardManager = new CardManager(influenceManager, islandManager, professorManager, players, bag);
        IslandInfluenceCard islandInfluenceCard = new IslandInfluenceCard(cardManager);
        cardManager.getInfluenceManager().setStandardInfluence();
        System.out.println(cardManager.getInfluenceManager().getInfluence());
        islandInfluenceCard.apply(new Island());
        System.out.println(cardManager.getInfluenceManager().getInfluence());
        assertTrue(islandInfluenceCard.getCost()==4);
    }
}
