package it.polimi.ingsw.model.enumerations;

import java.io.Serializable;

/**
 * This enum contains all the possible wizards
 */
public enum Wizard implements Serializable {
    GREEN_WIZARD("GREEN", "12"),
    BLUE_WIZARD("BLUE", "13"),
    YELLOW_WIZARD("YELLOW", "14"),
    PURPLE_WIZARD("PURPLE", "15");

    /**
     * Wizard id
     */
    private final String id;

    /**
     * Reference to text
     */
    private final String text;

    /**
     * Default constructor
     * @param text
     * @param id
     */
    Wizard(String text, String id) {
        this.text = text;
        this.id = id;
    }

    /**
     * @return wizard id
     */
    public String getId() { return this.id; }

    /**
     * @return wizard color
     */
    public String getColor() { return this.text; }

}