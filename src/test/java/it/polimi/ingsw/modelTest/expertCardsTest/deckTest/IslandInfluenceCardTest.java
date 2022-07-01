package it.polimi.ingsw.modelTest.expertCardsTest.deckTest;

import it.polimi.ingsw.model.calculations.influence.InfluenceManager;
import it.polimi.ingsw.model.calculations.professor.ProfessorManager;
import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.deck.IslandInfluenceCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.islands.IslandManager;
import it.polimi.ingsw.model.pawns.MotherNature;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.studentSuppliers.Bag;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test of islandInfluenceCard
 */
public class IslandInfluenceCardTest {

    /**
     * Test of apply method
     */
    @Test
    public void applyTest() {
        LinkedList<Player> players = new LinkedList<>();
        players.add(new Player("a"));
        players.get(0).setPlayerColor(PlayerColor.WHITE);
        players.get(0).getSchool().getHall().addStudent(new Student(Color.RED));
        Bag bag = new Bag(false);
        MotherNature motherNature = new MotherNature();
        InfluenceManager influenceManager = new InfluenceManager(motherNature, players);
        IslandManager islandManager = new IslandManager(motherNature);
        ProfessorManager professorManager = new ProfessorManager(players);
        CardManager cardManager = new CardManager(influenceManager, islandManager, professorManager, players, bag);
        IslandInfluenceCard islandInfluenceCard = new IslandInfluenceCard(cardManager);
        professorManager.checkProfessor(players.get(0));
        Island island = new Island();
        island.addStudent(new Student(Color.RED));
        cardManager.getInfluenceManager().setStandardInfluence();
        islandInfluenceCard.apply(island);
        assertTrue(islandInfluenceCard.getCost()==4); // check that cost is incremented
        assertTrue(island.getTowers().get(0).getColor().equals(PlayerColor.WHITE)); // check that influence is calculated
    }
}
