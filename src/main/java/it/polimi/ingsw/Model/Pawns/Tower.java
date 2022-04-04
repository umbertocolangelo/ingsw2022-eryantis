package it.polimi.ingsw.Model.Pawns;

import it.polimi.ingsw.Model.Enumerations.PlayerColor;
import it.polimi.ingsw.Model.ObjectTypes.PlaceableObject;
import java.util.*;

/**
 * 
 */
public class Tower extends PlaceableObject {

    /**
     * Default constructor
     */
    public Tower(PlayerColor color) {
        this.color = color;
    }

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

}