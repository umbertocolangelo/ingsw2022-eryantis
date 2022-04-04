package it.polimi.ingsw.Model.Pawns;

import it.polimi.ingsw.Model.Enumerations.Color;
import java.util.*;

/**
 * 
 */
public class Professor extends ColoredPawn {

    /**
     * Default constructor
     */
    public Professor(Color color) {
        this.color=color;
    }

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
}