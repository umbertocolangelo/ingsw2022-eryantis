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
    public void incrementCost();

    /**
     *
     */
    public String getId();
    /**
     *
     */
    public void removeStudent(Student student);

    /**
     *
     */
    public void addStudent(Student student);

    /**
     *
     * @param id
     */
    public void setId(String id);
}