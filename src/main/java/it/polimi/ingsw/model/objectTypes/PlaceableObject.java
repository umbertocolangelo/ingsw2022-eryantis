package it.polimi.ingsw.model.objectTypes;

/**
 * 
 */
public interface PlaceableObject {

    /**
     * @return
     */
    public FixedObject getPosition();

    /**
     * @param position
     * @return the position of The Placeable Object
     */
    public void setPosition(FixedObject position);

}