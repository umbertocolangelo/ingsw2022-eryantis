package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;

import java.io.Serializable;

public class MovingStudentFromIngressToIsland implements MessageMethod, Serializable {

    /**
     * Selected student
     */
    private String student;

    /**
     * Selected island
     */
    private String island;

    /**
     * Applies the changes to the model
     * @param game
     */
    public void apply(Game game) {
        game.moveStudentIngressToIsland(student, island);
    }

    /**
     * Sets the chosen student
     * @param student
     */
    public void setStudent(String student) {
        this.student = student;
    }

    /**
     * Sets the chosen island
     * @param island
     */
    public void setIsland(String island) {
        this.island = island;
    }

}
