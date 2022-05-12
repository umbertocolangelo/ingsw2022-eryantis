package it.polimi.ingsw.model.islands;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.objectTypes.FixedObjectStudent;
import it.polimi.ingsw.model.objectTypes.FixedObjectTower;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.pawns.Tower;
import it.polimi.ingsw.utils.IdManager;

import java.io.Serializable;
import java.util.LinkedList;


/**
 *
 */
public class Island implements FixedObjectStudent, FixedObjectTower, IslandInterface, Serializable {

    /**
     * Default constructor
     */
    public Island() {
        this.id = idCounter.toString();
        IdManager.getInstance().addIsland(this);
        idCounter++;
        if(idCounter==38){idCounter=26;}
    }

    /**
     * Stores the current available id
     */
    private static Integer idCounter = 26;

    /**
     *
     */
    private String id;

    /**
     *
     */
    private LinkedList<Student> students = new LinkedList<Student>();

    /**
     *
     */
    private LinkedList<Tower> towers = new LinkedList<Tower>();

    /**
     *
     */
    private Boolean isGrouped = false;

    /**
     * Stores the number of deny tokens on the island
     */
    private Integer denyTokens = 0;

    /**
     *
     */
    private Integer size = 1;

    /**
     * @param student   Add the student to the LinkedList
     */

    public void addStudent(Student student) {
        if (!this.students.contains(student)) {
            if(student.getPosition()!=null){        // If the student was on a FixedObject, this object is updated
                FixedObjectStudent position = (FixedObjectStudent) student.getPosition();
                position.removeStudent(student);
            }
            student.setPosition(this);
            this.students.add(student);
        }
    }

    /**
     * @param student       Remove the student from the LinkedList
     */
    public void removeStudent(Student student) {
        if (this.students.contains(student)) {
            this.students.remove(this.students.indexOf(student));
        }
    }

    /**
     * @return LinkedList<Student>      Return the LinkedList<Student>
     */
    public LinkedList<Student> getStudents() {
        return new LinkedList<Student>(this.students);
    }

    /**
     * @return Integer      Return the Number of student
     */
    public Integer numOfStudents() {
        return this.students.size();
    }

    /**
     * @param tower     Add Tower to the LinkedList
     */
    public void addTower(Tower tower) {
        if(towers.size()==0) {
            if (tower.getPosition() != null) {        // If the tower was on a FixedObject, this object is updated
                FixedObjectTower position = (FixedObjectTower) tower.getPosition();
                position.removeTower(tower);
            }
            tower.setPosition(this);
            this.towers.add(tower);
        }
    }

    /**
     *    Remove tower from the LinkedList
     */
    public void removeTower(Tower tower) {
        this.towers.remove(0);

    }

    /**
     * @return LinkedList<Tower>        Return the LinkedList of Towers
     */
    public LinkedList<Tower> getTowers() {
        if (this.towers.isEmpty())
            return null;
        else
            return this.towers;
    }

    /**
     * @param color
     * @return Integer      Return the number of student who by color
     */
    public Integer numOfStudents(Color color) {
        int counter = 0;
        for (Student s: students )
        {
            if(s.getColor()==color){
                counter++;
            }
        }
        return counter;
    }

    /**
     * Adds one deny token to the island
     */
    public void setDeny() { denyTokens++; }

    /**
     * @return the number of denyTokens on the island
     */
    public Integer getDeny(){
        return denyTokens;
    };

    /**
     * Removes one deny token from the island
     */
    public void removeDeny() {
        if(denyTokens>0){
            denyTokens--;
        }
    }

    /**
     * @return Integer      Return the number of towers
     */
    public Integer numOfTowers() {
        if(this.towers.isEmpty()) {
            return 0;
        }
        else {
            return 1;
        }
    }

    /**
     * @return current influenceColor
     */
    public PlayerColor getInfluenceColor() {
        if (this.towers.isEmpty()) {
            return null;
        } else {
            return towers.get(0).getColor();
        }
    }

    /**
     *
     */
    public void setIsGrouped() {
        this.isGrouped = true;
    }

    /**
     * @return current isGrouped status
     */
    public Boolean isGrouped () {
        return this.isGrouped;
    }

    /**
     * @return size
     */
    public Integer getSize() { return this.size; }

    /**
     *
     */
    public LinkedList<Island> getIslandGroupElements() {
        LinkedList<Island> list = new LinkedList<>();
        list.add(this);
        return list;
    }

    /**
     *
     */
    public String getId() {
        return this.id;
    }

    /**
     *
     */
    public void setId(String id) { this.id = id; }



}
