package it.polimi.ingsw.model.objectTypes;


public interface PlaceableObject {

    /**
     * @return fixed object position
     */
    public FixedObject getPosition();

    /**
     * sets position
     * @param position FixedObject
     */
    public void setPosition(FixedObject position);

}