package it.polimi.ingsw.model.calculations.professor;

import it.polimi.ingsw.model.enumerations.Color;

import java.io.Serializable;

/**
 * Standard strategy pattern of professor calculus
 */
public class StandardStrategy implements ProfessorStrategy, Serializable {

    /**
     * Default constructor
     */
    public StandardStrategy(){}

    /**
     *
     * @param a is the number of students in the current player line
     * @param b is the number of students in the line of the player compared to the current player line
     * @param color is the color of the professor
     * @return true if the number of students in the current player line is greater than the compared player line
     */
    public Boolean compare(Integer a, Integer b, Color color) {
        if (a > b) {
            return true;
        }
        return false;
    }

}
