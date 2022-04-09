package it.polimi.ingsw.model.calculations.professor;

public interface ProfessorStrategy {

    /**
     * @param a is an integer to be compared with b
     * @param b is the integer used to compare a
     * @return a Boolean as the result of the comparison
     */
    Boolean compare(Integer a, Integer b);

}
