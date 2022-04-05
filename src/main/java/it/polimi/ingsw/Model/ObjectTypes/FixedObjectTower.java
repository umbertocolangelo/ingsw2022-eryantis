package it.polimi.ingsw.Model.ObjectTypes;

import it.polimi.ingsw.Model.Pawns.Tower;
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