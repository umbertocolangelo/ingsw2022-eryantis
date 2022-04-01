package it.polimi.ingsw.Model.Islands;

import it.polimi.ingsw.Model.Enumerations.Color;
import it.polimi.ingsw.Model.Enumerations.PlayerColor;
import it.polimi.ingsw.Model.ObjectTypes.fixedObjectStudent;
import it.polimi.ingsw.Model.ObjectTypes.fixedObjectTower;
import it.polimi.ingsw.Model.Pawns.MotherNature;
import it.polimi.ingsw.Model.Pawns.Student;
import it.polimi.ingsw.Model.Pawns.Tower;
import java.util.*;


/**
 * 
 */
public class Island implements fixedObjectStudent, IslandInterface {

    /**
     * Default constructor
     */
    public Island() {
    }

    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private Collection<Student> students;

    /**
     * 
     */
    private Collection<Tower> towers;

    /**
     * 
     */
    private Island nextIsland;

    /**
     * 
     */
    private MotherNature motherNature;

    /**
     * 
     */
    private Boolean isGrouped;

    /**
     * 
     */
    private Boolean isDenied;

    /**
     * @param student
     */
    public void addStudent(Student student) {
        // TODO implement here
    }

    /**
     * @param student
     */
    public void removeStudent(Student student) {
        // TODO implement here
    }

    /**
     * @return
     */
    public ArrayList<Student> getStudents() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Integer numOfStudents() {
        // TODO implement here
        return null;
    }

    /**
     * @param tower
     */
    public void addTower(Tower tower) {
        // TODO implement here
    }

    /**
     * @param tower
     */
    public void removeTower(Tower tower) {
        // TODO implement here
    }

    /**
     * @return
     */
    public ArrayList<Tower> getTowers() {
        // TODO implement here
        return null;
    }

    /**
     * @param color 
     * @return
     */
    public Integer numOfStudents(Color color) {
        // TODO implement here
        return null;
    }

    /**
     * 
     */
    public void setDeny() {
        // TODO implement here
    }

    /**
     * 
     */
    public void removeDeny() {
        // TODO implement here
    }

    /**
     * @return
     */
    public Integer numOfTowers() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public PlayerColor influenceColor() {
        // TODO implement here
        return null;
    }

}