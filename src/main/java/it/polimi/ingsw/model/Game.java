package it.polimi.ingsw.model;

import it.polimi.ingsw.model.calculations.influence.InfluenceManager;
import it.polimi.ingsw.model.calculations.professor.ProfessorManager;
import it.polimi.ingsw.model.enumerations.*;
import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.expertCards.deck.*;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.islands.IslandInterface;
import it.polimi.ingsw.model.islands.IslandManager;
import it.polimi.ingsw.model.objectTypes.FixedObjectStudent;
import it.polimi.ingsw.model.pawns.MotherNature;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.rounds.*;
import it.polimi.ingsw.model.studentSuppliers.Bag;
import it.polimi.ingsw.model.studentSuppliers.Cloud;
import it.polimi.ingsw.utils.IdManager;
import it.polimi.ingsw.utils.SavingManager;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 */
public class Game implements GameInterface, Serializable {

    /**
     * Built already the instance of the Rounds
     */
    public Game() {
        setRound(new SetUpRound(this));
    }

    /**
     * Stores the reference of the PropertyChangeSupport
     */
    private final PropertyChangeSupport propertyChange= new PropertyChangeSupport(this);

    /**
     * Stores the clouds instances
     */
    private LinkedList<Cloud> clouds=new LinkedList<>();

    /**
     * Keep track of the order in every  round, dynamically change itself, collect the first who became the current player and at the end of his turn gets removed from the list, start a new pianification round when the list is empty
     */
    private LinkedList <Player> orderedPLayerList= new LinkedList<>();

    /**
     * This list contains the order set for all the game, it's needed for play assistant card
     */
    private LinkedList <Player> playerList = new LinkedList<>();

    /**
     * Stores the instance of mother nature
     */
    private MotherNature motherNature=new MotherNature();

    /**
     * Keep track of the round which is currently on
     */
    private RoundInterface currentRound;

    /**
     * Keep the track of the round which is called before
     */
    private RoundInterface previousRound;

    /**
     * Indicates if the game is 2 (false) or 3 (true) players
     */
    private Boolean isThree = false;

    /**
     * Stores the instance of the Bag
     */
    private Bag bag;

    /**
     * Stores the instance of InfluenceManager
     */
    private InfluenceManager influenceManager;

    /**
     * Stores the instance of IslandManager
     */
    private IslandManager islandManager = new IslandManager(motherNature);

    /**
     * Stores the instance of ProfessorManager
     */
    private ProfessorManager professorManager;

    /**
     * Stores the instance of CardManager
     */
    private CardManager cardManager;

    /**
     * Stores the game mode (normal or expert), the default mode is expert (true)
     */
    private Boolean expertMode = true;

    /**
     * True if the method initializeGame() is called
     */
    private Boolean isStarted = false;

    /**
     * Keep track of the current player
     */
    private Player currentPlayer;

    /**
     * Contains the number of students moved by the current player in his action round
     */
    private Integer studentsMoved=0;

    /**
     * Contains the path of the game save
     */
    private String path = "eriantys";

    /**
     * Adds a listener to the game
     * @param listener is the listener set
     */
    public void addListener(PropertyChangeListener listener){
        propertyChange.addPropertyChangeListener(listener);
    }

    /**
     * Initialize the game by instancing the needed classes and creates the save file path
     */
    public void initializeGame() {

        // generates the path of the game save
        LinkedList<String> playerNames = new LinkedList<String>();
        for(Player player : playerList){
            playerNames.add(player.getName());
        }
        java.util.Collections.sort(playerNames); // sorts the playerNames list alphabetically

        for(String name : playerNames){
            path = path + "-" + name;
        }
        path = path + ".save";

        System.out.println(path);

        bag = new Bag(this.isThree);

        // clouds

        for(int i = 0; i< playerList.size(); i++) {
            Cloud cloud=new Cloud();
            this.clouds.add(cloud);
            for(int j=0;(isThree && j<4) || (!isThree && j<3);j++)
                this.clouds.get(i).addStudent(this.bag.newStudent());
        }

        // generate random numbers within 1 to 12

        int rand = (int)(Math.random() * 11) ;

        this.motherNature.setIsland(islandManager.getIslands().get(rand));
        Island island = (Island) this.islandManager.nextIsland(6);

        for(int i =0;i<12;i++) {
            if (!(islandManager.getIslands().get(i)==this.motherNature.getIsland()|| (islandManager.getIslands().get(i)==island))) {
                Island island1 = (Island) islandManager.getIslands().get(i);
                island1.addStudent(this.bag.newStudent());
            }
        }

        for (Player player : playerList) {
            player.setPlayerPhase(PlayerPhase.SET_UP_PHASE);

        }
        professorManager= new ProfessorManager(playerList);
        influenceManager= new InfluenceManager(motherNature, playerList);
        cardManager = new CardManager(influenceManager,islandManager,professorManager, playerList,bag);
        this.currentPlayer=playerList.getFirst();
        propertyChange.firePropertyChange("Initialize game",null,null);

    }

