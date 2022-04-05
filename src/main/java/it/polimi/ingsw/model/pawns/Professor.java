package it.polimi.ingsw.model.pawns;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.objectTypes.FixedObject;
import it.polimi.ingsw.model.objectTypes.PlaceableObject;

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