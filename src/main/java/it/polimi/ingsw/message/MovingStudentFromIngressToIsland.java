package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;

import java.io.Serializable;

public class MovingStudentFromIngressToIsland implements MessageMethod, Serializable {

    /**
     *
     */
    private String student;

    /**
     *
     */
    private String island;

    /**
     *
     * @param game
     */
    public void apply(Game game) {
        game.moveStudentIngressToIsland(student, island);
    }

    /**
     *
     * @param student
     */
    public void setStudent(String student) {
        this.student = student;
    }

    /**
     *
     * @param island
     */
    public void setIsland(String island) {
        this.island = island;
    }

}