    /**
     * @param round is set as current round
     */
    public void setRound(RoundInterface round) {
       this.currentRound = round;
    }

    /**
     * @param round is set as previous round
     */
    public void setPreviousRound(RoundInterface round) {
        this.previousRound = round;
    }

    /**
     * @return the previous round
     */
    public RoundInterface getPreviousRound() {
        return this.previousRound;
    }

    /**
     * Sets the players
     * @param players is the list of players playing
     */
    public void setPlayerList(LinkedList<Player> players) {
        this.playerList = players;
        if(players.size()==3) {
            isThree = true;
            for(Player p : players) {
                p.setThreePlayers();
            }
        } else {
            isThree = false;
        }
    }

    /**
     * Checks if there is a winner, if so sets isWinner of the winning player to true
     */
    public void checkWinner() {

        // Proceed only if the game has been initialized
        if(!isStarted){return;}

        // If a player has placed all the towers

        for(Player p : playerList){
            if(p.getSchool().getTowerTable()!=null && p.getSchool().getTowerTable().numOfTowers()==0){
                p.isWinner();
                propertyChange.firePropertyChange("winner", null, p);
                return;
            }
        }

        // If there are 3 island groups

          //TODO

        // If assistant cards finished

        if(playerList.get(0).getAssistantCard().isEmpty() && playerList.get(0).getCardPlayed()==null){ // if the players have played all the assistant cards

            Player winner = playerList.get(0);
            int minTower = winner.getSchool().getTowerTable().numOfTowers();
            LinkedList<Player> tiePlayers = new LinkedList<Player>(); // if there is a tie, stores the players with same number of towers

            for(Player player : playerList){
                if(player==winner){continue;}
                if(player.getSchool().getTowerTable().numOfTowers()<minTower){ // if this player has placed more towers
                    winner = player;
                    minTower = winner.getSchool().getTowerTable().numOfTowers();
                    tiePlayers.clear();
                    continue;
                }
                if(player.getSchool().getTowerTable().numOfTowers()==minTower){
                    if(tiePlayers.isEmpty()){
                        tiePlayers.add(player);
                        tiePlayers.add(winner);
                    }else{
                        tiePlayers.add(player);
                    }
                    winner=null;
                }

            }

            if(winner==null){ // if there is a tie between two players the winner is based on the professors owned
                int maxProfCount = 0;
                for(Player player : tiePlayers){
                    int profCount = 0;
                    for(Color color : Color.values()){
                        if(player.getSchool().getHall().getLine(color).isProfessor()){
                            profCount++;
                        }
                    }

                    if(maxProfCount<profCount){
                        maxProfCount = profCount;
                        winner = player;
                    }

                    if(maxProfCount==profCount){ // if there is a tie
                        winner = null;
                    }
                }
                if(winner==null){ // if still there is a tie, the winner is set randomly
                    winner = tiePlayers.get(0);
                }
            }

            if(winner!=null){
                winner.isWinner();
                propertyChange.firePropertyChange("winner", null, winner);
            }
        }
    }

    /**
     * @return the current round as
     */
    public RoundInterface getCurrentRound(){
        return this.currentRound;
    }

    /**
     * Sets the current player
     * @param player is the player set as current player
     */
    public void setCurrentPlayer(Player player) {
        this.currentPlayer=player;
    }

    /**
     * Save the current state of the game
     */
    public void saveGame() {
        if(!SavingManager.getInstance().saveGame(this, path)){
            System.out.println("Failed to save game");
        }else{System.out.println("Game saved successfully");}
    }

