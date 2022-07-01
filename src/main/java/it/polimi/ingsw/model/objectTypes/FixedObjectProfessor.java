package it.polimi.ingsw.model.objectTypes;

import it.polimi.ingsw.model.pawns.Professor;

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