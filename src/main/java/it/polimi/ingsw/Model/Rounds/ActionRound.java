package it.polimi.ingsw.Model.Rounds;

import it.polimi.ingsw.Model.Pawns.Student;
import it.polimi.ingsw.Model.Player.Player;

import java.util.*;

/**
 * 
 */
public class ActionRound implements RoundInterface {

    /**
     * Default constructor
     */
    public ActionRound() {
    }

    /**
     * 
     */
    private Integer nextPlayer;

    /**
     * 
     */
    private Integer currentPlayer;

    /**
     * 
     */
    private Integer studentsMoved;

    /**
     * 
     */
    public ArrayList<Player> orderedPlayerList;

    /**
     * 
     */
    private void checkWinner() {
        // TODO implement here
    }

    /**
     * 
     */
    private void setPianificationRound() {
        // TODO implement here
    }

    /**
     * 
     */
    private void setActionRound() {
        // TODO implement here
    }

    /**
     * @param student 
     * @return
     */
    public Boolean moveStudentIngressToHall(String student) {
        // TODO implement here
        return null;
    }

    /**
     * @param student 
     * @param island 
     * @return
     */
    public Boolean moveStudentIngressToIsland(String student, String island) {
        // TODO implement here
        return null;
    }

    /**
     * @param jumps 
     * @return
     */
    public Boolean moveMotherNature(Integer jumps) {
        // TODO implement here
        return null;
    }

    /**
     * @param assistantCard 
     * @return
     */
    public Boolean playAssistantCard(String assistantCard) {
        // TODO implement here
        return null;
    }

    /**
     * @param expertCard 
     * @param parameter 
     * @return
     */
    public Boolean playExpertCard(String expertCard, Object parameter) {
        // TODO implement here
        return null;
    }

    /**
     * @param student 
     * @return
     */
    public Boolean moveStudentToBag(Student student) {
        // TODO implement here
        return null;
    }

    /**
     * @param student 
     * @param island 
     * @return
     */
    public Boolean expertStudentToIsland(String student, String island) {
        // TODO implement here
        return null;
    }

    /**
     * @param student 
     * @return
     */
    public Boolean expertIngressCardSwap(Student student) {
        // TODO implement here
        return null;
    }

    /**
     * @param studentHall 
     * @param studentIngress 
     * @return
     */
    public Boolean expertIngressHallSwap(String studentHall, String studentIngress) {
        // TODO implement here
        return null;
    }

    /**
     * @param student 
     * @return
     */
    public Boolean expertStudentToHall(String student) {
        // TODO implement here
        return null;
    }

    /**
     * @param cloud 
     * @return
     */
    public Boolean chooseCloud(String cloud) {
        // TODO implement here
        return null;
    }

}