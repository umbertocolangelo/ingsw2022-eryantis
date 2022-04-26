package it.polimi.ingsw.model.expertCards;

import it.polimi.ingsw.model.pawns.Student;

/**
 * 
 */
public interface ExpertCard {

    /**
     * @return
     */
    public Integer getCost();
    
    /**
     *
     */
    public String getId();

    /**
     *
     * @param id
     */
    public void setId(String id);
}