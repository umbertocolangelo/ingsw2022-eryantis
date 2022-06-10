package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;

import java.io.Serializable;

public class IngressHallSwap implements Serializable,MessageMethod {

    /**
     *
     */
    private String studentIngress;

    /**
     *
     */
    private String studentHall;

    /**
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
