package Model.ObjectTypes;

import java.util.*;

/**
 * 
 */
public interface fixedObjectProfessor {

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