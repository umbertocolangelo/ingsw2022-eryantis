package it.polimi.ingsw.Model.Pawns;

import it.polimi.ingsw.Model.Enumerations.PlayerColor;
import it.polimi.ingsw.Model.ObjectTypes.FixedObject;
import it.polimi.ingsw.Model.ObjectTypes.PlaceableObject;
import java.util.*;

/**
 * 
 */
public class Tower implements PlaceableObject {

    /**
     * Default constructor
     */
    public Tower(PlayerColor color, FixedObject position) {
        this.color = color;
        this.position = position;
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
}