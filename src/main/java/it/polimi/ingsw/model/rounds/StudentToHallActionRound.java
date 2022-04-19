package it.polimi.ingsw.model.rounds;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.AssistantCard;
import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.expertCards.deck.StudentToHallCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.studentSuppliers.Cloud;

/**
 * 
 */
public class StudentToHallActionRound implements RoundInterface  {

    /**
     * Default constructor
     */
    public StudentToHallActionRound(Game game) {
        this.game=game;
    }
/**
 *
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
     * @return
     */
    @Override
    public Boolean playExpertCard(ExpertCard expertCard) {
        return null;
    }

    /**
     * @param game
     * @param color
     */
    @Override
    public void expertMoveStudentToBag(Game game, Color color) {

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
     *
     */
    @Override
    public void finishExpertMove() {

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
     * @param student   The student we want to put in the Hall
     * @return          True if the move is possible
     */
    @Override
    public Boolean expertStudentToHall(Student student) {
        this.game.getCurrentPlayer().getSchool().getHall().addStudent(student);
        //StudentToHallCard currentCard = (StudentToHallCard) this.game.getCardManager().getCurrentCard();
        //currentCard.addStudent(this.game.getBag().newStudent());
        this.game.setRound(this.game.getPreviousRound());
        return true;
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