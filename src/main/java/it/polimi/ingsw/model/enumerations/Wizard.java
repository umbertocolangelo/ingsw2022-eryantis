package it.polimi.ingsw.model.enumerations;

import java.io.Serializable;

/**
 * 
 */
public enum Wizard implements Serializable {
    GREEN_WIZARD("12"),
    BLUE_WIZARD("13"),
    YELLOW_WIZARD("14"),
    PURPLE_WIZARD("15");

    /**
     *
     */
    private final String id;

    /**
     * @param id
     */
    Wizard(String id) {
        this.id = id;
    }

    /**
     *
     */
    public String getId() { return id; }
}