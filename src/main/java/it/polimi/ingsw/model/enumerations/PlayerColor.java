package it.polimi.ingsw.model.enumerations;

/**
 * 
 */
public enum PlayerColor {
    BLACK("BLACK", "4"), WHITE("WHITE", "5"), GREY("GREY", "6");

    /**
     *
     */
    private final String text;

    /**
     *
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
     *
     * @return a String containing the text of the color.
     */
    @Override
    public String toString() {
        return text;
    }

    /**
     *
     */
    public String getId() { return id; }

}