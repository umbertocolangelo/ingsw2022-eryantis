package it.polimi.ingsw.model.objectTypes;

/**
 * Interface used to represent placeable objects (pawns) that can stay on a fixed object
 */
public interface PlaceableObject {

    /**
     * @return fixed object position
     */
    FixedObject getPosition();

    /**
     * sets position
     * @param position FixedObject
     */
    void setPosition(FixedObject position);

}