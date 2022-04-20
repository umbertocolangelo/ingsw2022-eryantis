package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.objectTypes.FixedObjectStudent;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.rounds.RoundInterface;

import java.util.*;

/**
 * carta #7
 */
public class IngressCardSwapCard implements ExpertCard, FixedObjectStudent {

    /**
     * Default constructor
     */
    public IngressCardSwapCard() {
        students = new LinkedList<Student>();
        for (int i=0; i<6; i++) {
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
    private Integer cost = 1;

    /**
     *
     */
    private LinkedList<Student> students;

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
    public void apply(LinkedList<Student> studentsToMove) {
        for (int i=0; i<studentsToMove.size(); i++) {
            round.expertIngressCardSwap(studentsToMove.get(i).getId()); //poi salvo in una variabile temporanea gli studenti che viceversa devono essere messi sulla carta
            removeStudent(studentsToMove.get(i));
        }
        //finita le n rimozioni ri aggiungo a this.students gli studenti precedentemente nell'ingresso
        //check this.students.size()==6
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