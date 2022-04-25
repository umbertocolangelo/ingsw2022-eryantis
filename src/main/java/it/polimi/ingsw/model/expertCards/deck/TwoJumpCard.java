package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.islands.IslandInterface;
import it.polimi.ingsw.model.islands.IslandManager;
import it.polimi.ingsw.model.pawns.Student;

/**
 * carta #4
 */
public class TwoJumpCard implements ExpertCard {

    /**
     * Default constructor
     */
    public TwoJumpCard(CardManager cardManager) {
        this.manager=cardManager;
    }

    /**
     * 
     */
    private String id;

    /**
     *
     */
    private Integer cost = 1;

    /**
     *
     */
    private CardManager manager;

    /**
     * @param currentAssistantCard is the value of current assistant card played
     * this appliance enables to move motherNature up to 2 more position and sets the new motherNature position
     */
    public void apply(Integer currentAssistantCard) {
        Integer jumps = currentAssistantCard+2;
        manager.getIslandManager().nextIsland(jumps);
        incrementCost();
    }

    /**
     * @return
     */
    public Integer getCost() {
        return this.cost;
    }

    /**
     * 
     */
    public void incrementCost() {
        cost = cost + 1;
    }

    /**
     *
     * @return
     */
    @Override
    public String getId() {
        return null;
    }

    /**
     *
     * @param id
     */
    @Override
    public void setId(String id) {

    }

}