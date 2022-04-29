package it.polimi.ingsw.model.studentSuppliers;
import java.util.Random;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.board.Ingress;
 import java.util.*;
/**
 * 
 */
public class Bag {

    /**
     * Default constructor
     */
    public Bag(Boolean isThreePlayers) {
        this.isThreePlayers = isThreePlayers;
    }

    /**
     *  Number of yellowStudents presents on the board
     */
    private Integer yellowStudentsNum=0;

    /**
     * Number of blueStudents presents on the board
     */
    private Integer blueStudentsNum=0;

    /**
     * 
     */
    private Integer greenStudentsNum=0;

    /**
     * 
     */
    private Integer redStudentsNum=0;

    /**
     * 
     */
    private Integer pinkStudentsNum=0;

    /**
     *
     */
    private Boolean isThreePlayers;

    /**
     * 
     */
    private String id;

    /**
     * @return  student         Create a new student, use a fanction that return a random color, check if its not been created all the students of that color, if it isnt than create the student
     */
    public Student newStudent() {
        Color c;
        while(true) {
            c = randomEnum(Color.class);
            if(checkNumOfStudents(c))
                break;
        }
        Student student= new Student(c);
        addStudentsNumbers(c);

        return student;
    }

    /**
     *
     * @param clazz class
     * @param <T>   Enumeration
     * @return  A random object that is contain in the enumen
     */

    public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
        Random rand = new Random();
        int x = rand.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    /**
     * @return boolean      Check if the number of students of the color c is arrived at the maximum
     */
    public boolean checkNumOfStudents(Color c){
        if((greenStudentsNum<26 && c.equals(Color.GREEN)) || (yellowStudentsNum<26 && c.equals(Color.YELLOW)) || (redStudentsNum<26 && c.equals(Color.RED)) || (blueStudentsNum <26 && c.equals(Color.BLUE)) || pinkStudentsNum <26 && c.equals(Color.PINK))
            return true;
            else
                return false;
    }

    /**
     * @param color         Increase the number of student present in the game
     */
    public void addStudentsNumbers(Color color) {
        if(color.equals(Color.RED))
            redStudentsNum++;
        else if(color.equals(Color.PINK))
            pinkStudentsNum++;
        else if(color.equals(Color.BLUE))
            blueStudentsNum++;
        else if(color.equals(Color.YELLOW))
            yellowStudentsNum++;
        else if(color.equals(Color.GREEN))
            greenStudentsNum++;
    }

    /**
     * @param island
     */
    public void addStudentsOnIsland(Island island) {
        island.addStudent(newStudent());
    }

    /**
     * @param cloud
     */
    public void addStudentsOnCloud(Cloud cloud) {
        if (isThreePlayers) {
            for (int i=0; i<4; i++) {
                cloud.addStudent(newStudent());
            }
        }
        else {
            for (int i=0; i<3; i++) {
                cloud.addStudent(newStudent());
            }
        }
    }

    /**
     * @param ingress
     */
    public void addStudentOnIngress(Ingress ingress) {
        ingress.addStudent(newStudent());
    }

    /**
     * @param color
     */
    public void reinsertStudent(Color color) {
        /**
         * To implent , dont know the task
         */
    }

    /**
     * @param expertCard
     */
    public void addStudentOnCard(ExpertCard expertCard) {
        /**
         * To implement when there are experts card
         */
    }

}