package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;

import java.io.Serializable;

public class IngressCardSwap implements Serializable, MessageMethod {

    /**
     * Student on the expert card selected
     */
    private String studentCard;

    /**
     * Student in the hall selcted
     */
    private String studentHall;

    /**
     * Applies the change to the model
     * @param game
     */
    @Override
    public void apply(Game game) {
        game.expertIngressCardSwap(studentCard, studentHall);
    }

    /**
     * Sets the student from the expert card
     * @param student
     */
    public void setStudentCard(String student){
        this.studentCard = student;
    }

    /**
     * Sets the student from the hall
     * @param studentHall
     */
    public void setStudentIngress(String studentHall){
        this.studentHall = studentHall;
    }
}
