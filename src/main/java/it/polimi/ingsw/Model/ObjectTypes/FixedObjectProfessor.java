package it.polimi.ingsw.Model.ObjectTypes;

import it.polimi.ingsw.Model.Pawns.Professor;

/**
 * 
 */
public interface FixedObjectProfessor extends FixedObject{

    /**
     * @param professor
     */
    public void addProfessor(Professor professor);

    /**
     * @param professor
     */
    public void removeProfessor(Professor professor);

    /**
     * @return
     */
    public Boolean isProfessor();

}