package it.polimi.ingsw.Model;

import java.util.*;

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
    public void startGame(Integer playerNum);

    /**
     * 
     */
    public void saveGame();

    /**
     * @return
     */
    public Boolean isStarted();

    /**
     * @param student
     */
    public void moveStudentIngressToHall(String student);

    /**
     * @param student 
     * @param island
     */
    public void moveStudentIngressToIsland(String student, String island);

    /**
     * @param jumps
     */
    public void moveMotherNature(Integer jumps);

    /**
     * @param assistantCard
     */
    public void playAssistantCard(String assistantCard);

    /**
     * @param expertCard 
     * @param parameter
     */
    public void playExpertCard(String expertCard, String parameter);

    /**
     * @param student 
     * @param island
     */
    public void expertStudentToIsland(String student, String island);

    /**
     * @param student
     */
    public void expertIngressCardSwap(String student);

    /**
     * @param studentHall 
     * @param studentIngress
     */
    void expertIngressHallSwap(String studentHall, String studentIngress);

    /**
     * @param student
     */
    void expertStudentToHall(String student);

    /**
     * @param cloud
     */
    void chooseCloud(String cloud);

    /**
     * @return
     */
    public Boolean chooseExpertMode();

    /**
     * @return
     */
    public String getCurrentPlayer();

}