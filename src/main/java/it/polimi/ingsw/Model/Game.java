package it.polimi.ingsw.Model;

import it.polimi.ingsw.Model.Enumerations.AssistantCard;
import it.polimi.ingsw.Model.ExpertCards.CardManager;
import it.polimi.ingsw.Model.ExpertCards.ExpertCard;
import it.polimi.ingsw.Model.Islands.Island;
import it.polimi.ingsw.Model.Islands.IslandManager;
import it.polimi.ingsw.Model.Pawns.MotherNature;
import it.polimi.ingsw.Model.Pawns.Student;
import it.polimi.ingsw.Model.Player.Player;
import it.polimi.ingsw.Model.Rounds.RoundInterface;
import it.polimi.ingsw.Model.StudentSuppliers.Bag;
import it.polimi.ingsw.Model.StudentSuppliers.Cloud;

import java.util.*;

/**
 * 
 */
public class Game implements GameInterface {

    /**
     * Default constructor
     */
    public Game() {
    }

    /**
     * 
     */
    private Collection<Cloud> clouds;

    /**
     * 
     */
    private Collection<Player> playerList;

    /**
     * 
     */
    private MotherNature motherNature;

    /**
     * 
     */
    private RoundInterface currentRound;

    /**
     * 
     */
    private Bag bag;

    /**
     * 
     */
    private RoundInterface round;

    /**
     * 
     */
    private Lobby lobby;

    /**
     * 
     */
    private CardManager cardManager;

    /**
     * 
     */
    private Boolean isStarted;

    /**
     * 
     */
    private Player currentPlayer;

    /**
     * 
     */
    private IslandManager islandManager;

    /**
     * 
     */
    private void restoreGame() {
        // TODO implement here
    }

    /**
     * 
     */
    private void inizializeGame() {
        // TODO implement here
    }

    /**
     * @param round
     */
    void setRound(RoundInterface round) {
        // TODO implement here
    }

    /**
     * @param players
     */
    void setPlayerOrder(Collection<Player> players) {
        // TODO implement here
    }

    /**
     * @return
     */
    private Player endGame() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    Player setCurrentPlayer() {
        // TODO implement here
        return null;
    }

    /**
     * @param name 
     * @param playerNum
     */
    public void playerLogin(String name, Integer playerNum) {
        // TODO implement here
    }

    /**
     * @param playerNum
     */
    public void startGame(Integer playerNum) {
        // TODO implement here
    }

    /**
     * 
     */
    public void saveGame() {
        // TODO implement here
    }

    /**
     * @return
     */
    public Boolean isStarted() {
        // TODO implement here
        return null;
    }

    /**
     * @param student
     */
    public void moveStudentIngressToHall(String student) {
        // TODO implement here
    }

    /**
     * @param student 
     * @param island
     */
    public void moveStudentIngressToIsland(String student, String island) {
        // TODO implement here
    }

    /**
     * @param jumps
     */
    public void moveMotherNature(Integer jumps) {
        // TODO implement here
    }

    /**
     * @param assistantCard
     */
    public void playAssistantCard(String assistantCard) {
        // TODO implement here
    }

    /**
     * @param expertCard 
     * @param parameter
     */
    public void playExpertCard(String expertCard, String parameter) {
        // TODO implement here
    }

    /**
     * @param student 
     * @param island
     */
    public void expertStudentToIsland(String student, String island) {
        // TODO implement here
    }

    /**
     * @param student
     */
    public void expertIngressCardSwap(String student) {
        // TODO implement here
    }

    /**
     * @param studentHall 
     * @param studentIngress
     */
    public void expertIngressHallSwap(String studentHall, String studentIngress) {
        // TODO implement here
    }

    /**
     * @param student
     */
    public void expertStudentToHall(String student) {
        // TODO implement here
    }

    /**
     * @param cloud
     */
    public void chooseCloud(String cloud) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Boolean chooseExpertMode() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public String getCurrentPlayer() {
        // TODO implement here
        return "";
    }

}