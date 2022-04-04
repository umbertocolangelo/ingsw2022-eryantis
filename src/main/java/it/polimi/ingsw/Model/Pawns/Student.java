package it.polimi.ingsw.Model.Pawns;

import it.polimi.ingsw.Model.Enumerations.Color;
import java.util.*;

/**
 * 
 */
public class Student extends ColoredPawn {

    /**
     * Default constructor
     */
    public Student(Color color) {
        this.color = color;
    }

    /**
     * Indicates the color of the single student
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

}