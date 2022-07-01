package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;

import java.io.Serializable;

public class IngressHallSwap implements Serializable,MessageMethod {

    /**
     * Reference to ingress student
     */
    private String studentIngress;

    /**
     * Reference to hall student
     */
    private String studentHall;

    /**
     * Appliance of the changes to the model
     * @param game
     */
    @Override
    public void apply(Game game) {
        game.expertIngressHallSwap(studentHall, studentIngress);
    }

    /**
     * Sets student from ingress
     * @param student
     */
    public void setStudentIngress(String student){
        this.studentIngress = student;
    }

    /**
     * Sets student from hall
     * @param studentHall
     */
    public void setStudentHall(String studentHall){
        this.studentHall = studentHall;
    }

}