    /**
     * @return true if every player has chosen color and deck
     */
    public Boolean isStarted() {
        return isStarted;
    }

    /**
     * @param studentId is the id of the student on the ingress that is moved on the hall
     */
    public void moveStudentIngressToHall(String studentId) {
        Student student= IdManager.getInstance().getStudent(studentId);

        if(!this.currentRound.moveStudentIngressToHall(student))
            System.out.println("Move not possible");
        if(this.currentRound.moveStudentIngressToHall(student)) {
            this.currentPlayer.getSchool().getHall().getLine(student.getColor()).addStudent(student);
            studentsMoved++;
            professorManager.checkProfessor(currentPlayer);
        }
        if((isThree.equals(true) && studentsMoved==4) || (isThree.equals(false) && studentsMoved==3)) {
            studentsMoved=0;
            currentPlayer.setPlayerPhase(PlayerPhase.MOVING_MOTHERNATURE);

        }
        System.out.println(student.getPosition());
        System.out.println(currentPlayer.getName());
        System.out.println(currentPlayer.getSchool().getIngress());

        saveGame();

        propertyChange.firePropertyChange("moveStudentIngress",  this.currentPlayer.getSchool().getHall().getLine(student.getColor()),student);
    }

    /**
     * @param studentId is the id of the student on the ingress
     * @param islandId is the id of the island where the student is moved
     */
    public void moveStudentIngressToIsland(String studentId, String islandId) {
        Student student=IdManager.getInstance().getStudent(studentId);
        Island island=IdManager.getInstance().getIsland(islandId);
        if (!this.currentRound.moveStudentIngressToIsland(student,island))
            System.out.println("Move not possible");
        if(this.currentRound.moveStudentIngressToIsland(student,island)) {
            island.addStudent(student);
            studentsMoved++;
        }
        if((isThree.equals(true) && studentsMoved==4) || (isThree.equals(false) && studentsMoved==3)) {
            studentsMoved=0;
            currentPlayer.setPlayerPhase(PlayerPhase.MOVING_MOTHERNATURE);
        }

        saveGame();

        propertyChange.firePropertyChange("moveStudentToIsland",island,student);
    }

    /**
     * @param jumps is the number of jumps that mother nature has to do
     */
    public void moveMotherNature(Integer jumps) {
        if(this.currentRound.moveMotherNature(jumps)) {
            this.motherNature.setIsland(this.islandManager.nextIsland(jumps));
            influenceManager.calculateInfluence();
            currentPlayer.setPlayerPhase(PlayerPhase.CHOOSING_CLOUD);
            this.getIslandManager().checkGroup(this.motherNature.getIsland());
            checkWinner();
        }

        saveGame();

        propertyChange.firePropertyChange("move MotherNature",jumps,motherNature.getIsland());
    }

    /**
     * @param assistantId is the id of the assistant card to play
     */
    public void playAssistantCard(String assistantId) {
        AssistantCard assistantCard=IdManager.getInstance().getAssistantCard(assistantId);
        if(this.currentRound.playAssistantCard(assistantCard, this.currentPlayer)) {

            System.out.println("Assistant card played");

            if (playerList.indexOf(currentPlayer) < playerList.size() - 1 && orderedPLayerList.isEmpty()) {
                System.out.println("Modify current player in game");
                this.currentPlayer = playerList.get((playerList.indexOf(currentPlayer) + 1));
            }

            propertyChange.firePropertyChange("Play assistant card", null, assistantCard);
        } else {
            System.out.println("Assistant card already played");
            propertyChange.firePropertyChange("Play assistant card", null, assistantCard);
        }

        saveGame();
    }

