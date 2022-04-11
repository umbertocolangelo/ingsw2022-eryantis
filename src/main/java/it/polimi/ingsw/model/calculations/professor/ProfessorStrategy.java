package it.polimi.ingsw.model.calculations.professor;

import it.polimi.ingsw.model.enumerations.Color;

public interface ProfessorStrategy {

    /**
     * @param a is an integer to be compared with b
     * @param b is the integer used to compare a
     * @param color is the color of the professor
     * @return a Boolean as the result of the comparison
     */
    Boolean compare(Integer a, Integer b, Color color);

}
