package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.objectTypes.FixedObjectStudent;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.utils.IdManager;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * card #1
 */
public class StudentToIslandCard implements ExpertCard, FixedObjectStudent , Serializable {

    /**
     * Default constructor
     */
    public StudentToIslandCard(CardManager cardManager) {
        this.id = "38";
        this.manager = cardManager;
        IdManager.getInstance().addExpertCard(this);
        students = new LinkedList<Student>();
        for (int i=0; i<4; i++) {
            addStudent(manager.getBag().newStudent());
        }
    }

    /**
     * 
     */
    private String id;

    /**
     *
     */
    private Integer cost = 1;

    /**
     *
     */
    private CardManager manager;

    /**
     *
     */
    private LinkedList<Student> students;

    /**
     * move student to island (student has to be chosen by player)
     */
    public void apply() {
        incrementCost();
    }

    /**
     * @return
     */
    public Integer getCost() {
        return this.cost;
    }

    /**
     * 
     */
    private void incrementCost() {
        cost = cost + 1;
    }

    /**
     * @return
     */
    @Override
    public String getId() {
        return this.id;
    }

    /**
     * @param student
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
     * @param student is removed by the card
     */
    public void removeStudent(Student student) {
        students.remove(student);
    }

    /**
     * @return
     */
    public LinkedList<Student> getStudents() {
        return new LinkedList<Student>(this.students);
    }

    /**
     * @return
     */
    public Integer numOfStudents() {
        return this.students.size();
    }

}