    /**
     * @param expertId is the id of the expert card to play
     */
    public void playExpertCard(String expertId, String object) {
        ExpertCard expertCard= IdManager.getInstance().getExpertCard(expertId);

        if (!expertMode) {
            return;
        }
        if (currentRound.playExpertCard(expertCard).equals(true)) { // if the card can be played
            currentPlayer.setCoin(-(expertCard.getCost())); // update the card cost
            cardManager.setCurrentCard(expertCard);

            switch (expertCard.getId()) {
                case "38" -> {
                    ((StudentToIslandCard) expertCard).apply();
                    setPreviousRound(currentRound);
                    setRound(new StudentToIslandActionRound(this));
                }
                case "39" -> ((ProfessorControlCard) expertCard).apply();
                case "40" -> {
                    IslandInterface parameter = IdManager.getInstance().getIsland(object);
                    ((IslandInfluenceCard) expertCard).apply(parameter);
                }
                case "41" -> {
                    ((TwoJumpCard) expertCard).apply();
                    currentPlayer.twoMoreJumps();
                }
                case "42" -> {
                    Island island = IdManager.getInstance().getIsland(object);
                    ((DenyCard) expertCard).apply(island);
                }
                case "43" -> ((TowerInfluenceCard) expertCard).apply();
                case "44" -> {
                    ((IngressCardSwapCard) expertCard).apply();
                    setPreviousRound(currentRound);
                    setRound(new IngressCardSwapActionRound((this)));
                }
                case "45" -> {
                    Player player = IdManager.getInstance().getPlayer(object);
                    ((TwoInfluenceCard) expertCard).apply(player);
                }
                case "46" -> {
                    Color color = IdManager.getInstance().getColor(object);
                    ((ColorInfluenceCard) expertCard).apply(color);
                }
                case "47" -> {
                    ((IngressHallSwapCard) expertCard).apply();
                    setPreviousRound(currentRound);
                    setRound(new IngressHallSwapActionRound(this));
                }
                case "48" -> {
                    ((StudentToHallCard) expertCard).apply();
                    setPreviousRound(currentRound);
                    setRound(new StudentToHallActionRound(this));
                }
                case "49" -> {
                    Color color1 = IdManager.getInstance().getColor(object);
                    ((HallBagSwapCard) expertCard).apply(color1);
                }
            }

            saveGame();

            propertyChange.firePropertyChange("Play expert card", null, expertCard);
        }
    }

    /**
     * @param studentId is the id of the student we want to put on the island
     * @param islandId  is the id of the island where we want to put hte student
     */
    public void expertStudentToIsland(String studentId, String islandId) {
        Student student=IdManager.getInstance().getStudent(studentId);
        Island island=IdManager.getInstance().getIsland(islandId);
        if(this.currentRound.expertStudentToIsland(student, island)){
            island.addStudent(student);
            FixedObjectStudent expertCard = (FixedObjectStudent) cardManager.getCurrentCard();
            expertCard.addStudent(this.bag.newStudent());
            propertyChange.firePropertyChange("expert moveStudentToIsland", island, student);

        }
    }

    /**
     * @param studentCardId is the id of the student on the card
     * @param studentHallId is the id of the student on the ingress
     */
    public void expertIngressCardSwap(String studentCardId, String studentHallId) {
        Student studentCard = IdManager.getInstance().getStudent(studentCardId);
        Student studentHall = IdManager.getInstance().getStudent(studentHallId);
        if (this.currentRound.expertIngressCardSwap(studentCard, studentHall)) {
            this.currentPlayer.getSchool().getIngress().addStudent(studentCard);
            FixedObjectStudent expertCard = (FixedObjectStudent) cardManager.getCurrentCard();
            expertCard.addStudent(studentHall);
            if (((IngressCardSwapActionRound)currentRound).getStudent()==0) {
                finishExpertMove();
            }
            propertyChange.firePropertyChange("expert moveStudentToIsland", studentCard, studentHall);
        }
    }

    /**
     * @param studentHallId is the id of the student present in the hall
     * @param studentIngressId is the id of the student present on the ingress
     */
    public void expertIngressHallSwap(String studentHallId, String studentIngressId) {
        Student studentHall = IdManager.getInstance().getStudent(studentHallId);
        Student studentIngress = IdManager.getInstance().getStudent(studentIngressId);
        if(this.currentRound.expertIngressHallSwap(studentHall, studentIngress)) {
            currentPlayer.getSchool().getIngress().addStudent((studentHall));
            currentPlayer.getSchool().getHall().getLine(studentIngress.getColor()).addStudent(studentIngress);
            if(((IngressHallSwapActionRound)currentRound).getStudent()==0) {
                finishExpertMove();
            }
            propertyChange.firePropertyChange("expert IngressHallSwap", studentHallId, studentIngressId);
        }
    }

