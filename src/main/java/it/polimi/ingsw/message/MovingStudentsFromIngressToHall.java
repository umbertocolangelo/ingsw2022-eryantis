package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.pawns.Student;

import java.io.Serializable;

public class MovingStudentsFromIngressToHall implements MessageMethod, Serializable {

    /**
     *
     */
    private Student student;

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
    public void setStudent(Student student) {
        this.student = student;
    }

}
