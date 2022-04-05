package it.polimi.ingsw.model.player.board;

import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.objectTypes.FixedObjectTower;
import it.polimi.ingsw.model.pawns.Tower;
import java.util.*;

/**
 * 
 */
public class TowerTable implements FixedObjectTower {

    /**
     *
     */
    private LinkedList<Tower> towers= new LinkedList<Tower>();

    /**
     *
     */
    private Boolean isThreePlayers=true;


    /**
     * Create the towers in the TowerTable and define their color;
     */
    public TowerTable(PlayerColor color) {
        if (isThreePlayers) {
            for (int i = 0; i <6; i++) {
                Tower tower = new Tower( color);
                towers.add(tower);
            }
        } else {
            for (int i = 0; i <8; i++) {
                Tower tower = new Tower(color);
                towers.add(tower);
            }
        }
    }


    /**
     * @return
     */
    public Boolean isThreePlayers() {
        // TODO implement here
        return null;
    }

    /**
     * @param tower         Add tower to the LinkedList
     */
    public void addTower(Tower tower) {
        if( (isThreePlayers && towers.size()<6) || (towers.size()<8 && !isThreePlayers)){
            //Metodo remove position da student
            tower.setPosition(this);
                this.towers.add(tower);
        }
    }

    /**
     * Remove tower from the LinkedList
     */
    public void removeTower(Tower tower) {
        this.towers.remove(tower);
    }

    /**
     * @return  LinkedList<Tower>       Return the list of the towers
     */
    public LinkedList<Tower> getTowers() {

        return  new LinkedList<>(this.towers);
    }

    /**
     * @return      Integer             Return the number of the towers present on this TowerTable
     */
    public Integer numOfTowers() {
        return this.towers.size();
    }

}