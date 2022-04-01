package it.polimi.ingsw.Model.Player;

import it.polimi.ingsw.Model.Player.Board.School;
import it.polimi.ingsw.Model.Enumerations.AssistantCard;
import it.polimi.ingsw.Model.Enumerations.PlayerColor;
import it.polimi.ingsw.Model.Enumerations.PlayerPhase;
import it.polimi.ingsw.Model.Enumerations.Wizard;

import java.util.*;

/**
 * 
 */
public class Player {

    /**
     * Default constructor
     */
    public Player() {
    }

    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Wizard wizard;

    /**
     * 
     */
    private PlayerColor color;

    /**
     * 
     */
    private Collection<AssistantCard> assistantCards;

    /**
     * 
     */
    private AssistantCard playedCard;

    /**
     * 
     */
    private Integer coins;

    /**
     * 
     */
    private School school;

    /**
     * 
     */
    private Integer cardValue;

    /**
     * 
     */
    private PlayerPhase phase;

    /**
     * @return
     */
    public String getName() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public Wizard getWizard() {
        // TODO implement here
        return null;
    }

    /**
     * 
     */
    public void playAssistantCard() {
        // TODO implement here
    }

    /**
     * @return
     */
    public School getSchool() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Integer getCoins() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public AssistantCard getPlayedCard() {
        // TODO implement here
        return null;
    }

    /**
     * @param PlayerColor
     */
    public void setPlayerColor(void PlayerColor) {
        // TODO implement here
    }

    /**
     * @return
     */
    public PlayerColor getPlayerColor() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Boolean isDeckEnded() {
        // TODO implement here
        return null;
    }

    /**
     * 
     */
    public void addCoin() {
        // TODO implement here
    }

    /**
     * 
     */
    public void twoMoreJumps() {
        // TODO implement here
    }

    /**
     * @param PlayerPhase
     */
    public void setPlayerPhase(void PlayerPhase) {
        // TODO implement here
    }

    /**
     * @return
     */
    public PlayerPhase getPlayerPhase() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Boolean isWinner() {
        // TODO implement here
        return null;
    }

}