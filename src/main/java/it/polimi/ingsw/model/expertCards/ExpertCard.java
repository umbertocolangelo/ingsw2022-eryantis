package it.polimi.ingsw.model.expertCards;

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
    public void incrementCost();

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