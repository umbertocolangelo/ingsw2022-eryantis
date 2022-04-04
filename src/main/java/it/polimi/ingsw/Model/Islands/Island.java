package it.polimi.ingsw.Model.Islands;

import it.polimi.ingsw.Model.Enumerations.Color;
import it.polimi.ingsw.Model.Enumerations.PlayerColor;
import it.polimi.ingsw.Model.ObjectTypes.fixedObjectStudent;
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
    private LinkedList<Student> students= new LinkedList<Student>();

    /**
     * 
     */
    private LinkedList<Tower> towers= new LinkedList<Tower>();

    /**
     * 
     */
    private Island nextIsland;


    /**
     * 
     */
    private Boolean isGrouped=false;

    /**
     * 
     */
    private Boolean isDenied=false;



    /**
     * @param student
     */

    public void addStudent(Student student) {
        if (!this.students.contains(student)) {
            this.students.add(student);
            }
    }

    /**
     * @param student
     */
    public void removeStudent(Student student) {
        if (this.students.contains(student)) {
            this.students.remove(this.students.indexOf(student));
        }
    }

    /**
     * @return
     */
    public LinkedList<Student> getStudents() {
        return this.students;
    }

    /**
     * @return
     */
    public Integer numOfStudents() {
        return this.students.size();
    }

    /**
     * @param tower
     */
    public void addTower(Tower tower) {
        this.towers.add(tower);
    }

    /**
     * @param tower
     */
    public void removeTower(Tower tower) {
        this.towers.remove(0);

    }

    /**
     * @return
     */
    public LinkedList<Tower> getTowers() {
        return this.towers;
    }

    /**
     * @param color 
     * @return
     */
    public Integer numOfStudents(Color color) {
        int counter=0;
        for (Student s: students )
        {
           if(s.getColor()==color){
               counter++;
             }
        }
        return counter;
    }

    /**
     *
     */
    public void setDeny() { isDenied=true;
    }

    /**
     * 
     */
    public void removeDeny() {
        isDenied=false;
    }

    /**
     * @return
     */
    public Integer numOfTowers() {
      if(this.towers.isEmpty()){
          return 0;
      }
      else{
          return 1;
      }

    }

    /**
     * @return
     */
    public PlayerColor influenceColor() {
        /**
         *
         */
        return null;
    }

}