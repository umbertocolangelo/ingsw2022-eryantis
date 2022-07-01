package it.polimi.ingsw.model.objectTypes;

import it.polimi.ingsw.model.pawns.Tower;
import java.util.*;

/**
 * Interface used to represent an object on witch tower pawns can stay
 */
public interface FixedObjectTower extends FixedObject{

    /**
     * @param tower the tower we want to add
     */
    void addTower(Tower tower);

    /**
     * @param tower the tower we want to remove
     */
    void removeTower(Tower tower);

    /**
     * @return towers A list of the towers
     */
    LinkedList<Tower> getTowers();

    /**
     * @return int A num of towers present
     */
    Integer numOfTowers();

}