package it.polimi.ingsw.model.expertCards;

import it.polimi.ingsw.model.expertCards.deck.*;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.pawns.MotherNature;
import it.polimi.ingsw.model.studentSuppliers.Bag;
import java.util.*;

/**
 * 
 */
public class CardManager {

    /**
     * Constructor who receive the reference to motherNature,Players list and the Bag
     */
    public CardManager(MotherNature motherNature,ArrayList<Player> playerList,Bag bag) {
        this.motherNature=motherNature;
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
    private LinkedList<ExpertCard> expertCards=new LinkedList<ExpertCard>();


    /**
     * Contains the deck of the expertCards
     */
    private ExpertCard currentCard;


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
     * Shuffle the deck and keep only 3 cards
     */
    public void getCards() {
        Collections.shuffle(expertCards);
        for(int i=11;i>2;i--)
            expertCards.remove(i);
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
     * @return  ArrayList<ExpertCard>   Return the three ExpertCards
     */
    public LinkedList<ExpertCard> getThreeExpertCards() {
        return new LinkedList(this.expertCards);
    }

}