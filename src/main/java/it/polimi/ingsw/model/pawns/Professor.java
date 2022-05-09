package it.polimi.ingsw.model.pawns;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.objectTypes.FixedObject;
import it.polimi.ingsw.model.objectTypes.PlaceableObject;
import it.polimi.ingsw.utils.IdManager;

import java.io.Serializable;

/**
 * 
 */
public class Professor implements PlaceableObject, Serializable {

    /**
     * Returns the unique instance of the professor for the choosen color
     */
    public static Professor getProfessor(Color color) {
        if (professors[color.ordinal()] == null) {
            professors[color.ordinal()] = new Professor(color);
            return professors[color.ordinal()];
        }
        return professors[color.ordinal()];
    }
    /**
     * Private constructor
     */
    private Professor(Color color) {
            this.color=color;

    }

    /**
     * Stores the five unique instances of professor
     */
    private static Professor[] professors = new Professor[5];

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

    /**
     *
     */
    public String getId() { return this.id; }

}