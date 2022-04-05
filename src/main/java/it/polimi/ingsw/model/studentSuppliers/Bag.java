package it.polimi.ingsw.model.studentSuppliers;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.board.Ingress;

/**
 * 
 */
public class Bag {

    /**
     * Default constructor
     */
    public Bag() {
    }

    /**
     * 
     */
    private Integer yellowStudentsNum;

    /**
     * 
     */
    private Integer blueStudentsNum;

    /**
     * 
     */
    private Integer greenStudentsNum;

    /**
     * 
     */
    private Integer redStudentsNum;

    /**
     * 
     */
    private Integer pinkStudentsNum;

    /**
     * 
     */
    private String id;

    /**
     * @return
     */
    public Student newStudent() {
        // TODO implement here
        return null;
    }

    /**
     * @param island
     */
    public void addStudentsOnIsland(Island island) {
        // TODO implement here
    }

    /**
     * @param cloud
     */
    public void addStudentsOnCloud(Cloud cloud) {
        // TODO implement here
    }

    /**
     * @param ingress
     */
    public void addStudentOnIngress(Ingress ingress) {
        // TODO implement here
    }

    /**
     * @param color
     */
    public void reinsertStudent(Color color) {
        // TODO implement here
    }

    /**
     * @param expertCard
     */
    public void addStudentOnCard(ExpertCard expertCard) {
        // TODO implement here
    }

}