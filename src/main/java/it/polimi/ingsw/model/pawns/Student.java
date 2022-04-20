package it.polimi.ingsw.model.pawns;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.objectTypes.FixedObject;
import it.polimi.ingsw.model.objectTypes.PlaceableObject;

/**
 * 
 */
public class Student implements PlaceableObject {

    /**
     * Default constructor
     */
    public Student(Color color){
        this.color = color;
    }

    /**
     * Indicates the color of the single student
     */
    private FixedObject position;

    /**
     * Indicates the color of the single student
     */
    private Color color;

    /**
     * 
     */
    private String id;

    /**
     * @return the color of the student
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * @return the current position of the student
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
     * @return id
     */
    public String getId() { return this.id; }

}