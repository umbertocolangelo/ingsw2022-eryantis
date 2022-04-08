package it.polimi.ingsw.model.player.board;

import it.polimi.ingsw.model.enumerations.PlayerColor;

/**
 * 
 */
public class School {

    /**
     * Default constructor
     */
    public School(PlayerColor color) {
        this.towerTable = new TowerTable(color);
    }

    /**
     * 
     */
    private Ingress ingress = new Ingress();

    /**
     * 
     */
    private Hall hall = new Hall();

    /**
     * 
     */
    private TowerTable towerTable;

    /**
     * @return Ingress      Return the ingress of this school
     */
    public Ingress getIngress() {
       return this.ingress;
    }

    /**
     * @return Hall     Return th Hall of this school
     */
    public Hall getHall() {
        return this.hall;
    }

    /**
     * @return TowerTable       Return the TowerTable of this school
     */
    public TowerTable getTowerTable() {
        return this.towerTable;
    }

}