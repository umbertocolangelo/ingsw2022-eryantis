package it.polimi.ingsw.model.enumerations;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * This enum contains all the possible colors of the students and professors pawns
 */
public enum Color implements Serializable {
    YELLOW("YELLOW", "7"),
    BLUE("BLUE", "8"),
    GREEN("GREEN", "9"),
    RED("RED", "10"),
    PINK("PINK", "11");

    private final String text;

    private final String id;

    private static final Map<Integer, Color> COLORBYNUMBER = new HashMap<>();

    /**
     * Map each color to an integer value
     */
    static {
        int indices = 0;
        for (Color color: values()) {
            COLORBYNUMBER.put(indices, color);
            indices++;
        }
    }

    /**
     * @param text the string representation of the color.
     */
    Color(String text, String id) {
        this.text = text;
        this.id = id;
    }

    /**
     * Returns the text of the color.
     *
     * @return a String containing the text of the color.
     */
    @Override
    public String toString() {
        return text;
    }

    /**
     * @param number is the number of the color
     * @return the color corresponding to the integer value
     */
    public static Color getColor(Integer number){
        return COLORBYNUMBER.get(number);
    }

    /**
     *
     */
    public String getId() { return id; }
}