package it.polimi.ingsw.model.player.board;

import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.objectTypes.FixedObjectTower;
import it.polimi.ingsw.model.pawns.Tower;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * 
 */
public class TowerTable implements FixedObjectTower, Serializable {

    /**
     *
     */
    private LinkedList<Tower> towers= new LinkedList<Tower>();

    /**
     *
     */
    private Boolean isThreePlayers;


    /**
     * Create the towers in the TowerTable and define their color;
     */
    public TowerTable(PlayerColor color, Boolean isThreePlayers) {
        if (isThreePlayers) {
            for (int i = 0; i <6; i++) {
                Tower tower = new Tower( color);
                towers.add(tower);
                tower.setPosition(this);
            }
        } else {
            for (int i = 0; i <8; i++) {
                Tower tower = new Tower(color);
                towers.add(tower);
                tower.setPosition(this);
            }
        }
        this.isThreePlayers = isThreePlayers;
    }


    /**
     * @param tower         Add tower to the LinkedList
     */
    public void addTower(Tower tower) {
        if( (isThreePlayers && towers.size()<6) || (towers.size()<8 && !isThreePlayers)){
            if(tower.getPosition()!=null){        // If the tower was on a FixedObject, this object is updated
                FixedObjectTower position = (FixedObjectTower) tower.getPosition();
                position.removeTower(tower);
            }
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