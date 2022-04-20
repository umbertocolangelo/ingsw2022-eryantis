package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.islands.IslandInterface;
import it.polimi.ingsw.model.islands.IslandManager;

/**
 * carta #4
 */
public class TwoJumpCard implements ExpertCard {

    /**
     * Default constructor
     */
    public TwoJumpCard() {
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
     * this appliance enables to move motherNature up to 2 more position and sets the new motherNature position
     */
    public void apply(IslandInterface nextIsland, Integer assistantCardValue) {
        Integer jumps = assistantCardValue+2;
        manager.getIslandManager().nextIsland(manager.getMotherNature().getIsland(), nextIsland, jumps);
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

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(String id) {

    }

}