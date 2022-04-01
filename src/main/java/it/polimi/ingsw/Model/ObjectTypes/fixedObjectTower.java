package Model.ObjectTypes;

import java.util.*;

/**
 * 
 */
public interface fixedObjectTower {

    /**
     * @param tower
     */
    public void addTower(Tower tower);

    /**
     * @param tower
     */
    public void removeTower(Tower tower);

    /**
     * @return
     */
    public ArrayList<Tower> getTowers();

    /**
     * @return
     */
    public Int numOfTowers();

}