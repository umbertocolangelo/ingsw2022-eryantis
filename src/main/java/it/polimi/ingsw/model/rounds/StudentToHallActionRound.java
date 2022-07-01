package it.polimi.ingsw.model.rounds;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.AssistantCard;
import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.enumerations.Wizard;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.studentSuppliers.Cloud;

import java.io.Serializable;

/**
 * Class used to represent the round used to manage the actions a player can make after playing the expert card n.11
 */
public class StudentToHallActionRound implements RoundInterface, Serializable {

    /**
     * Default constructor
     */
    public StudentToHallActionRound(Game game) {
        this.game = game;
    }

    /**
     * Reference to game
     */
    private Game game;

    /**
     * id to know which round we are
     */
    private Integer id = 2;

    /**
     * check if the round has terminated
     * @return Boolean
     */
    @Override
    public Boolean checkRoundEnded() {
        return null;
    }

    /**
     * returns the possibility to move student to hall
     * @param student Student
     * @return Boolean
     */
    @Override
    public Boolean moveStudentIngressToHall(Student student) {
        return null;
    }

    /**
     * returns the possibility to move student to island
     * @param student
     * @param island
     * @return Boolean
     */
    @Override
    public Boolean moveStudentIngressToIsland(Student student, Island island) {
        return null;
    }

    /**
     * returns the possibility to move mother nature
     * @param jumps Integer
     * @return Boolean
     */
    @Override
    public Boolean moveMotherNature(Integer jumps) {
        return null;
    }

    /**
     * returns the possibility to play an assistant card
     * @param assistantCard AssistantCard
     * @param player Player
     * @return Boolean
     */
    @Override
    public Boolean playAssistantCard(AssistantCard assistantCard, Player player) {
        return null;
    }

    /**
     * returns the possibility to play an expert card
     * @param expertCard ExpertCard
     * @return Boolean
     */
    @Override
    public Boolean playExpertCard(ExpertCard expertCard) {
        return null;
    }

    /**
     * returns the possibility to choose color and deck
     * @param player Player
     * @param color Color
     * @param wizard Wizard
     * @return Boolean
     */
    @Override
    public Boolean chooseColorAndDeck(Player player, PlayerColor color, Wizard wizard) {
        return null;
    }

    /**
     * round id
     * @return Boolean
     */
    @Override
    public Integer getId() {
        return this.id;
    }

    /**
     * returns the possibility to play student to island expert card
     * @param student Student
     * @param island Island
     * @return Boolean
     */
    @Override
    public Boolean expertStudentToIsland(Student student, Island island) {
        return null;
    }

    /**
     * returns the possibility to play ingress card swap expert card
     * @param studentCard Student
     * @param Ingress Student
     * @return Boolean
     */
    @Override
    public Boolean expertIngressCardSwap(Student studentCard, Student Ingress) {
        return null;
    }

    /**
     * returns true if the player wants to terminate an expert card effect
     * @return Boolean
     */
    public Boolean finishExpertMove() {
        return null;
    }

    /**
     * returns the possibility to play ingress hall swap expert card
     * @param studentIngress Student
     * @param studentHall Student
     * @return Boolean
     */
    @Override
    public Boolean expertIngressHallSwap(Student studentIngress, Student studentHall) {
        return null;
    }

    /**
     * returns the possibility to play student to hall expert card
     * @param student   The student we want to put in the Hall
     * @return Boolean         True if the move is possible
     */
    @Override
    public Boolean expertStudentToHall(Student student) {
        this.game.setRound(this.game.getPreviousRound());
        return true;
    }

    /**
     * returns the possibility to choose a cloud at the end of action round
     * @param cloud Cloud
     * @return Boolean
     */
    @Override
    public Boolean chooseCloud(Cloud cloud) {
        return null;
    }

}