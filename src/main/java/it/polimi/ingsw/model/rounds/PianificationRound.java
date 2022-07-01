package it.polimi.ingsw.model.rounds;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.*;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.studentSuppliers.Cloud;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 */
public class PianificationRound implements RoundInterface, Serializable {


    /**
     * Default constructor
     */
    public PianificationRound(Game game) {
        for (Player player: game.getPlayerList()) {
            player.resetAssistantCard();
        }
        this.game = game;
        game.checkWinner();
    }

    /**
     * Contains the player list with the player sorted;
     */
    private LinkedList<Player> playerListOrdered = new LinkedList<>();

    /**
     * Contains the player list with the player sorted;
     */
    private Game game;

    /**
     * Contains the played assistantCards card sorted;
     */
    private ArrayList<AssistantCard> assistantCards=new ArrayList<AssistantCard>();

    /**
     * Check if all the player played the card and if so create the actionRound
     * @return Boolean
     */
    public Boolean checkRoundEnded() {
        if (playerListOrdered.size()==this.game.getPlayerList().size()) {
            this.game.setPlayerList(playerListOrdered);
            this.game.setOrderedPlayerList(playerListOrdered);
            assistantCards = new ArrayList<>();
            playerListOrdered = new LinkedList<>();
            this.game.getCardManager().setCurrentCard(null);
            this.game.setActionRoundState();
            return true;
        }
        return false;
    }

    /**
     * returns the possibility of moving student to hall
     * @param student Student
     * @return Boolean
     */
    public Boolean moveStudentIngressToHall(Student student) {
        return null;
    }

    /**
     * returns the possibility of moving student to island
     * @param student Student
     * @param island Island
     * @return Boolean
     */
    public Boolean moveStudentIngressToIsland(Student student, Island island) {
        return null;
    }

    /**
     * returns the possibility of moving mother nature
     * @param jumps Integer
     * @return Boolean
     */
    public Boolean moveMotherNature(Integer jumps) {
        return null;
    }


    /**
     * returns the possibility of playing an assistant card
     * @param assistantCard         id of the card;
     * @return Boolean              true if the card is not already played and false if the card is already played
     */
    public Boolean playAssistantCard(AssistantCard assistantCard, Player player) {
        if (player.getPlayerPhase()!= PlayerPhase.CHOOSING_ASSISTANT) {
            return false;
        }

        if (assistantCards.isEmpty()) {
            playerListOrdered.add(player);
            assistantCards.add(assistantCard);
            game.getCurrentPlayer().playAssistantCard(assistantCard);
            return true;
        }
        for (int i=0;i<assistantCards.size();i++) {
            if (assistantCards.get(i).getNum()==(assistantCard.getNum())) { // if the current player plays a card already played
                if (playerListOrdered.size()==2 && player.getAssistantCard().size()==2) { // if two players have already played a card and the current player has two cards
                    if (player.getAssistantCard().contains(assistantCards.get(0)) && player.getAssistantCard().contains(assistantCards.get(1))) {
                        playerListOrdered.add(player);
                        assistantCards.add(assistantCard);
                        game.getCurrentPlayer().playAssistantCard(assistantCard);
                        return true;
                    }
                }
                return false;
            }
            else if (assistantCard.getNum() < assistantCards.get(i).getNum()) {
                assistantCards.add(i+1,assistantCard);
                Collections.swap(assistantCards,i,i+1);
                playerListOrdered.add(i+1,player);
                Collections.swap(playerListOrdered,i,i+1);
                game.getCurrentPlayer().playAssistantCard(assistantCard);
                checkRoundEnded();
                return true;
            }
        }
        playerListOrdered.add(player);
        assistantCards.add(assistantCard);
        game.getCurrentPlayer().playAssistantCard(assistantCard);
        checkRoundEnded();

        return true;
    }

    /**
     * returns the possibility of playing an expert card
     * @param expertCard ExpertCard
     * @return Boolean
     */
    public Boolean playExpertCard(ExpertCard expertCard) {
        return null;
    }

    /**
     * returns the possibility of choosing deck and color
     * @param player current player
     * @param color player color
     * @param wizard wizard
     * @return Boolean
     */
    @Override
    public Boolean chooseColorAndDeck(Player player, PlayerColor color, Wizard wizard) {
        return null;
    }

    /**
     * @return round id
     */
    @Override
    public Integer getId() {
        return null;
    }

    /**
     * returns the possibility of playing student to island expert card
     * @param student Student
     * @param island Island
     * @return Boolean
     */
    public Boolean expertStudentToIsland(Student student, Island island) {
        return null;
    }

    /**
     * returns the possibility of playing ingress card swap expert card
     * @param studentCard Student
     * @param Ingress Ingress
     * @return Boolean
     */
    public Boolean expertIngressCardSwap(Student studentCard, Student Ingress) {
        return null;
    }

    /**
     * returns if the round has terminated
     * @return Boolean
     */
    public Boolean finishExpertMove() {
        return null;
    }

    /**
     * returns the possibility of playing ingress hall swap expert card
     * @param studentIngress Student
     * @param studentHall Student
     * @return Booolean
     */
    @Override
    public Boolean expertIngressHallSwap(Student studentIngress, Student studentHall) {
        return null;
    }

    /**
     * returns the possibility of playing student to hall expert card
     * @param student Student
     * @return Boolean
     */
    public Boolean expertStudentToHall(Student student) {
        return null;
    }

    /**
     * returns the possibility of choosing a cloud at the end of action round
     * @param cloud Cloud
     * @return Boolean
     */
    public Boolean chooseCloud(Cloud cloud) {
        return null;
    }

    /**
     * Return the number of the cards selected
     * @return ArrayList<Player>
     */
    public ArrayList<Player> getPlayerListOrdered() {
        return new ArrayList<Player>(this.playerListOrdered);
    }

}