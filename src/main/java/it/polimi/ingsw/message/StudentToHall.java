package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;

import java.io.Serializable;

public class StudentToHall implements Serializable, MessageMethod {

    /**
     * Student selected
     */
    private String studentToHall;

    /**
     * Applies the changes to the model
     * @param game
     */
    @Override
    public void apply(Game game) {
        game.expertStudentToHall(studentToHall);
    }

    /**
     * Sets the student from hall
     * @param student
     */
    public void setStudentToHall(String student){
        this.studentToHall = student;
    }

}
