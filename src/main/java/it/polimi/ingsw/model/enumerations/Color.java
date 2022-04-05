package it.polimi.ingsw.model.enumerations;

/**
 * This enum contains all the possible colors of the students and professors pawns
 */
public enum Color {
    YELLOW("YELLOW"), BLUE("BLUE"), GREEN("GREEN"), RED("RED"), PINK("PINK");

    private final String text;

    /**
     * @param text the string representation of the color.
     */
    Color(String text) {
        this.text = text;
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
}