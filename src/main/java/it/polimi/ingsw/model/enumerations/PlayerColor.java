package it.polimi.ingsw.model.enumerations;

/**
 * This enum contains all the possible colors of tower pawn
 */
public enum PlayerColor {
    BLACK("BLACK"),
    WHITE("WHITE"),
    GREY("GREY");

    private final String text;

    /**
     * @param text the string representation of the color.
     */
    PlayerColor(String text) {
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