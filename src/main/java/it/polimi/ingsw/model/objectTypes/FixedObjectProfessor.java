package it.polimi.ingsw.model.objectTypes;

import it.polimi.ingsw.model.pawns.Professor;

/**
 * Interface used to represent an object on witch professor pawns can stay
 */
public interface FixedObjectProfessor extends FixedObject{

    /**
     * @param professor Professor
     */
    void addProfessor(Professor professor);

    /**
     * @param professor Professor
     */
    void removeProfessor(Professor professor);

    /**
     * @return Boolean
     */
    Boolean isProfessor();

}