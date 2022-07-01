package it.polimi.ingsw.model.rounds;

import it.polimi.ingsw.model.enumerations.AssistantCard;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.enumerations.Wizard;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.studentSuppliers.Cloud;

/**
 * Interface used to define every method for which a round can answer (with a boolean) to express the possibility of making
 * a specific action in the game
 */
public interface RoundInterface {

    /**
     * returns true if the round has terminated
     * @return boolean
     */
    public Boolean checkRoundEnded();

    /**
     * returns true if is possible to move a student from ingress to hall
     * @param student student
     * @return boolean true if the move can be done, false otherwise
     */
    public Boolean moveStudentIngressToHall(Student student);

    /**
     * returns true if is possible to move a student from ingress to island
     * @param student student
     * @param island island
     * @return boolean
     */
    public Boolean moveStudentIngressToIsland(Student student, Island island);

    /**
     * returns true if is possible to move mother nature
     * @param jumps integer
     * @return boolean
     */
    public Boolean moveMotherNature(Integer jumps);

    /**
     * returns true if is possible to play an assistant card
     * @param assistantCard assistant card
     * @param player player
     * @return boolean
     */
    public Boolean playAssistantCard(AssistantCard assistantCard, Player player);

    /**
     * returns true if is possible to play an expert card
     * @param expertCard expert card
     * @return boolean
     */
    public Boolean playExpertCard(ExpertCard expertCard);

    /**
     * returns true if is possible to play student to island expert card
     * @param student student
     * @param island island
     * @return boolean
     */
    public Boolean expertStudentToIsland(Student student, Island island);

    /**
     * returns true if is possible to play ingress card swop expert card
     * @param studentCard student
     * @param Ingress student
     * @return boolean
     */
    public Boolean expertIngressCardSwap(Student studentCard, Student Ingress);

    /**
     * returns true if the player wants to terminate an expert card effect
     * @return boolean
     */
    public Boolean finishExpertMove();

    /**
     * returns true if is possible to play ingress hall swap expert card
     * @param studentHall student
     * @param studentIngress student
     * @return boolean
     */
    public Boolean expertIngressHallSwap(Student studentHall, Student studentIngress);

    /**
     * returns true if is possible to play student to hall expert card
     * @param student student
     * @return boolean
     */
    public Boolean expertStudentToHall(Student student);

    /**
     * returns true if is possible to choose a cloud at the end of action round
     * @param cloud cloud
     * @return boolean
     */
    public Boolean chooseCloud(Cloud cloud);

    /**
     * returns true if is possible to choose a color and deck
     * @param player player
     * @param color color
     * @param wizard wizard
     * @return boolean
     */
    public Boolean chooseColorAndDeck(Player player, PlayerColor color, Wizard wizard);

    /**
     *
     * @return int The id of the round
     */
    Integer getId();

}