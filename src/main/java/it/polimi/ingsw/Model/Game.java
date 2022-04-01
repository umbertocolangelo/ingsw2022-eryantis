package it.polimi.ingsw.Model;

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
    private LinkedList<Island> islands;

    /**
     * 
     */
    private ArrayList<Cloud> clouds;

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
    private Collection<Player> actionPlayerOrder;

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
    public MotherNature 1;









    /**
     * 
     */
    public Lobby 1;



    /**
     * 
     */
    private void startGame() {
        // TODO implement here
    }

    /**
     * @param number
     */
    public void setPlayerNumber(Int number) {
        // TODO implement here
    }

    /**
     * @param name 
     * @param playerNum
     */
    public void playerLogin(String name, Int playerNum) {
        // TODO implement here
    }

    /**
     * @param playerNum
     */
    public void startGame(Int playerNum) {
        // TODO implement here
    }

    /**
     * 
     */
    public void saveGame() {
        // TODO implement here
    }

    /**
     * @param player
     */
    public void endGame(Player player) {
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
    public void moveStudentIngressToHall(Student student) {
        // TODO implement here
    }

    /**
     * @param student 
     * @param target
     */
    public void moveStudentIngressToIsland(Student student, Island target) {
        // TODO implement here
    }

    /**
     * @param jumps
     */
    public void moveMotherNature(Int jumps) {
        // TODO implement here
    }

    /**
     * @param assistantCard
     */
    public void playAssistantCard(AssistantCard assistantCard) {
        // TODO implement here
    }

    /**
     * @return
     */
    public ArrayList<Player> getPlayers() {
        // TODO implement here
        return null;
    }

    /**
     * 
     */
    public void checkWinner() {
        // TODO implement here
    }

    /**
     * @param expertCard 
     * @param Object parameter
     */
    public void playExpertCard(ExpertCard expertCard, void Object parameter) {
        // TODO implement here
    }

    /**
     * @return
     */
    public LinkedList<Island> getIslands() {
        // TODO implement here
        return null;
    }

    /**
     * @param student 
     * @param island
     */
    public void expertStudentToIsland(Student student, Island island) {
        // TODO implement here
    }

    /**
     * @param student
     */
    public void expertIngressCardSwap(Student student) {
        // TODO implement here
    }

    /**
     * @param studentHall 
     * @param studentIngress
     */
    public void expertIngressHallSwap(Student studentHall, Student studentIngress) {
        // TODO implement here
    }

    /**
     * @param student
     */
    public void expertStudentToHall(Student student) {
        // TODO implement here
    }

    /**
     * @param student
     */
    public void moveStudentToBag(Student student) {
        // TODO implement here
    }

    /**
     * @param cloud
     */
    public void chooseCloud(Cloud cloud) {
        // TODO implement here
    }

    /**
     * @param island
     */
    protected void removeIsland(Island island) {
        // TODO implement here
    }

    /**
     * @return
     */
    public String getCurrentPlayer() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public ArrayList<Cloud> getClouds() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public ArrayList<AssistantCard> getAssistantCard() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public ArrayList<ExpertCard> getExpertCards() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public ArrayList<ExpertCard> getExpertCards() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public ArrayList<Island> getIslands() {
        // TODO implement here
        return null;
    }

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
    public void playerLogin(String name, Int playerNum) {
        // TODO implement here
    }

    /**
     * @param playerNum
     */
    public void startGame(Int playerNum) {
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
    public void moveMotherNature(Int jumps) {
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
    public void playExpertCard(String expertCard, Object parameter) {
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