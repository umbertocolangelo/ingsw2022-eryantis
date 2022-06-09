package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;

import java.io.Serializable;

public class MovingStudentsFromIngressToHall implements MessageMethod, Serializable {

    /**
     * Student selected
     */
    private String student;

    /**
     * Applies the changes to the model
     * @param game
     */
    public void apply(Game game) {
        game.moveStudentIngressToHall(student);
    }

    /**
     * Sets the student
     * @param student
     */
    public void setStudent(String student) {
        this.student = student;
    }



}
