package it.polimi.ingsw.model.rounds;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.AssistantCard;
import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.enumerations.PlayerPhase;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.pawns.MotherNature;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.studentSuppliers.Cloud;

import java.util.LinkedList;

/**
 * 
 */
public class ActionRound implements RoundInterface {

    /**
     * Every time is called he set the current player, the player phase e change the player getting from the orderedlist
     */
    public ActionRound(Game game) {
        this.game=game;
        this.game.setCurrentPlayer(this.game.getOrderedPLayerList().getFirst());
        this. currentPlayer=this.game.getCurrentPlayer();
        this.currentPlayer.setPlayerPhase(PlayerPhase.MOVING_STUDENTS);

    }

    /**
     *Keep the reference to the current player
     */
    private Player currentPlayer;

    /**
     *Keep track of the number of students moved
     */
    private Integer studentsMoved = 0;


    /**
     *
     */
    private MotherNature motherNature;

    /**
     * Keep the reference to mothernature
     */
    private Game game;

    /**
     *
     */
    private void checkWinner() {
        // TODO implement here
    }

    /**
     *
     * @return boolean  Check if the round ended end if we all the player played so create pianification
     */
    @Override
    public Boolean checkRoundEnded() {
        if(this.game.getOrderedPLayerList().isEmpty()) {
            LinkedList<Player> players=this.game.getOrderedPLayerList();
            players.removeFirst();
            this.game.setOrderedPLayerList(players);
            this.game.setRound(this.game.setPianificationnRoundState());
        return true;
        }
        if(this.currentPlayer.getPlayerPhase()==PlayerPhase.CHOOSING_CLOUD){
            LinkedList<Player> players=this.game.getOrderedPLayerList();
        players.removeFirst();
        this.game.setOrderedPLayerList(players);
            this.game.setRound(game.setActionRoundState());

        return true;
        }
        return false;
    }

    /**
     * @param student   The student present in the hall that we want to move
     * @return boolean          True if the student is moved correctly, false if it's not possible to move
     */
    public Boolean moveStudentIngressToHall(Student student) {
        if(this.currentPlayer.getPlayerPhase() != PlayerPhase.MOVING_STUDENTS || !this.currentPlayer.getSchool().getIngress().getStudents().contains(student))
        return false;
        this.studentsMoved++;
        if(this.studentsMoved==3) {
            currentPlayer.setPlayerPhase(PlayerPhase.MOVING_MOTHERNATURE);
            return true;
        }

        return true;
    }

    /**
     * @param student       Student in the ingress
     * @param island        Island we want to put the student
     * @return              True if its not his last move
     */
    public Boolean moveStudentIngressToIsland(Student student, Island island) {
        if (this.currentPlayer.getPlayerPhase() != PlayerPhase.MOVING_STUDENTS || !this.currentPlayer.getSchool().getIngress().getStudents().contains(student))
            return false;
        this.studentsMoved++;
        if(this.studentsMoved==3) {
            currentPlayer.setPlayerPhase(PlayerPhase.MOVING_MOTHERNATURE);
            return true;
        }

        return true;
    }

    /**
     * @param jumps
     * @return
     */
    public Boolean moveMotherNature(Integer jumps) {
        //Non capisco come funziona se le isole sono raggruppate
        return null;
    }

    /**
     * @param assistantCard
     * @return
     */
    public Boolean playAssistantCard(AssistantCard assistantCard, Player player) {
        return null;
    }

    /**
     *
     * @param expertCard        We receive the expertCard and called the method needed for each expertCard
     * @return
     */
    public Boolean playExpertCard(ExpertCard expertCard) {
       game.getCardManager().setCurrentCard(expertCard);
        currentPlayer.setCoin(-(expertCard.getCost()));
        game.getCardManager().getCurrentCard().incrementCost();
       if(expertCard.getId().equals("4")) {
           this.game.setPreviousRound(this);

           this.game.setRound(this.game.setIngressCardSwapActionRound());
           return true;
       }
     if(expertCard.getId().equals("5")){
         game.setPreviousRound(this);
         game.setRound(game.setIngressHallSwapState());
         return true;
     }
        if(expertCard.getId().equals("8")){
            game.setPreviousRound(this);
            game.setRound(game.setStudentToHallState());
            return true;
        }
        if(expertCard.getId().equals("9")){
            game.setPreviousRound(this);
            game.setRound(this.game.setStudentToIslandState());
            return true;
        }
        if(expertCard.getId().equals("3")){
            expertMoveStudentToBag(this.game,Color.RED);
            //Dovremmo mettere un attributo del colore degli studenti sulla carta
            return true;
        }

        return false;
    }


    /**
     *
     * @param game          The reference to the game
     * @param color         The reference to the color
     */
     private void expertMoveStudentToBag(Game game, Color color) {
        LinkedList <Player> players=game.getOrderedPLayerList();
        for(Player player : players){
            LinkedList<Student> students=player.getSchool().getHall().getLine(color).getStudents();
            for (int i=0 ; i<3 || students.isEmpty();i++){
                player.getSchool().getHall().getLine(color).removeStudent(students.removeLast());
            }
        }
        this.game.getCardManager().setCurrentCard(null);
    }


    /**
     * @param student
     * @param island
     * @return
     */
    public Boolean expertStudentToIsland(Student student, Island island) {
        // TODO implement here
        return null;
    }

    /**
     * @param studentCard
     * @param Ingress
     * @return
     */
    public Boolean expertIngressCardSwap(Student studentCard, Student Ingress) {
        return false;
    }

    /**
     *
     * @return
     */

    public Boolean finishExpertMove() {
        return null;
    }

    /**
     * @param studentHall
     * @param studentIngress
     * @return
     */
    public Boolean expertIngressHallSwap(Student studentHall, Student studentIngress) {
     return false;
    }



    /**
     * @param student
     * @return
     */
    public Boolean expertStudentToHall(Student student) {
       return false;
    }

    /**
     * @param cloud     The cloud chose from the
     * @return          True uf we can make the move
     */
    public Boolean chooseCloud(Cloud cloud) {
        this.currentPlayer= game.getCurrentPlayer();
        if (this.currentPlayer.getPlayerPhase() != PlayerPhase.CHOOSING_CLOUD)
            return false;
        if (cloud.getStudents().size() == 0)
            return false;
        return true;

    }

    /**
     *Return the number of the students moved
     */
    public Integer getStudentsMoved(){
        return this.studentsMoved;
    }
}