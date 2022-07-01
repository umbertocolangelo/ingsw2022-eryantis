package it.polimi.ingsw.model.objectTypes;

import it.polimi.ingsw.model.pawns.Tower;
import java.util.*;


public interface FixedObjectTower extends FixedObject{

    /**
     * @param tower the tower we want to add
     */
    public void addTower(Tower tower);

    /**
     * @param tower the tower we want to remove
     */
    public void removeTower(Tower tower);

    /**
     * @return towers A list of the towers
     */
    public LinkedList<Tower> getTowers();

    /**
     * @return int A num of towers present
     */
    public Integer numOfTowers();

}