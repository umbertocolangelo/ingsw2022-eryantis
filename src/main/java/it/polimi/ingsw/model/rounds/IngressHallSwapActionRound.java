package it.polimi.ingsw.model.rounds;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.AssistantCard;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.enumerations.Wizard;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.studentSuppliers.Cloud;

import java.io.Serializable;

/**
 * Class used to represent the round used to manage the actions a player can make after playing the expert card n.10
 */
public class IngressHallSwapActionRound implements RoundInterface, Serializable {

    /**
     * Default constructor
     */
    public IngressHallSwapActionRound(Game game) {
        this.game = game;
    }

    /**
     * Reference to game
     */
    private Game game;

    /**
     * id to know which round we are
     */
    private Integer id = 1;

    /**
     * number of students moved
     */
    private Integer studentsMoved = 0;

    /**
     * returns if the round has terminated
     * @return Boolean
     */
    @Override
    public Boolean checkRoundEnded() {
        return null;
    }

    /**
     * returns the possibility of moving student to hall
     * @param student Student
     * @return Boolean
     */
    @Override
    public Boolean moveStudentIngressToHall(Student student) {
        return null;
    }

    /**
     * returns the possibility of moving student to island
     * @param student Student
     * @param island Island
     * @return Boolean
     */
    @Override
    public Boolean moveStudentIngressToIsland(Student student, Island island) {
        return null;
    }

    /**
     * returns the possibility of moving mother nature
     * @param jumps Integer
     * @return Boolean
     */
    @Override
    public Boolean moveMotherNature(Integer jumps) {
        return null;
    }

    /**
     * returns the possibility of playing an assistant card
     * @param assistantCard AssistantCard
     * @param player current player
     * @return Boolean
     */
    @Override
    public Boolean playAssistantCard(AssistantCard assistantCard, Player player) {
        return null;
    }

    /**
     * returns the possibility of playing an expert card
     * @param expertCard ExpertCard
     * @return Boolean
     */
    @Override
    public Boolean playExpertCard(ExpertCard expertCard) {
        return null;
    }

    /**
     * returns the possibility of choosing color and deck
     * @param player current player
     * @param color PlayerColor
     * @param wizard Wizard
     * @return Boolean
     */
    @Override
    public Boolean chooseColorAndDeck(Player player, PlayerColor color, Wizard wizard) {
        return null;
    }

    /**
     * @return round id
     */
    @Override
    public Integer getId() {
        return this.id;
    }

    /**
     * returns the possibility of playing expert card student to island
     * @param student Student
     * @param island Island
     * @return Boolean
     */
    @Override
    public Boolean expertStudentToIsland(Student student, Island island) {
        return null;
    }

    /**
     * returns the possibility of playing expert card ingress card swap
     * @param studentCard Student
     * @param Ingress Ingress
     * @return Boolean
     */
    @Override
    public Boolean expertIngressCardSwap(Student studentCard, Student Ingress) {
        return null;
    }

    /**
     * Called by the controller if the player wants to terminate the move
     * @return
     */
    public Boolean finishExpertMove() {
        return true;
    }

    /**
     * returns the possibility of playing expert card ingress hall swap
     * @param studentHall The student present in the hall
     * @param studentIngress The student present in the Ingress
     * @return True if the move is possible
     */
    @Override
    public Boolean expertIngressHallSwap(Student studentHall, Student studentIngress) {
        studentsMoved++;
        return true;
    }

    /**
     * returns the possibility of playing expert card student to hall
     * @param student Student
     * @return Boolean
     */
    @Override
    public Boolean expertStudentToHall(Student student) {
        return null;
    }

    /**
     * returns the possibility of choosing the cloud at the end of action round
     * @param cloud Cloud
     * @return Boolean
     */
    @Override
    public Boolean chooseCloud(Cloud cloud) {
        return null;
    }

    /**
     * @return students moved
     */
    public Integer getStudent(){
        return studentsMoved;
    }
}