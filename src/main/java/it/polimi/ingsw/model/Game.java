package it.polimi.ingsw.model;

import it.polimi.ingsw.model.calculations.professor.ProfessorManager;
import it.polimi.ingsw.model.enumerations.AssistantCard;
import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.islands.IslandManager;
import it.polimi.ingsw.model.pawns.MotherNature;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.rounds.*;
import it.polimi.ingsw.model.studentSuppliers.Bag;
import it.polimi.ingsw.model.studentSuppliers.Cloud;

import java.util.*;

/**
 *
 */
public class Game implements GameInterface {

    /**
     * Built already the istance of the Rounds
     */
    public Game() {
        this.ingressHallSwap=new IngressHallSwapActionRound(this);
        this.studentToIslandRound=new StudentToIslandActionRound(this);
        this.ingressCardSwap=new IngressCardSwapActionRound((this));
        this.studentToHallRound= new StudentToHallActionRound(this);
    }
    /**
     *Kepp the reference to ingressCArdSwap
     */
    RoundInterface ingressCardSwap;

    /**
     *Keep the reference to ingressHallSwap
     */
    RoundInterface ingressHallSwap;

    /**
     *Keep the reference to actionRound
     */
    RoundInterface actionRound;

    /**
     *Keep the reference to pianificationRound
     */
    RoundInterface pianificationRound;

    /**
     *Keep the reference to studentToIslandRound
     */
    RoundInterface studentToIslandRound;

    /**
     *Keep the reference to studentToHallRound
     */
    RoundInterface studentToHallRound;

    /**
     *
     */
    private Collection<Cloud> clouds;

    /**
     *Keep track of the order in every  round, dinamically change itself, collect the first who became the current player and at the end of his turn gets removed from the list, start a new pianification round when the list is empty
     */
    private LinkedList <Player> orderedPLayerList= new LinkedList<>();

    /**
     *This list contains the order set for all the game, its needed for play assistant card
     */
    private LinkedList <Player> pLayerList= new LinkedList<>();

    /**
     *
     */
    private MotherNature motherNature;

    /**
     *Keep track of the round which is currently on
     */
    private RoundInterface currentRound;

    /**
     *Keep the track of the round which is called before
     */
    private RoundInterface previousRound;

    /**
     *
     */
    private Bag bag;


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
     *Keep track of the current player
     */
    private Player currentPlayer;

    /**
     *
     */
    private IslandManager islandManager;

    /**
     *
     */
    private ProfessorManager professorManager;

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
     * @param round     Set the current round
     */
    public void setRound(RoundInterface round) {
       this.currentRound=round;
    }

    /**
     * @param round     Set the previous round
     */
    public void setPreviousRound(RoundInterface round) {
        this.previousRound=round;

    }

    /**
     *
     * @return previousRound    Return the previous round
     */
    public RoundInterface getPreviousRound() {
        return this.previousRound;
    }


    /**
     * @param players playerList        Set the playerList
     */
    public void setPLayerList(LinkedList<Player> players) {
        this.pLayerList=players;
    }

    /**
     * @return
     */
    private Player endGame() {
        // TODO implement here
        return null;
    }

