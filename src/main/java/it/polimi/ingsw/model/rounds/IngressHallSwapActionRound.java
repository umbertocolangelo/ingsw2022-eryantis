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
 * 
 */
public class IngressHallSwapActionRound implements RoundInterface, Serializable {

    /**
     * Default constructor
     */
    public IngressHallSwapActionRound(Game game) {
        this.game=game;
    }
    /**
     *
     */
    Game game;

    /**
     * Id to know which round we are
     */
    private Integer id=1;

    /**
     *
     */
    Integer studentsMoved=0;


    @Override
    public Boolean checkRoundEnded() {
        return null;
    }

    /**
     * @param student
     * @return
     */
    @Override
    public Boolean moveStudentIngressToHall(Student student) {
        return null;
    }

    /**
     * @param student
     * @param island
     * @return
     */
    @Override
    public Boolean moveStudentIngressToIsland(Student student, Island island) {
        return null;
    }

    /**
     * @param jumps
     * @return
     */
    @Override
    public Boolean moveMotherNature(Integer jumps) {
        return null;
    }

    /**
     * @param assistantCard
     * @param player
     * @return
     */
    @Override
    public Boolean playAssistantCard(AssistantCard assistantCard, Player player) {
        return null;
    }

    /**
     * @param expertCard
     * @return
     */
    @Override
    public Boolean playExpertCard(ExpertCard expertCard) {
        return null;
    }


    @Override
    public Boolean chooseColorAndDeck(Player player, PlayerColor color, Wizard wizard) {
        return null;
    }

    @Override
    public Integer getId() {
        return id;
    }

    /**
     * @param student
     * @param island
     * @return
     */
    @Override
    public Boolean expertStudentToIsland(Student student, Island island) {
        return null;
    }

    /**
     * @param studentCard
     * @param Ingress
     * @return
     */
    @Override
    public Boolean expertIngressCardSwap(Student studentCard, Student Ingress) {
        return null;
    }

    /**
     *Called by the controller if he wants to terminate the move
     * @return
     */

    public Boolean finishExpertMove() {
        studentsMoved=0;
        this.game.getCardManager().setCurrentCard(null);
        this.game.setRound(this.game.getPreviousRound());
        return true;
    }

    /**
     * @param studentHall       The student present in the hall
     * @param studentIngress    The student present in the Ingress
     * @return                  True if the move is possible
     */
    @Override
    public Boolean expertIngressHallSwap(Student studentHall, Student studentIngress) {
        studentsMoved++;
        if(studentsMoved==2){
            return finishExpertMove();
        }
    return true;
    }

    /**
     * @param student
     * @return
     */
    @Override
    public Boolean expertStudentToHall(Student student) {
        return null;
    }


    /**
     * @param cloud
     * @return
     */
    @Override
    public Boolean chooseCloud(Cloud cloud) {
        return null;
    }
}