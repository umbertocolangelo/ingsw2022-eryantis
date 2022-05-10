package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;

import java.io.Serializable;

public class MovingStudentsFromIngressToHall implements MessageMethod, Serializable {

    /**
     *
     */
    private String student;

    /**
     *
     * @param game
     */
    public void apply(Game game) {
        game.moveStudentIngressToHall(student);
    }

    /**
     *
     * @param student
     */
    public void setStudent(String student) {
        this.student = student;
    }

}
