package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.rounds.RoundInterface;

/**
 * carta #10
 */
public class IngressHallSwapCard implements ExpertCard {

    /**
     * Default constructor
     */
    public IngressHallSwapCard() {
    }

    /**
     * carta #10
     */
    private Integer cost = 1;

    /**
     * 
     */
    private String id;

    /**
     *
     */
    private CardManager manager;

    /**
     *
     */
    private RoundInterface round;

    /**
     * 
     */
    public void apply(Student studentHall, Student studentIngress) {
        round.expertIngressHallSwap(studentHall, studentIngress);
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