package it.polimi.ingsw.model.player;

import it.polimi.ingsw.model.player.board.School;
import it.polimi.ingsw.model.enumerations.AssistantCard;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.enumerations.PlayerPhase;
import it.polimi.ingsw.model.enumerations.Wizard;
import java.util.*;

/**
 * 
 */
public class Player {

    /**
     * Constructor that require the username and set the deck
     */
    public Player(String name) {
        this.name = name;
        this.assistantCards.add(AssistantCard.ONE_CARD);
        this.assistantCards.add(AssistantCard.TWO_CARD);
        this.assistantCards.add(AssistantCard.THREE_CARD);
        this.assistantCards.add(AssistantCard.FOUR_CARD);
        this.assistantCards.add(AssistantCard.FIVE_CARD);
        this.assistantCards.add(AssistantCard.SIX_CARD);
        this.assistantCards.add(AssistantCard.SEVEN_CARD);
        this.assistantCards.add(AssistantCard.EIGHT_CARD);
        this.assistantCards.add(AssistantCard.NINE_CARD);
        this.assistantCards.add(AssistantCard.TEN_CARD);
    }
    /**
     * 
     */
    private String id;

    /**
     *  Name of the player
     */
    private String name;

    /**
     *  Which wizard the player chose
     */
    private Wizard wizard;

    /**
     *  The player color
     */
    private PlayerColor color;

    /**
     * The deck of this player
     */
    private ArrayList<AssistantCard> assistantCards=new ArrayList<AssistantCard>();

    /**
     *  The card that the player played
     */
    private AssistantCard playedCard;

    /**
     *  Represent the number of coin own by this player
     */
    private Integer coins=0;

    /**
     * Reference to the school of this player
     */
    private School school=new School(this.getPlayerColor());

    /**
     * The value of the card chose
     */
    private Integer cardValue;

    /**
     * The phase where this player is.
     */
    private PlayerPhase phase;

    /**
     * @return  String        The name of this palyer
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return      The wizard tht the player chose
     */
    public Wizard getWizard() {

        return this.wizard;
    }

    /**
     *    When the player plays the card, that card is  removed;
     */
    public void playAssistantCard(AssistantCard card) {
        assistantCards.remove(assistantCards.indexOf(card));
        this.cardValue=card.getValue();
        this.playedCard=card;
    }

    /**
     * @return  The value of the card that this player played.
     */
    public Integer getCardPlayedValue() {
        return this.cardValue;
    }

    /**
     * @return  The card that the player played
     */
    public AssistantCard getCardPlayed() {
        return this.playedCard;
    }

    /**
     * @return      The school of this player
     */
    public School getSchool() {
        return this.school;
    }

    /**
     * @return          The number of coins of this player
     */
    public Integer getCoins() {

        return this.coins;
    }

    /**
     * @return          A copy of the deck of this player
   */
    public ArrayList<AssistantCard>getPlayedCards() {

         return new ArrayList<AssistantCard>(this.assistantCards);
    }

    /**
     * @param color     Sets the color of the player and instantiates its school
     */
    public void setPlayerColor(PlayerColor color) {
        this.color=color;
        this.school = new School(color);
    }

    /**
     * @return  PlayerColor     Return the player color
     */
    public PlayerColor getPlayerColor() {
        return this.color;
    }

    /**
     * @return boolean         Return true if the deck doesn't contain any cards, otherwise return false.
     */
    public Boolean isDeckEnded() {
       if(this.assistantCards.size()==0)
           return true;

       else
           return false;
    }

    /**
     *  Add one coin to this player
     */
    public void addCoin() {
        this.coins++;
    }

    /**
     * 
     */
    public void twoMoreJumps() {
        // TODO implement here
    }

    /**
     * @param phase
     */
    public void setPlayerPhase(PlayerPhase phase) {
        this.phase=phase;
    }

    /**
     * @return
     */
    public PlayerPhase getPlayerPhase() {
        return this.phase;
    }

    /**
     * @return
     */
    public Boolean isWinner() {
        // TODO implement here
        return null;
    }

    /**
     *
     */
    public void setPlayedCard(AssistantCard assistantCard){
        this.playedCard=assistantCard;

    }

}