package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.Player;

/**
 * carta #8
 */
public class TwoInfluenceCard implements ExpertCard {

    /**
     * Default constructor
     */
    public TwoInfluenceCard(CardManager cardManager) {
        this.manager=cardManager;
    }

    /**
     * 
     */
    private String id;

    /**
     *
     */
    private Integer cost = 2;

    /**
     *
     */
    private CardManager manager;

    /**
     * 
     */
    public void apply(Player player) {
        manager.getInfluenceManager().setTwoPointsInfluence(player);
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