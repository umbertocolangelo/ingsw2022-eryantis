package it.polimi.ingsw.model.objectTypes;

import it.polimi.ingsw.model.pawns.Professor;

public interface FixedObjectProfessor extends FixedObject{

    /**
     * @param professor Professor
     */
    public void addProfessor(Professor professor);

    /**
     * @param professor Professor
     */
    public void removeProfessor(Professor professor);

    /**
     * @return Boolean
     */
    public Boolean isProfessor();

}