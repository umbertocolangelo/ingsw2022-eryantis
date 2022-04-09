package it.polimi.ingsw.model.calculations.professor;

public class EqualStrategy implements ProfessorStrategy{

    /**
     * Default constructor
     */
    public EqualStrategy(){}

    /**
     *
     * @param a is the number of students in the current player line
     * @param b is the number of students in the line of the player compared to the current player line
     * @return true if the number of students in the current player line is greater or equal than the compared player line
     */
    public Boolean compare(Integer a, Integer b) {
        if(a >= b){return true;};
        return false;
    }
}