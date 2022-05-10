package it.polimi.ingsw.model.player;

import it.polimi.ingsw.model.player.board.School;
import it.polimi.ingsw.model.enumerations.AssistantCard;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.enumerations.PlayerPhase;
import it.polimi.ingsw.model.enumerations.Wizard;
import it.polimi.ingsw.utils.IdManager;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Player implements Serializable {

    /**
     * Constructor that require the username and set the deck
     */
    public Player(String name) {
        this.name = name;
        this.id = idCounter.toString();
        IdManager.getInstance().addPlayer(this);
        idCounter++;
        for (AssistantCard a: AssistantCard.values())
           assistantCards.add(a);
    }

    /**
     * Stores the current available id
     */
    private static Integer idCounter = 1;

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
     * Indicates if the player plays a game with 2 or 3 players (default set to 2)
     */
    private Boolean isThreePlayers = false;

    /**
     * The deck of this player
     */
    private ArrayList<AssistantCard> assistantCards = new ArrayList<AssistantCard>();

    /**
     *  The card that the player played
     */
    private AssistantCard playedCard;

    /**
     *  Represent the number of coin own by this player
     */
    private Integer coins = 0;

    /**
     * Reference to the school of this player
     */
    private School school;

    /**
     * The value of the card chose
     */
    private Integer cardValue;

    /**
     * The phase where this player is.
     */
    private PlayerPhase phase;

    /**
     * True if the player is the winner
     */
    private Boolean isWinner = false;

    /**
     * @return  String        The name of this player
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
     * Sets isThreePlayers to true (called if the current game is for 3 players)
     */
    public void setThreePlayers(){
        isThreePlayers = true;
    }

    /**
     * When the player plays the card, that card is  removed;
     */
    public void playAssistantCard(AssistantCard card) {
        this.cardValue = card.getValue();
        this.playedCard = card;
        assistantCards.remove(assistantCards.indexOf(card));
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
        this.color = color;
        this.school = new School(color, isThreePlayers);
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
    public void setCoin(Integer value) {
        this.coins=coins+value;
    }

    /**
     * 
     */
    public void twoMoreJumps() {
        this.cardValue = cardValue+2;
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
    public void isWinner() {
        isWinner = true;
    }

    public void setWizard(Wizard wizard){
        this.wizard = wizard;
    }

    /**
     * @return
     */
    public String getId() { return this.id; }

    /**
     * @return
     */
    public ArrayList<AssistantCard> getAssistantCard(){
        return this.assistantCards;
    }

}