package it.polimi.ingsw.model.expertCards;

import it.polimi.ingsw.model.calculations.influence.*;
import it.polimi.ingsw.model.calculations.professor.EqualStrategy;
import it.polimi.ingsw.model.calculations.professor.ProfessorManager;
import it.polimi.ingsw.model.calculations.professor.ProfessorStrategy;
import it.polimi.ingsw.model.calculations.professor.StandardStrategy;
import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.expertCards.deck.*;
import it.polimi.ingsw.model.islands.Island;
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
     * Constructor who receive the reference to motherNature,Players list, professorManager, islandManager and the Bag
     */
    public CardManager(MotherNature motherNature, IslandManager islandManager, ProfessorManager professorManager, ArrayList<Player> playerList, Bag bag) {
        this.motherNature=motherNature;
        this.professorManager = professorManager;
        this.islandManager = islandManager;
        this.playerList=new ArrayList<>(playerList);
        this.bag=bag;
        expertCards.add(new ColorInfluenceCard());
        expertCards.add(new DenyCard());
        expertCards.add(new HallBagSwapCard());
        expertCards.add(new IngressCardSwapCard());
        expertCards.add(new IngressHallSwapCard());
        expertCards.add(new IslandInfluenceCard());
        expertCards.add(new ProfessorControlCard());
        expertCards.add(new StudentToHallCard());
        expertCards.add(new StudentToIslandCard());
        expertCards.add(new TowerInfluenceCard());
        expertCards.add(new TwoInfluenceCard());
        expertCards.add(new TwoJumpCard());
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