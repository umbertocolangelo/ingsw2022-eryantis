package it.polimi.ingsw.Model.Pawns;

import it.polimi.ingsw.Model.Enumerations.Color;
import it.polimi.ingsw.Model.ObjectTypes.FixedObject;
import it.polimi.ingsw.Model.ObjectTypes.PlaceableObject;

import java.util.*;

/**
 * 
 */
public class Professor implements PlaceableObject {

    /**
     * Default constructor
     */
    public Professor(Color color) {
        this.color=color;
    }

    /**
     * Indicates the color of the single student
     */
    private FixedObject position;

    /**
     * 
     */
    private Color color;

    /**
     * 
     */
    private String id;

    /**
     * @return color
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * @return the current position of the professor
     */
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