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

public class IngressCardSwapActionRound  implements RoundInterface, Serializable {

    /**
     * Default constructor
     */
    public IngressCardSwapActionRound(Game game) {
        this.game = game;
    }

    /**
     * round id
     */
    private Integer id = 0;

    /**
     * Number of students moved
     */
    private Integer studentsMoved = 0;

    /**
     * Reference to game
     */
    private Game game;

    /**
     * if the round has terminated
     * @return Boolean
     */
    @Override
    public Boolean checkRoundEnded() {
        return null;
    }

    /**
     * returns the possibility of moving the student from ingress to hall
     * @param student Student
     * @return Boolean
     */
    @Override
    public Boolean moveStudentIngressToHall(Student student) {
    return null;
    }

    /**
     * returns the possibility of moving the student from ingress to island
     * @param student in the ingress
     * @param island where to put the student on
     * @return Boolean
     */
    @Override
    public Boolean moveStudentIngressToIsland(Student student, Island island) {
        return null;
    }

    /**
     * returns the possibility of moving mother nature
     * @param jumps Integer
     * @return  Boolean
     */
    @Override
    public Boolean moveMotherNature(Integer jumps) {
        return null;
    }

    /**
     * returns the possibility of playing an assistant card
     * @param assistantCard AssistantCard
     * @param player Player
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
     * @param studentCard The student present on the Card
     * @param Ingress The student present in the ingress
     * @return True if the students is moved
     */
    @Override
    public Boolean expertIngressCardSwap(Student studentCard, Student Ingress) {
        studentsMoved++;
        return true;
    }

    /**
     * Called by the controller if the player wants to terminate the move
     * @return
     */
    public Boolean finishExpertMove() {
        studentsMoved = 0;
        return true;
    }

    /**
     * returns the possibility of playing expert card ingress hall swap
     * @param studentIngress Student
     * @param studentHall Student
     * @return Boolean
     */
    @Override
    public Boolean expertIngressHallSwap(Student studentIngress, Student studentHall) {
        return null;
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
     * returns the possibility of choosing the cloud at the end of action phase
     * @param cloud Cloud
     * @return Boolean
     */
    @Override
    public Boolean chooseCloud(Cloud cloud) {
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
     * @return students moved
     */
    public Integer getStudentsMoved() {
        return this.studentsMoved;
    }
}