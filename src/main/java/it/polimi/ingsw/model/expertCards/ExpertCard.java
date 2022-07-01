package it.polimi.ingsw.model.expertCards;

import it.polimi.ingsw.model.pawns.Student;


/**
 * Interface of expert cards
 */
public interface ExpertCard {

    /**
     * @return card cost
     */
    public Integer getCost();

    /**
     * @return card id
     */
    public String getId();

}