    /**
     * @param first     Set the current player
     */
    public void setCurrentPlayer(Player first) {
        this.currentPlayer=first;
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
     * @param student       Move the student from the ingress to the hall
     */
    public void moveStudentIngressToHall(Student student) {
        this.currentRound.moveStudentIngressToHall(student);
    }

    /**
     * @param student       Student in the ingress
     * @param island        Island where we want to move
     */
    public void moveStudentIngressToIsland(Student student, Island island) {
        this.currentRound.moveStudentIngressToIsland(student,island);
    }

    /**
     * @param jumps
     */
    public void moveMotherNature(Integer jumps) {
        // TODO implement here
    }

    /**
     * @param assistantCard     Play playAssistantCard on the currentRound
     */
    @Override
    public void playAssistantCard(AssistantCard assistantCard) {
        this.currentRound.playAssistantCard(assistantCard,this.currentPlayer);
    }


    /**
     * @param expertCard        Play the expert card
     */
    public Boolean playExpertCard(ExpertCard expertCard) {
        this.currentRound.playExpertCard(expertCard);
        return true;

    }

    /**
     * @param student               The student we want to put on the island
     * @param island                The island where we want to put hte student
     */
    public void expertStudentToIsland(Student student, Island island) {
        this.currentRound.expertStudentToIsland(student,island);
    }

    /**
     * @param studentCard           The studentCard from the ExpertCard
     * @param studentIngress        The student from the ingress
     */
    public void expertIngressCardSwap(Student studentCard, Student studentIngress) {
        this.currentRound.expertIngressCardSwap(studentCard, studentIngress);
    }

    /**
     * @param studentHall           The student present in the hall
     * @param studentIngress        The student present on the ingress
     */
    public void expertIngressHallSwap(Student studentHall, Student studentIngress) {
        this.currentRound.expertIngressHallSwap(studentHall,studentIngress);
    }

    /**
     * @param student           The student we want to put in the Hall
     */
    public void expertStudentToHall(Student student) {
        this.currentRound.expertStudentToHall(student);
    }

    /**
     * @param cloud         The cloud we want to select
     *                      Its not clear how we set the cloud we can get
     */
    public void chooseCloud(Cloud cloud) {
        this.currentRound.chooseCloud(cloud);
    }

    /**
     * @return
     */
    public Boolean chooseExpertMode() {
        // TODO implement here
        return null;
    }

    /**
     * @return currentPlayer      Return the currentPlayer
     */
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     * @return orderedPlayerList    Return the orderedPlayerList
     */
    public LinkedList<Player> getOrderedPLayerList(){
        return new LinkedList<>(this.orderedPLayerList);
    }

    /**
     * Set the orderedPlayerList
     */
    public void setOrderedPLayerList(LinkedList<Player> playerList){
        this.orderedPLayerList=playerList;
    }


    /**
     *@return ingressHallSwap Return the IngressHallSwap
     */
    public IngressHallSwapActionRound setIngressHallSwapState(){
        return (IngressHallSwapActionRound) this.ingressHallSwap;
    }

    /**
     *@return pianificationRound Return the pianificationRound
     */
    public PianificationRound setPianificationnRoundState(){
        this.pianificationRound=new PianificationRound(this);
        return (PianificationRound) this.pianificationRound;
    }

    /**
     *Return the PlayerList
     */
    public LinkedList<Player> getPlayerList() {
        return this.pLayerList;
    }

    /**
     **@return actionRound Return the actionRound
     */
    public ActionRound setActionRoundState(){
        this.actionRound=new ActionRound(this);
        return (ActionRound) this.actionRound;
    }



    /**
     **@return studentToIslandRound Return the studentToIslandRound
     */
    public StudentToIslandActionRound setStudentToIslandState(){
        return (StudentToIslandActionRound) this.studentToIslandRound;
    }

    /**
     **@return ingressCardSwap Return the ingressCardSwap
     */
    public IngressCardSwapActionRound setIngressCardSwapActionRound(){
        return (IngressCardSwapActionRound) this.ingressCardSwap;
    }

    /**
     *@return studentToHallRound Return the studentToHallRound
     */
    public StudentToHallActionRound setStudentToHallState(){
       return (StudentToHallActionRound) this.studentToHallRound;
    }

    /**
     *Used if the player wants to finish the move
     */
    public void finishExpertMove(){
        this.currentRound.finishExpertMove();
    }

    /**
     * @return     Its needed for the rounds when the pick a student from an expert card they put another one, they need to access to current card
     */
    public CardManager getCardManager(){
        return this.cardManager;
    }

    /**
     * @return  Bag     Return the istance of the Bag
     */
    public Bag getBag(){
        return this.bag;
    }

    /**
     * Set the Playerlist, only for dedubbing so far
     */
    public void setPlayerList(LinkedList<Player> players){
        this.pLayerList=players;
    }
}