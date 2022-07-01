package it.polimi.ingsw.model.expertCards;

import it.polimi.ingsw.model.calculations.influence.InfluenceManager;
import it.polimi.ingsw.model.calculations.professor.ProfessorManager;
import it.polimi.ingsw.model.expertCards.deck.*;
import it.polimi.ingsw.model.islands.IslandManager;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.studentSuppliers.Bag;
import it.polimi.ingsw.utils.IdManager;

import java.io.Serializable;
import java.util.*;

/**
 * Class used to manage the expert cards
 */
public class CardManager implements Serializable {

    /**
     * Constructor who receive the reference to motherNature, Players list, professorManager, islandManager and the Bag
     * @param influenceManager InfluenceManager
     * @param islandManager IslandManager
     * @param professorManager ProfessorManager
     * @param playerList LinkedList
     * @param bag Bag
     */
    public CardManager(InfluenceManager influenceManager, IslandManager islandManager, ProfessorManager professorManager, LinkedList<Player> playerList, Bag bag) {
        this.influenceManager = influenceManager;
        this.professorManager = professorManager;
        this.islandManager = islandManager;
        this.playerList = new ArrayList<>(playerList);
        this.bag = bag;
        this.expertCards = new LinkedList<>(getThreeExpertCards());
    }

    /**
     * Keep the reference to the InfluenceManager
     */
    private InfluenceManager influenceManager;

    /**
     * Contains the player list
     */
    private ArrayList<Player> playerList;

    /**
     * Contains the reference of the bag
     */
    private Bag bag;

    /**
     * Contains the deck of the expertCards
     */
    private LinkedList<ExpertCard> expertCards;

    /**
     * Contains the deck of the expertCards
     */
    private ExpertCard currentCard;

    /**
     * Reference of the professor manager
     */
    private ProfessorManager professorManager;

    /**
     * Reference of the island manager
     */
    private IslandManager islandManager;

    /**
     * Set the current card
     * @param expertCard ExpertCard
     */
    public void setCurrentCard(ExpertCard expertCard) {
        this.currentCard = expertCard;
    }

    /**
     * @return current current expert card
     */
    public ExpertCard getCurrentCard(){
        return this.currentCard;
    }

    /**
     * reset current card to null
     */
    public void resetCurrentCard() { this.currentCard = null; }

    /**
     * Reference to influence manager
     * @return influence manager
     */
    public InfluenceManager getInfluenceManager() {
        return this.influenceManager;
    }

    /**
     * Reference to professor manager
     * @return professor manager
     */
    public ProfessorManager getProfessorManager() { return this.professorManager; }

    /**
     * Reference to island manager
     * @return island manager
     */
    public IslandManager getIslandManager() {
        return this.islandManager;
    }

    /**
     * player list
     * @return array list of the players
     */
    public ArrayList<Player> getPlayerList() {
        return new ArrayList<>(playerList);
    }

    /**
     * Reference to the bag
     * @return bag
     */
    public Bag getBag() {
        return this.bag;
    }

    /**
     * Return the three ExpertCards for the game
     * @return ArrayList<ExpertCard>
     */
    private LinkedList<ExpertCard> getThreeExpertCards() {
        LinkedList<ExpertCard> expertCards = new LinkedList<ExpertCard>();
        expertCards.add(new ColorInfluenceCard(this));
        expertCards.add(new DenyCard(this));
        expertCards.add(new HallBagSwapCard(this));
        expertCards.add(new IngressCardSwapCard(this));
        expertCards.add(new IngressHallSwapCard());
        expertCards.add(new IslandInfluenceCard(this));
        expertCards.add(new ProfessorControlCard(this));
        expertCards.add(new StudentToHallCard(this));
        expertCards.add(new StudentToIslandCard(this));
        expertCards.add(new TowerInfluenceCard(this));
        expertCards.add(new TwoInfluenceCard(this));
        expertCards.add(new TwoJumpCard());
        Collections.shuffle(expertCards);
        for(int i=11;i>2;i--) {
            expertCards.remove(i);
        }
        return expertCards;
    }

    /**
     * @return expert cards usable in this game
     */
    public LinkedList<ExpertCard> getDeck() {return this.expertCards;}

    /**
     * sets expert cards
     * @param expertCard ExpertCard
     */
    public void setExpertCards(ExpertCard expertCard) {
        this.expertCards.add(expertCard);
        this.currentCard = expertCard;
    }

    /**
     * debugging only
     * @param id String
     */
    public void setDeck(String id) {
       ExpertCard expertCard= IdManager.getInstance().getExpertCard(id);
       expertCards.add(0,expertCard);
       expertCards.removeLast();
    }

}