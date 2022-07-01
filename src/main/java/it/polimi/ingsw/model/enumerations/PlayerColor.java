package it.polimi.ingsw.model.enumerations;

import java.io.Serializable;

/**
 * This enum contains all the possible player color
 */
public enum PlayerColor implements Serializable {
    BLACK("BLACK", "4"), WHITE("WHITE", "5"), GREY("GREY", "6");

    /**
     * Reference to text
     */
    private final String text;

    /**
     * Reference to player color id
     */
    private final String id;

    /**
     * @param text the string representation of the color.
     */
    PlayerColor(String text, String id) {
        this.text = text;
        this.id = id;
    }

    /**
     * Returns the text of the color.
     * @return a String containing the text of the color.
     */
    @Override
    public String toString() {
        return text;
    }

    /**
     * @return player color id
     */
    public String getId() { return id; }

}