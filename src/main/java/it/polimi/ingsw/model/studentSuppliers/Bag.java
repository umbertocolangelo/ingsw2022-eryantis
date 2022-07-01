package it.polimi.ingsw.model.studentSuppliers;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.board.Ingress;

import java.io.Serializable;
import java.util.Random;

/**
 * Class used to represent the bag containing all the student pawns
 */
public class Bag implements Serializable {

    /**
     * Default constructor
     * @param isThreePlayers Boolean
     */
    public Bag(Boolean isThreePlayers) {
        this.isThreePlayers = isThreePlayers;
    }

    /**
     * number of yellowStudents presents on the board
     */
    private Integer yellowStudentsNum = 0;

    /**
     * number of blueStudents presents on the board
     */
    private Integer blueStudentsNum = 0;

    /**
     * number of greenStudents presents on the board
     */
    private Integer greenStudentsNum = 0;

    /**
     * number of redStudents presents on the board
     */
    private Integer redStudentsNum = 0;

    /**
     * number of pinkStudents presents on the board
     */
    private Integer pinkStudentsNum = 0;

    /**
     * true if is a three player game
     */
    private Boolean isThreePlayers;

    /**
     * bag id
     */
    private String id;

    /**
     * Create a new student, use a function that return a random color, check if have not been created all the students of that color, than create the student
     * @return Student
     */
    public Student newStudent() {
        if (isEmpty()) { //if the bag is empty
            return null;
        }
        Color c;
        while (true) {
            c = randomEnum(Color.class);
            if (checkNumOfStudents(c)) {
                break;
            }
        }
        Student student = new Student(c);
        addStudentsNumbers(c);

        return student;
    }

    /**
     * A random object that is contained in the enum
     * @param clazz class
     * @param <T> Enumeration
     * @return object of T type
     */
    public static <T extends Enum<?>> T randomEnum(Class<T> clazz) {
        Random rand = new Random();
        int x = rand.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    /**
     * Check if the number of students of the color c is arrived at the maximum
     * @param c Color
     * @return Boolean
     */
    public Boolean checkNumOfStudents(Color c){
        if ((greenStudentsNum<26 && c.equals(Color.GREEN)) || (yellowStudentsNum<26 && c.equals(Color.YELLOW)) || (redStudentsNum<26 && c.equals(Color.RED)) || (blueStudentsNum <26 && c.equals(Color.BLUE)) || pinkStudentsNum <26 && c.equals(Color.PINK)){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Increase the number of student present in the game
     * @param color Color
     */
    public void addStudentsNumbers(Color color) {
        if (color.equals(Color.RED)) {
            redStudentsNum++;
        } else if (color.equals(Color.PINK)) {
            pinkStudentsNum++;
        } else if (color.equals(Color.BLUE)) {
            blueStudentsNum++;
        } else if (color.equals(Color.YELLOW)) {
            yellowStudentsNum++;
        } else if (color.equals(Color.GREEN)) {
            greenStudentsNum++;
        }
    }

    /**
     * refill the cloud with students
     * @param cloud Cloud
     */
    public void addStudentsOnCloud(Cloud cloud) {
        if (isThreePlayers) {
            for (int i=0; i<4; i++) {
                if(!isEmpty()){cloud.addStudent(newStudent());}
            }
        } else {
            for (int i=0; i<3; i++) {
                if(!isEmpty()){cloud.addStudent(newStudent());}
            }
        }
    }

    /**
     * reinsert student of the chosen color in the bag
     * @param color Color
     */
    public void reinsertStudent(Color color) {
        switch (color) {
            case YELLOW:
                yellowStudentsNum--;
                break;
            case GREEN:
                greenStudentsNum--;
                break;
            case BLUE:
                blueStudentsNum--;
                break;
            case RED:
                redStudentsNum--;
                break;
            case PINK:
                pinkStudentsNum--;
        }
    }

    /**
     * Check if the bag is empty
     * @return true if the bag is empty
     */
    public boolean isEmpty() {
        if (greenStudentsNum==26 && yellowStudentsNum==26 && redStudentsNum==26 && blueStudentsNum==26 && pinkStudentsNum==26 ) {
            return true;
        }
        return false;
    }
}