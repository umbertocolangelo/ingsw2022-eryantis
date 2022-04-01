package it.polimi.ingsw.Model.ObjectTypes;

import it.polimi.ingsw.Model.Pawns.Tower;

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
    public Integer numOfTowers();

}