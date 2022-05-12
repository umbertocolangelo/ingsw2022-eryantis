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
        game.expertIngressHallSwap(studentHall,studentIngress);
    }


    public void setStudentIngress(String student){
        this.studentIngress=student;
    }

    public void setStudentHall(String studentHall){
        this.studentHall=studentHall;
    }
}
