package it.polimi.ingsw.model.player.board;

import it.polimi.ingsw.model.enumerations.PlayerColor;

import java.io.Serializable;

/**
 * 
 */
public class School implements Serializable {

    /**
     * Default constructor
     */
    public School(PlayerColor color, Boolean isThreePlayers) {
        this.towerTable=new TowerTable(color,isThreePlayers);
        this.ingress =new Ingress();
    }

    /**
     * 
     */
    private Ingress ingress;

    /**
     * 
     */
    private Hall hall=new Hall();

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