package it.polimi.ingsw.model;

import it.polimi.ingsw.model.player.Player;

/**
 * 
 */
public interface GameInterface {

    /**
     * Saves the game
     */
    void saveGame();

    /**
     * @return true if every player has chosen color and deck
     */
    Boolean isStarted();

    /**
     * @param studentId is the id of the student on the ingress that is moved on the hall
     */
    void moveStudentIngressToHall(String studentId);

    /**
     * @param studentId is the id of the student on the ingress
     * @param islandId is the id of the island where the student is moved
     */
    void moveStudentIngressToIsland(String studentId, String islandId);

    /**
     * @param jumps is the number of jumps that mother nature has to do
     */
    void moveMotherNature(Integer jumps);

    /**
     * @param assistantId is the id of the assistant card to play
     */
    void playAssistantCard(String assistantId);


    /**
     * @param studentId is the id of the student we want to put on the island
     * @param islandId  is the id of the island where we want to put hte student
     */
    void expertStudentToIsland(String studentId, String islandId);

    /**
     * @param studentCardId is the id of the student on the card
     * @param studentHallId is the id of the student on the ingress
     */
    void expertIngressCardSwap(String studentCardId, String studentHallId);

    /**
     * @param studentHallId is the id of the student present in the hall
     * @param studentIngressId is the id of the student present on the ingress
     */
    void expertIngressHallSwap(String studentHallId, String studentIngressId);

    /**
     * @param studentId is the id of the student to put in the Hall
     */
    void expertStudentToHall(String studentId);

    /**
     * @param cloudId is the id of the cloud to be selected
     */
    void chooseCloud(String cloudId);

    /**
     * Used if the player wants to finish the move
     */
    void finishExpertMove();

    /**
     * @return the currentPlayer
     */
    Player getCurrentPlayer();

    /**
     * @param colorId is the id of the color chosen
     * @param wizardId is the id of the wizard chosen
     */
    void chooseColorAndDeck(String colorId, String wizardId);

    /**
     * Sets the game mode to normal
     */
    public void setNormalMode();

    /**
     * @return true if the game is in expert mode, false if in normal mode
     */
    Boolean getGameMode();




}