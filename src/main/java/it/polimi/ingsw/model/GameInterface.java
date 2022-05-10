package it.polimi.ingsw.model;

import it.polimi.ingsw.model.enumerations.AssistantCard;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.enumerations.Wizard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.studentSuppliers.Cloud;

import java.util.LinkedList;

/**
 * 
 */
public interface GameInterface {

    /**
     * @param name 
     * @param playerNum
     */
    public void playerLogin(String name, Integer playerNum);

    /**
     * @param playerNum
     */
    public void startGame(LinkedList<Player> playerNum);

    /**
     * 
     */
    public void saveGame();

    /**
     * @return
     */
    public Boolean isStarted();

    /**
     * @param string
     */
    public void moveStudentIngressToHall(String string);

    /**
     * @param student1
     * @param island1
     */
    public void moveStudentIngressToIsland(String student1, String island1);

    /**
     * @param jumps
     */
    public void moveMotherNature(Integer jumps);

    /**
     * @param assistantCard
     */
    public void playAssistantCard(AssistantCard assistantCard);


    /**
     * @param student
     * @param island
     */
    public void expertStudentToIsland(Student student, Island island);

    /**
     * @param studentCard
     * @param studentIngress
     */
    public void expertIngressCardSwap(Student studentCard, Student studentIngress);

    /**
     * @param studentHall
     * @param studentIngress
     */
    void expertIngressHallSwap(Student studentHall, Student studentIngress);

    /**
     * @param student
     */
    void expertStudentToHall(Student student);

    /**
     * @param cloud
     */
    void chooseCloud(Cloud cloud);

    public void finishExpertMove();


    /**
     * @return
     */
    public void setExpertMode();

    /**
     * @return
     */
    public Player getCurrentPlayer();

    /**
     *
     * @param color
     * @param wizard
     * @return
     */
    public Boolean chooseColorAndDeck(PlayerColor color, Wizard wizard);

}