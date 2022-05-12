package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;

import java.io.Serializable;

public class StudentToHall implements Serializable,MessageMethod {
    /**
     *
     */
    private String studentToHall;

    /**
     * @param game
     */
    @Override
    public void apply(Game game) {
        game.expertStudentToHall(studentToHall);
    }

    /**
     *
     * @param student
     */
    public void setStudentToHall(String student){
        this.studentToHall=student;
    }
}
