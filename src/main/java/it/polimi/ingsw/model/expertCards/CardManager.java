package it.polimi.ingsw.model.expertCards;

import it.polimi.ingsw.model.calculations.influence.InfluenceCalculator;
import it.polimi.ingsw.model.calculations.influence.InfluenceManager;
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
    public CardManager(InfluenceManager influenceManager, IslandManager islandManager, ProfessorManager professorManager, LinkedList<Player> playerList, Bag bag) {
        this.influenceManager = influenceManager;
        this.professorManager = professorManager;
        this.islandManager = islandManager;
        this.playerList=new ArrayList<>(playerList);
        this.bag=bag;
        this.expertCards =  new LinkedList<>(getThreeExpertCards());

    }

    /**
     *  Keep the reference to the InfluenceManager
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
    public InfluenceManager getInfluenceManager() {
        return this.influenceManager;
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
        LinkedList<ExpertCard> expertCards = new LinkedList<ExpertCard>();
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
     *
     */
    public void setExpertCards(ExpertCard expertCard) {
        this.expertCards.add(expertCard);
        this.currentCard = expertCard;
    }

}