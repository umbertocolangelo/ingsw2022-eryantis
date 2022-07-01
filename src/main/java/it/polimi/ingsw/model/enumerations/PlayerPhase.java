package it.polimi.ingsw.model.enumerations;

import java.io.Serializable;

/**
 * This enum contains all the possible player phase
 */
public enum PlayerPhase implements Serializable {
    SET_UP_PHASE,
    DECK_PHASE,
    COLOR_PHASE,
    CHOOSING_ASSISTANT,
    MOVING_STUDENTS,
    MOVING_MOTHERNATURE,
    CHOOSING_CLOUD
}