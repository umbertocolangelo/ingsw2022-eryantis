package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.islands.IslandInterface;
import it.polimi.ingsw.model.pawns.Student;

import java.io.Serializable;

public class MovingStudentFromIngressToIsland implements MessageMethod, Serializable {

    /**
     *
     */
    private Student student;

    /**
     *
     */
    private Island island;

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
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     *
     * @param island
     */
    public void setIsland(Island island) {
        this.island = island;
    }

}
