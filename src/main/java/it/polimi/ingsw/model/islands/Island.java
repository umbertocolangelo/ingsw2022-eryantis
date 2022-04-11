package it.polimi.ingsw.model.islands;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.objectTypes.FixedObjectStudent;
import it.polimi.ingsw.model.objectTypes.FixedObjectTower;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.pawns.Tower;
import java.util.*;


/**
 *
 */
public class Island implements FixedObjectStudent,FixedObjectTower, IslandInterface {



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
        if(tower.getPosition()!=null){        // If the tower was on a FixedObject, this object is updated
            FixedObjectTower position = (FixedObjectTower) tower.getPosition();
            position.removeTower(tower);
        }
        tower.setPosition(this);
        this.towers.add(tower);
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
        return new LinkedList<>(this.towers);
    }

    /**
     * @param color
     * @return Integer      Return the number of student who by color
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
     * Set the state of isDenied
     */
    public void setDeny() { isDenied=true;
    }

    /**
     * @return boolean      Return the state of isDenied
     */
    public boolean getDeny(){
        return isDenied;
    };

    /**
     * Set isDenied to false;
     */
    public void removeDeny() {
        isDenied=false;
    }

    /**
     * @return Integer      Return the number of towers
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

   public PlayerColor getInfluenceColor() {
       if(this.towers.isEmpty()){
           return null;
       }else{
        return towers.get(0).getColor();
       }
   }

}