package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.objectTypes.FixedObjectStudent;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.rounds.RoundInterface;

import java.util.*;

/**
 * carta #1
 */
public class StudentToIslandCard implements ExpertCard, FixedObjectStudent {

    /**
     * Default constructor
     */
    public StudentToIslandCard() {
        students = new LinkedList<Student>();
        for (int i=0; i<4; i++) {
            Color color;
            color = randomEnum(Color.class);
            Student student = new Student(color);
            this.students.add(student);
        }
    }

    /**
     * 
     */
    private String id;

    /**
     *
     */

    /**
     *
     */
    private Integer cost = 1;

    /**
     *
     */
    private RoundInterface round;

    /**
     *
     */
    private Island island;

    /**
     *
     */
    private LinkedList<Student> students;

    /**
     * move student to island (student has to be chosen by player)
     */
    public void apply(Island island, Student student) {

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
    public void incrementCost() {
        cost = cost + 1;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(String id) {

    }

    /**
     * @param randomStudent
     * add randomly a new student on the card after the appliance
     */
    public void addStudent(Student randomStudent) {
        this.students.add(randomStudent);
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

    private static <T extends Enum<?>> T randomEnum(Class<T> clazz){
        Random rand = new Random();
        int x = rand.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}