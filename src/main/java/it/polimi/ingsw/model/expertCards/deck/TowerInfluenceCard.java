package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.pawns.Student;

/**
 * carta #6
 */
public class TowerInfluenceCard implements ExpertCard {

    /**
     * Default constructor
     */
    public TowerInfluenceCard(CardManager cardManager) {
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
     * 
     */
    public void apply() {
        manager.getInfluenceManager().setTowerInfluence();
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
        return this.id;
    }

    /**
     *
     * @param id
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

}