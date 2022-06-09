package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;

import java.io.Serializable;

public class StudentToIsland implements Serializable, MessageMethod {

    /**
     * Student selected
     */
    private String student;

    /**
     * Island selected
     */
    private String island;

    /**
     * Applies the changes to the model
     * @param game
     */
    @Override
    public void apply(Game game) {
        game.expertStudentToIsland(student, island);
    }

    /**
     * Sets student
     * @param student
     */
    public void setStudent(String student){
        this.student = student;
    }

    /**
     * Sets island
     * @param island
     */
    public void setIsland(String island){
        this.island = island;
    }

}
