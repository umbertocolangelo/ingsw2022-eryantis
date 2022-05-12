package it.polimi.ingsw.model;

import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.enumerations.Wizard;
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
    public void playAssistantCard(String assistantCard);


    /**
     * @param student
     * @param island
     */
    public void expertStudentToIsland(String student, String island);

    /**
     * @param student1
     * @param student2
     */
    public void expertIngressCardSwap(String student1, String student2);

    /**
     * @param studentHall1
     * @param studentIngress1
     */
    void expertIngressHallSwap(String studentHall1, String studentIngress1);

    /**
     * @param student1
     */
    void expertStudentToHall(String student1);

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