package it.polimi.ingsw.Model.Pawns;

import it.polimi.ingsw.Model.Enumerations.Color;
import it.polimi.ingsw.Model.ObjectTypes.FixedObject;
import it.polimi.ingsw.Model.ObjectTypes.PlaceableObject;

import java.util.*;

/**
 * 
 */
public class Student implements PlaceableObject {

    /**
     * Default constructor
     */
    public Student(Color color, FixedObject position){
        this.color = color;
        this.position = position;
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

}