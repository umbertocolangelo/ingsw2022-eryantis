package it.polimi.ingsw.model.rounds;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.*;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.studentSuppliers.Cloud;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Class used to represent the round used to manage the choice of color and wizard by the player
 */
public class SetUpRound implements  RoundInterface, Serializable {

    /**
     * Default constructor
     * @param game
     */
    public SetUpRound(Game game) {
        this.game = game;
        for (Wizard w : Wizard.values()) {
            wizards.add(w);
        }
        for (PlayerColor c : PlayerColor.values()) {
            colors.add(c);
        }
    }

    /**
     * wizards list
     */
    private LinkedList<Wizard> wizards = new LinkedList<>();

    /**
     * player colors list
     */
    private LinkedList<PlayerColor> colors = new LinkedList<>();

    /**
     * reference to game
     */
    private Game game;

    /**
     * ordered player list
     */
    private LinkedList<Player> playersListOrdered = new LinkedList<>();

    /**
     * check if the round has terminated
     * @return Boolean
     */
    @Override
    public Boolean checkRoundEnded() {
        if (playersListOrdered.size()==game.getPlayerList().size()) {
            System.out.println("Finisco set round");
            for (Player player : playersListOrdered) {
                player.setPlayerPhase(PlayerPhase.CHOOSING_ASSISTANT);
            }
            this.game.setPianificationRoundState();
        }
        return true;
    }

    /**
     * returns the possibility to move a student from ingress to hall
     * @param student Student
     * @return Boolean
     */
    @Override
    public Boolean moveStudentIngressToHall(Student student) {
        return null;
    }

    /**
     * returns the possibility to move a student from ingress to island
     * @param student Student
     * @param island Island
     * @return Boolean
     */
    @Override
    public Boolean moveStudentIngressToIsland(Student student, Island island) {
        return null;
    }

    /**
     * returns the possibility to move mother nature
     * @param jumps Integer
     * @return Boolean
     */
    @Override
    public Boolean moveMotherNature(Integer jumps) {
        return null;
    }

    /**
     * returns the possibility to play an assistant card
     * @param assistantCard AssistantCard
     * @param player Player
     * @return Boolean
     */
    @Override
    public Boolean playAssistantCard(AssistantCard assistantCard, Player player) {
        return null;
    }

    /**
     * returns the possibility to play an expert card
     * @param expertCard ExpertCard
     * @return Boolean
     */
    @Override
    public Boolean playExpertCard(ExpertCard expertCard) {
        return null;
    }

    /**
     * returns the possibility to play student to island expert card
     * @param student Student
     * @param island Island
     * @return Boolean
     */
    @Override
    public Boolean expertStudentToIsland(Student student, Island island) {
        return null;
    }

    /**
     * returns the possibility to play ingress card swap expert card
     * @param studentCard Student
     * @param Ingress Student
     * @return Boolean
     */
    @Override
    public Boolean expertIngressCardSwap(Student studentCard, Student Ingress) {
        return null;
    }

    /**
     * true if the player wants to terminate the effect of an expert card
     * @return Boolean
     */
    @Override
    public Boolean finishExpertMove() {
        return null;
    }

    /**
     * returns the possibility to play ingress hall swap expert card
     * @param studentHall Student
     * @param studentIngress Student
     * @return Boolean
     */
    @Override
    public Boolean expertIngressHallSwap(Student studentHall, Student studentIngress) {
        return null;
    }

    /**
     * returns the possibility to play student to hall expert card
     * @param student Student
     * @return Boolean
     */
    @Override
    public Boolean expertStudentToHall(Student student) {
        return null;
    }

    /**
     * returns the possibility to choose a cloud at the end of action round
     * @param cloud Cloud
     * @return Boolean
     */
    @Override
    public Boolean chooseCloud(Cloud cloud) {
        return null;
    }

    /**
     * returns the possibility to choose color and deck
     * @param player        The player who is choosing
     * @param color         The color we want
     * @param wizard        The wizard we want
     * @return              True if the parameters are acceptable, false instead
     */
    public Boolean chooseColorAndDeck(Player player, PlayerColor color, Wizard wizard) {
        if ( player.getPlayerPhase() != PlayerPhase.SET_UP_PHASE) {
            return false;
        }
        wizards.remove(wizard);
        colors.remove(color);
        playersListOrdered.add(player);
        System.out.println(playersListOrdered.size());
        checkRoundEnded();
        return true;
    }

    /**
     * @return round id
     */
    @Override
    public Integer getId() {
        return null;
    }

    /**
     * @return player colors available
     */
    public LinkedList<PlayerColor> getPlayerColor(){
        return this.colors;
    }

    /**
     * @return wizards available
     */
    public LinkedList<Wizard> getWizards(){
        return this.wizards;
    }

}