    /**
     * @param studentId is the id of the student to put in the Hall
     */
    public void expertStudentToHall(String studentId) {
        Student student = IdManager.getInstance().getStudent(studentId);
        if(this.currentRound.expertStudentToHall(student)) {
            currentPlayer.getSchool().getHall().addStudent(student);
            FixedObjectStudent expertCard = (FixedObjectStudent) cardManager.getCurrentCard();
            expertCard.addStudent(this.bag.newStudent());
            professorManager.checkProfessor(currentPlayer);
            propertyChange.firePropertyChange("expert moveStudentToHall", this.currentPlayer.getSchool().getHall(), student);
        }
    }

    /**
     * @param cloudId is the id of the cloud to be selected
     */
    public void chooseCloud(String cloudId) {
        Cloud cloud = IdManager.getInstance().getCloud(cloudId);
        if(this.currentRound.chooseCloud(cloud)) {
            while (cloud.getStudents().size()!=0) {
                this.currentPlayer.getSchool().getIngress().addStudent(cloud.getStudents().getLast());
            }
            this.currentRound.checkRoundEnded();
            professorManager.setStandardCheck(); // reset the professor calculus

            saveGame();

            propertyChange.firePropertyChange("Choose cloud", this.clouds, cloud);
        }
    }

    /**
     * @return the currentPlayer
     */
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     * @param colorId is the id of the color chosen
     * @param wizardId is the id of the wizard chosen
     */
    public void chooseColorAndDeck(String colorId, String wizardId) {
        PlayerColor color= IdManager.getInstance().getPlayerColor(colorId);
        Wizard wizard= IdManager.getInstance().getWizard(wizardId);
        if (this.currentRound.chooseColorAndDeck(currentPlayer, color, wizard)) {
            this.currentPlayer.setPlayerColor(color);
            System.out.println(this.currentPlayer.getName());
            currentPlayer.setWizard(wizard);
            for (int i=0; (isThree & i<9) || (!isThree && i<7); i++) {
                this.currentPlayer.getSchool().getIngress().addStudent(bag.newStudent());
            }
            if(playerList.indexOf(currentPlayer)<playerList.size()-1) {
                this.currentPlayer = playerList.get((playerList.indexOf(currentPlayer)+1));
                System.out.println(currentPlayer.getName());
            }
            else {
                Collections.shuffle(playerList);
                currentPlayer = playerList.getFirst();
                isStarted=true;
            }
            propertyChange.firePropertyChange("Finished choose color and deck", currentRound, color);
        }
    }

    /**
     * Sets the game mode to normal
     */
    public void setNormalMode() {
        this.expertMode = false;
    }

    /**
     * @return true if the game is in expert mode, false if in normal mode
     */
    public Boolean getGameMode() {
        return expertMode;
    }

    /**
     * @return the orderedPlayerList
     */
    public LinkedList<Player> getOrderedPLayerList() {
        return new LinkedList<>(this.orderedPLayerList);
    }

    /**
     * Set the orderedPlayerList
     */
    public void setOrderedPLayerList(LinkedList<Player> playerList) {
        this.orderedPLayerList = playerList;
    }

    /**
     * Sets the current round to a new PianificationRound
     */
    public void setPianificationRoundState(){
        this.setRound(new PianificationRound(this));
    }

    /**
     * Return the PlayerList
     */
    public LinkedList<Player> getPlayerList() {
        return this.playerList;
    }

    /**
     * Sets the current round to a new ActionRound
     */
    public void setActionRoundState() {
        this.setRound(new ActionRound(this,isThree));
    }

    /**
     * Used if the player wants to finish the move
     */
    public void finishExpertMove() {
        setRound(previousRound);
        propertyChange.firePropertyChange("Finished expert move", cardManager.getCurrentCard(), null);
    }

    /**
     * @return the instance of CardManager
     */
    public CardManager getCardManager() {
        return this.cardManager;
    }

    /**
     * @return the instance of IslandManager
     */
    public IslandManager getIslandManager() {
        return this.islandManager;
    }

    /**
     * @return the instance of the Bag
     */
    public Bag getBag() {
        return this.bag;
    }

    /**
     * @return a linked list containing the clouds
     */
    public LinkedList<Cloud> getClouds() {
        return new LinkedList<>(this.clouds);
    }

    /**
     * Only for testing
     * @return mother nature instance
     */
    public MotherNature getMotherNature() {
        return this.motherNature;
    }

}