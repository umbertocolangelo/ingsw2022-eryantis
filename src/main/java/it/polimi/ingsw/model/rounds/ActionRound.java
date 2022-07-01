package it.polimi.ingsw.model.rounds;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.AssistantCard;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.enumerations.PlayerPhase;
import it.polimi.ingsw.model.enumerations.Wizard;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.pawns.MotherNature;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.studentSuppliers.Cloud;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Class used to represent the game's action round
 */
public class ActionRound implements RoundInterface, Serializable {

    /**
     * Every time is called he set the current player, the player phase e change the player ing from the ordered list
     * @param game The reference to game
     * @param isThreePlayers true if we are in three players, false otherwise.
     */
    public ActionRound(Game game, Boolean isThreePlayers) {
        this.game = game;
        this.game.setCurrentPlayer(this.game.getOrderedPlayerList().getFirst());
        this.currentPlayer = this.game.getCurrentPlayer();
        this.currentPlayer.setPlayerPhase(PlayerPhase.MOVING_STUDENTS);
    }

    /**
     * Keep the track if we already played a card in this round
     */
    private Boolean cardAlreadyPlayed = false;

    /**
     * Keep the reference to the current player
     */
    private Player currentPlayer;

    /**
     * Keep track of the number of students moved
     */
    private Integer studentsMoved = 0;

    /**
     * Keep the reference to mother nature
     */
    private Game game;

    /**
     * Check if the round ended end if all the players have played and then creates pianification phase
     * @return Boolean
     */
    @Override
    public Boolean checkRoundEnded() {
        if (this.game.getOrderedPlayerList().isEmpty()) {
            for (Cloud d: game.getClouds()) {
                game.getBag().addStudentsOnCloud(d);
            }
            for (int i=0;i<game.getPlayerList().size();i++) {
                this.game.getPlayerList().get(i).setPlayerPhase(PlayerPhase.CHOOSING_ASSISTANT);
            }
            game.getCardManager().resetCurrentCard();
            this.game.setCurrentPlayer(game.getPlayerList().getFirst());
            this.game.setPianificationRoundState();
            return true;
        }
        if (this.currentPlayer.getPlayerPhase()==PlayerPhase.CHOOSING_CLOUD) {
            this.game.setActionRoundState();
            game.getCardManager().resetCurrentCard();
            return true;
        }
        return false;
    }

    /**
     * True if the student is moved correctly, false if it's not possible to move
     * @param student   The student present in the hall that has to be moved
     * @return boolean
     */
    public Boolean moveStudentIngressToHall(Student student) {
        if (this.currentPlayer.getPlayerPhase() != PlayerPhase.MOVING_STUDENTS || !this.currentPlayer.getSchool().getIngress().getStudents().contains(student) || this.currentPlayer.getSchool().getHall().getLine(student.getColor()).getStudents().size()==10) {
            return false;
        }
        return true;
    }

    /**
     * True if it's not his last move
     * @param student in the ingress
     * @param island where to put the student on
     * @return Boolean
     */
    public Boolean moveStudentIngressToIsland(Student student, Island island) {
        if (this.currentPlayer.getPlayerPhase() != PlayerPhase.MOVING_STUDENTS || !this.currentPlayer.getSchool().getIngress().getStudents().contains(student)) {
            return false;
        }
        return true;
    }

    /**
     * true if it is moving mother nature phase
     * @param jumps the jumps we want to make
     * @return Boolean true if the move is possible, false otherwise.
     */
    public Boolean moveMotherNature(Integer jumps) {
       if (currentPlayer.getPlayerPhase()!=PlayerPhase.MOVING_MOTHERNATURE || currentPlayer.getCardPlayedValue()<jumps || jumps<1) {
           return false;
       } else {
           return true;
       }
    }

    /**
     * returns the possibility of playing an assistant card
     * @param assistantCard AssistantCard
     * @param player Player
     * @return Boolean
     */
    public Boolean playAssistantCard(AssistantCard assistantCard, Player player) {
        return null;
    }

    /**
     * returns the possibility of playing an expert card
     * @param expertCard ExpertCard
     * @return Boolean
     */
    public Boolean playExpertCard(ExpertCard expertCard) {
        if (expertCard.getCost()>currentPlayer.getCoins() || cardAlreadyPlayed) { // if the current player can't play the card
            return false;
        }
        cardAlreadyPlayed = true;
        return true;
    }

    /**
     * returns the possibility of choosing color and deck
     * @param player current
     * @param color chosen
     * @param wizard chosen
     * @return Boolean
     */
    @Override
    public Boolean chooseColorAndDeck(Player player, PlayerColor color, Wizard wizard) {
        return null;
    }

    /**
     * @return action round id
     */
    @Override
    public Integer getId() {
        return null;
    }

    /**
     * returns the possibility of playing the expert card student to island
     * @param student Student
     * @param island Island
     * @return Boolean
     */
    public Boolean expertStudentToIsland(Student student, Island island) {
        return null;
    }

    /**
     * returns the possibility of playing the expert card ingress card swap
     * @param studentCard Student
     * @param Ingress Student
     * @return Boolean
     */
    public Boolean expertIngressCardSwap(Student studentCard, Student Ingress) {
        return false;
    }

    /**
     * if the player wants to terminate an expert card effect
     * @return Boolean
     */
    public Boolean finishExpertMove() {
        return null;
    }

    /**
     * returns the possibility of playing the expert card ingress hall swap
     * @param studentHall Student
     * @param studentIngress Student
     * @return Boolean
     */
    public Boolean expertIngressHallSwap(Student studentHall, Student studentIngress) {
        return false;
    }

    /**
     * returns the possibility of playing the expert card student to hall
     * @param student Student
     * @return Boolean
     */
    public Boolean expertStudentToHall(Student student) {
       return false;
    }

    /**
     * returns the possibility of choosing students from the clouds at the end of the action round
     * @param cloud Cloud
     * @return Boolean
     */
    public Boolean chooseCloud(Cloud cloud) {
        if (this.currentPlayer.getPlayerPhase() != PlayerPhase.CHOOSING_CLOUD) {
            return false;
        }
        if (cloud.getStudents().size() == 0) {
            return false;
        }
        LinkedList<Player> players = this.game.getOrderedPlayerList();
        players.removeFirst();
        this.game.setOrderedPlayerList(players);
        return true;
    }

    /**
     * Return the number of the students moved
     * @return Integer
     */
    public Integer getStudentsMoved() {
        return this.studentsMoved;
    }

    /**
     * Checks if the player has already played an expert card
     * @return true if the player has already played an expert card
     */
    public Boolean getCardAlreadyPlayed(){
        return this.cardAlreadyPlayed;
    }

}