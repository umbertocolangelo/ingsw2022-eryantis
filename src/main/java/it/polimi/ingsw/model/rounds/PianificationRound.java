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
        for(Player player: game.getPlayerList())
            player.resetAssistantCard();
        this.game=game;
        game.checkWinner();
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
     *  Contains the played assistantCards card sorted;
     */
    private ArrayList<AssistantCard> assistantCards=new ArrayList<AssistantCard>();

    /**
     *Check if all the player played the card and if so create the actionRound
     */
    public Boolean checkRoundEnded() {
        if(assistantCards.size()==this.game.getPlayerList().size()) {
            this.game.setPlayerList(playerListOrdered);
            this.game.setOrderedPLayerList(playerListOrdered);
            assistantCards=new ArrayList<>();
            playerListOrdered=new LinkedList<>();
            this.game.getCardManager().setCurrentCard(null);
            this.game.setRound(this.game.setActionRoundState());
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

        if(assistantCards.isEmpty()){
            playerListOrdered.add(player);
            assistantCards.add(assistantCard);
            game.getCurrentPlayer().playAssistantCard(assistantCard);
            return true;
        }
        for(int i=0;i<assistantCards.size();i++) {
            if (assistantCards.get(i).getNum()==(assistantCard.getNum())) { // if the current player plays a card already played
                if(playerListOrdered.size()==2 && player.getAssistantCard().size()==2){ // if two players have already played a card and the current player has two cards
                    if(player.getAssistantCard().contains(assistantCards.get(0)) && player.getAssistantCard().contains(assistantCards.get(1))){
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

        /**
         * Manaca l'eccezzione se sono rimaste solo carte uguali da giocare
         * E' piu comodo tenere play assistant card qui piuttosto che in game
         */
    }

    /**
     * @param expertCard
     * @return
     */
    public Boolean playExpertCard(ExpertCard expertCard) {
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

    @Override
    public Integer getId() {
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