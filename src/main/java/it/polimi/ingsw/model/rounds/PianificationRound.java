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
        this.game=game;
        //Questo forse non necessario
        this.game.setOrderedPLayerList(new LinkedList<>());
    }

    /**
     *  Contains the player list with the player sorted;
     */
    private LinkedList<Player> playerListOrdered=new LinkedList<>();

    /**
     *  Contains the player list with the player sorted;
     */
    private Game game;

    /**
     *  Contains the assistantCards card sorted;
     */
    private ArrayList<AssistantCard> assistantCards=new ArrayList<AssistantCard>();

    /**
     *Check if all the player played the card and if so create the actionRound
     */
    public Boolean checkRoundEnded() {
        if(assistantCards.size()==this.game.getPlayerList().size()) {
            this.game.setOrderedPLayerList(playerListOrdered);
            this.game.setRound(this.game.setActionRoundState(playerListOrdered.size()+1));
            return true;
        }
        return false;
    }

    /**
     * @param student
     * @return
     */
    public Boolean moveStudentIngressToHall(Student student) {
        // TODO implement here
        return null;
    }

    /**
     * @param student
     * @param island
     * @return
     */
    public Boolean moveStudentIngressToIsland(Student student, Island island) {
        // TODO implement here
        return null;
    }

    /**
     * @param jumps
     * @return
     */
    public Boolean moveMotherNature(Integer jumps) {

        return null;
    }


    /**
     * @param assistantCard         A string that represent the id of the card;
     * @return boolean              Return true if the card is not already played and false if the card is already played
     */
    public Boolean playAssistantCard(AssistantCard assistantCard, Player player) {
        if(player.getPlayerPhase()!= PlayerPhase.CHOOSING_ASSISTANT)
            return false;
        /*String onlyInt=assistantCard.replaceAll("[^0-9]", "");
        int numOfTheCard=Integer.parseInt(onlyInt);*/
        if(assistantCards.isEmpty())
        {playerListOrdered.add(player);
            player.playAssistantCard(assistantCard);
            assistantCards.add(assistantCard);
            return true;
        }
        for(int i=0;i<assistantCards.size();i++) {
            if (assistantCards.get(i).getNum()==(assistantCard.getNum())) {
                return false;
            }
            else if (assistantCard.getNum() < assistantCards.get(i).getNum()) {
                assistantCards.add(i+1,assistantCard);
                Collections.swap(assistantCards,i,i+1);
                playerListOrdered.add(i+1,player);
                Collections.swap(playerListOrdered,i,i+1);
                player.playAssistantCard(assistantCard);
                checkRoundEnded();
                return true;
            }
        }
        assistantCards.add(assistantCard);
        playerListOrdered.add(player);
        player.playAssistantCard(assistantCard);
        checkRoundEnded();
        return true;

        /**
         * Manaca l'eccezzione se sono rimaste solo carte uguali da giocare
         * E' piu comodo tenere play assistant card qui piuttosto che in game
         */
    }

    /**
     * @param expertCard
     * @param string
     * @return
     */
    public Boolean playExpertCard(ExpertCard expertCard, String string) {
        return null;
    }


    /**
     *
     * @param game
     * @param color
     */
    public void expertMoveStudentToBag(Game game, Color color) {
        // TODO implement here
    }

    @Override
    public Boolean chooseColorAndDeck(Player player, PlayerColor color, Wizard wizard) {
        return null;
    }

    /**
     * @param student
     * @param island
     * @return
     */
    public Boolean expertStudentToIsland(Student student, Island island) {
        // TODO implement here
        return null;
    }

    /**
     * @param studentCard
     * @param Ingress
     * @return
     */
    public Boolean expertIngressCardSwap(Student studentCard, Student Ingress) {
        // TODO implement here
        return null;
    }

    /**
     *
     * @return
     */

    public Boolean finishExpertMove() {
        return null;
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
    public Boolean expertStudentToHall(Student student) {
        // TODO implement here
        return null;
    }

    /**
     * @param cloud
     * @return
     */
    public Boolean chooseCloud(Cloud cloud) {
        // TODO implement here
        return null;
    }

    /**
     * @return  ArrayList<Integer>      Return the number of the cards selected;
     */
    public ArrayList<AssistantCard> getAssistantCards() {
        return new ArrayList<AssistantCard>(this.assistantCards);
    }


    /**
     * @return  ArrayList<Player>       Return the number of the cards selected;
     */
    public ArrayList<Player> getPlayerListOrdered() {
        return new ArrayList<Player>(this.playerListOrdered);
    }

}