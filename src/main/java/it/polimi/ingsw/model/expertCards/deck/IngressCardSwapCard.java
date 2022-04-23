package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.objectTypes.FixedObjectStudent;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.rounds.RoundInterface;
import it.polimi.ingsw.model.studentSuppliers.Bag;

import java.util.*;

/**
 * carta #7
 */
public class IngressCardSwapCard implements ExpertCard, FixedObjectStudent {

    /**
     * Default constructor
     */
    public IngressCardSwapCard(Bag bag) {
       this.bag=bag;
        for (int i=0; i<6; i++) {
           students.add(this.bag.newStudent());
        }
    }

    /**
     * 
     */
    private String id;

    /**
     *
     */
    private Bag bag;

    /**
     *
     */
    private Integer cost = 1;

    /**
     *
     */
    private LinkedList<Student> students=new LinkedList<>();

    /**
     *
     */
    private CardManager manager;

    /**
     *
     */
    private RoundInterface round;

    /**
     *
     */
    public void apply() {
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
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id=id;
    }

    /**
     * @param student
     */
    public void addStudent(Student student) {
        this.students.add(student);
    }

    /**
     * @param student
     */
    public void removeStudent(Student student) {
        this.students.remove(student);
    }

    /**
     * @return
     */
    public LinkedList<Student> getStudents() {
        return new LinkedList<>(this.students);
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