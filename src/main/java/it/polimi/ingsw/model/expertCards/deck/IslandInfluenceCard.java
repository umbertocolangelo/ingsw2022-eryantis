package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.pawns.Student;

/**
 * carta #3
 */
public class IslandInfluenceCard implements ExpertCard {

    /**
     * Default constructor
     */
    public IslandInfluenceCard(CardManager cardManager) {
        this.manager=cardManager;
    }

    /**
     * 
     */
    private String id;

    /**
     *
     */
    private Integer cost = 3;

    /**
     *
     */
    private CardManager manager;

    /**
     * @param island
     */
    public void apply(Island island) {
        manager.getInfluenceManager().setIslandInfluence(island);
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
    private void incrementCost() {
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