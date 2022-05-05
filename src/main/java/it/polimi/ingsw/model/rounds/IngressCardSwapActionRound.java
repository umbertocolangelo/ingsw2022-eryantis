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
 * 
 */
public class IngressCardSwapActionRound  implements RoundInterface, Serializable {

    /**
     * Default constructor
     */
    public IngressCardSwapActionRound(Game game) {
        this.game=game;
    }

    /**
     *
     */
    private Integer studentsMoved=0;

    /**
     * Mantain the reference to Game
     */
    private Game game;

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
     * @param string
     * @return
     */
    @Override
    public Boolean playExpertCard(ExpertCard expertCard, String string) {
        return null;
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
     * @param studentCard       The student present on the Card
     * @param Ingress           The student present in the ingress
     * @return                  True if the students is moved
     */
    @Override
    public Boolean expertIngressCardSwap(Student studentCard, Student Ingress) {

        studentsMoved++;
        if(studentsMoved==3){
            return finishExpertMove();
        }
        return true;


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
     * @param student
     * @param student1
     */
    @Override
    public Boolean expertIngressHallSwap(Student student, Student student1) {
        return null;
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



    private void expertMoveStudentToBag(Game game, Color color) {

    }

    @Override
    public Boolean chooseColorAndDeck(Player player, PlayerColor color, Wizard wizard) {
        return null;
    }
}