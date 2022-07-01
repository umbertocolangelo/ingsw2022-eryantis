package it.polimi.ingsw.model.player.board;

import it.polimi.ingsw.model.enumerations.PlayerColor;

import java.io.Serializable;

/**
 * 
 */
public class  School implements Serializable {

    /**
     * Default constructor
     */
    public School(PlayerColor color, Boolean isThreePlayers) {
        this.towerTable = new TowerTable(color,isThreePlayers);
        this.ingress = new Ingress();
    }

    /**
     * reference to ingress
     */
    private Ingress ingress;

    /**
     * reference to hall
     */
    private Hall hall = new Hall();

    /**
     * reference to tower table
     */
    private TowerTable towerTable;

    /**
     * Return the ingress of this school
     * @return Ingress
     */
    public Ingress getIngress() {
       return this.ingress;
    }

    /**
     * Return th Hall of this school
     * @return Hall
     */
    public Hall getHall() {
        return this.hall;
    }

    /**
     * Return the TowerTable of this school
     * @return TowerTable
     */
    public TowerTable getTowerTable() {
        return this.towerTable;
    }

}