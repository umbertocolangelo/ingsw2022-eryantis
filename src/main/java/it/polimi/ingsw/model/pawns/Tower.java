package it.polimi.ingsw.model.pawns;

import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.objectTypes.FixedObject;
import it.polimi.ingsw.model.objectTypes.PlaceableObject;

/**
 * 
 */
public class Tower implements PlaceableObject {

    /**
     * Default constructor
     */
    public Tower(PlayerColor color) {
        this.color = color;
    }

    /**
     *
     */
    private FixedObject position;

    /**
     * 
     */
    private PlayerColor color;

    /**
     *
     */
    private String id;

    /**
     * @return color
     */
    public PlayerColor getColor() {
        return this.color;
    }

    public FixedObject getPosition() {
        return this.position;
    }

    /**
     * @param position
     * @return
     */
    public void setPosition(FixedObject position) {
        this.position = position;
    }

    /**
     *
     */
    public String getId() { return this.id; }

}