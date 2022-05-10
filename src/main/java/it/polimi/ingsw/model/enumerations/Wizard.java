package it.polimi.ingsw.model.enumerations;

import java.io.Serializable;

/**
 * 
 */
public enum Wizard implements Serializable {
    GREEN_WIZARD("GREEN", "12"),
    BLUE_WIZARD("BLUE", "13"),
    YELLOW_WIZARD("YELLOW", "14"),
    PURPLE_WIZARD("PURPLE", "15");

    /**
     *
     */
    private final String id;

    /**
     *
     */
    private final String text;

    /**
     * @param id
     */
    Wizard(String text, String id) {
        this.text = text;
        this.id = id;
    }

    /**
     *
     */
    public String getId() { return this.id; }

    /**
     *
     */
    public String getColor() { return this.text; }

}