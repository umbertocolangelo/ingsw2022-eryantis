package it.polimi.ingsw.model.player.board;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.pawns.Student;

import java.io.Serializable;
import java.util.*;

public class Hall implements Serializable {

    /**
     * Constructor that create the lines in Hall
     */
    public Hall() {
        for (Color color : Color.values()) {
            lines.put(color,new Line(color));
        }
    }

    /**
     * hall id
     */
    private String id;

    /**
     * Map that stores every Line by its respective Color
     */
    private Map<Color, Line> lines = new HashMap<>();

    /**
     * Return the line with of the specified color
     * @param color 
     * @return Line
     */
    public Line getLine(Color color) {
            return lines.get(color);
    }

    /**
     * Adds a student on the corresponding color Line
     * @param student is the student to be added to the Line
     */
    public void addStudent(Student student){
        lines.get(student.getColor()).addStudent(student);
    }

}