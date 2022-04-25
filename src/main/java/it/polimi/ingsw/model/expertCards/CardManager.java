package it.polimi.ingsw.model.expertCards;

import it.polimi.ingsw.model.calculations.professor.ProfessorManager;
import it.polimi.ingsw.model.expertCards.deck.*;
import it.polimi.ingsw.model.islands.IslandManager;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.pawns.MotherNature;
import it.polimi.ingsw.model.studentSuppliers.Bag;
import java.util.*;

/**
 * 
 */
public class CardManager {

    /**
     * Constructor who receive the reference to motherNature, Players list, professorManager, islandManager and the Bag
     */
    public CardManager(MotherNature motherNature, IslandManager islandManager, ProfessorManager professorManager, LinkedList<Player> playerList, Bag bag) {
        this.motherNature=motherNature;
        this.professorManager = professorManager;
        this.islandManager = islandManager;
        this.playerList=new ArrayList<>(playerList);
        this.bag=bag;
        expertCards.add(new ColorInfluenceCard(this));
        expertCards.add(new DenyCard(this));
        expertCards.add(new HallBagSwapCard(this));
        expertCards.add(new IngressCardSwapCard(this));
        expertCards.add(new IngressHallSwapCard(this));
        expertCards.add(new IslandInfluenceCard(this));
        expertCards.add(new ProfessorControlCard(this));
        expertCards.add(new StudentToHallCard(this));
        expertCards.add(new StudentToIslandCard(this));
        expertCards.add(new TowerInfluenceCard(this));
        expertCards.add(new TwoInfluenceCard(this));
        expertCards.add(new TwoJumpCard(this));
    }

    /**
     *  Keep the reference to motherNature
     */
    private MotherNature motherNature;

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
    private LinkedList<ExpertCard> expertCards = new LinkedList<ExpertCard>();

    /**
     * Contains the deck of the expertCards
     */
    private ExpertCard currentCard;

    /**
     *
     */
    private ProfessorManager professorManager;

    /**
     *
     */
    private IslandManager islandManager;

    /**
     * Set the current card
     */
    public void setCurrentCard(ExpertCard expertCard) {
        this.currentCard=expertCard;
    }

    /**
     * @return ExpertCard     Return the current card
     */
    public ExpertCard getCurrentCard(){
        return this.currentCard;
    }

    /**
     * @return MotherNature     Return the reference to motherNature
     */
    public MotherNature getMotherNature() {
        return this.motherNature;
    }

    /**
     * @return ProfessorManager     Return the reference to professorManager
     */
    public ProfessorManager getProfessorManager() { return this.professorManager; }

    /**
     * @return IslandManager        Return the reference to islandManager
     */
    public IslandManager getIslandManager() {
        return this.islandManager;
    }

    /**
     * Shuffle the deck and keep only 3 cards
     */
    private void getCards() {
        Collections.shuffle(expertCards);
        for(int i=11;i>2;i--) {
            expertCards.remove(i);
        }
    }

    /**
     * @return  Player      Return an array of the players.
     */
    public ArrayList<Player> getPlayerList() {
        return new ArrayList<>(playerList);
    }

    /**
     * @return Bag          Return a reference to the bag
     */
    public Bag getBag() {
        return this.bag;
    }

    /**
     * @return  ArrayList<ExpertCard>   Return the three ExpertCards for the game
     */
    public LinkedList<ExpertCard> getThreeExpertCards() {
        getCards();
        return this.expertCards;
    }

    /**
     * only used in tests
     */
    public void getCardsTest() {
        getCards();
    }

    /**
     * only used in tests
     * @return
     */
    public LinkedList<ExpertCard> getDeck() {return this.expertCards;}
}