package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.objectTypes.FixedObjectStudent;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.utils.IdManager;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * card #11
 */
public class StudentToHallCard implements ExpertCard, FixedObjectStudent, Serializable {

    /**
     * Default constructor
     */
    public StudentToHallCard(CardManager cardManager) {
        this.id = "48";
        this.manager=cardManager;
        IdManager.getInstance().addExpertCard(this);
        students = new LinkedList<Student>();
        for (int i=0; i<4; i++) {
            addStudent(manager.getBag().newStudent());
        }
    }

    /**
     * card id
     */
    private String id;

    /**
     * card cost
     */
    private Integer cost = 2;

    /**
     * list of the student of the card
     */
    private LinkedList<Student> students;

    /**
     * Reference to card manager
     */
    private CardManager manager;

    /**
     * appliance of the card effect
     */
    public void apply() {
        incrementCost();
    }

    /**
     * @return card cost
     */
    public Integer getCost() {
        return this.cost;
    }

    /**
     * increments card cost
     */
    private void incrementCost() {
        cost = cost + 1;
    }

    /**
     * @return card id
     */
    @Override
    public String getId() {
        return this.id;
    }

    /**
     * add students to the card
     * @param student
     */
    public void addStudent(Student student) {
        if (!this.students.contains(student)) {
            if (student.getPosition()!=null) {         // If the student was on a FixedObject, this object is updated
                FixedObjectStudent position = (FixedObjectStudent) student.getPosition();
                position.removeStudent(student);
            }
            student.setPosition(this);
            this.students.add(student);
        }
    }

    /**
     * remove the students from the card
     * @param student
     */
    public void removeStudent(Student student) {
        this.students.remove(student);
    }

    /**
     * @return list of the students of the card
     */
    public LinkedList<Student> getStudents() {
        return new LinkedList<>(this.students);
    }

    /**
     * @return number of the students of the card
     */
    public Integer numOfStudents() {
        return this.students.size();
    }

}