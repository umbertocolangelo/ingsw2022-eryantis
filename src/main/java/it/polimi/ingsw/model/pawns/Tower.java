package it.polimi.ingsw.model.pawns;

import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.objectTypes.FixedObject;
import it.polimi.ingsw.model.objectTypes.PlaceableObject;

import java.io.Serializable;


public class Tower implements PlaceableObject, Serializable {

    /**
     * Default constructor
     */
    public Tower(PlayerColor color) {
        this.color = color;
    }

    /**
     * tower position
     */
    private FixedObject position;

    /**
     * tower color
     */
    private PlayerColor color;

    /**
     * tower id
     */
    private String id;

    /**
     * @return tower color
     */
    public PlayerColor getColor() {
        return this.color;
    }

    /**
     * @return tower position
     */
    public FixedObject getPosition() {
        return this.position;
    }

    /**
     * sets tower position
     * @param position
     */
    public void setPosition(FixedObject position) {
        this.position = position;
    }

    /**
     * @return tower id
     */
    public String getId() { return this.id; }

}