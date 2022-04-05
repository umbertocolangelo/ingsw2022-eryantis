package it.polimi.ingsw.model.objectTypes;

import it.polimi.ingsw.model.pawns.Tower;
import java.util.*;

/**
 * 
 */
public interface FixedObjectTower extends FixedObject{

    /**
     * @param tower
     */
    public void addTower(Tower tower);

    /**
     *
     */
    public void removeTower(Tower tower);

    /**
     * @return
     */
    public LinkedList<Tower> getTowers();

    /**
     * @return
     */
    public Integer numOfTowers();

}