package it.polimi.ingsw.model.pawns;

import it.polimi.ingsw.model.islands.IslandInterface;
import it.polimi.ingsw.model.objectTypes.FixedObject;
import it.polimi.ingsw.model.objectTypes.PlaceableObject;

import java.io.Serializable;


public class MotherNature implements PlaceableObject, Serializable {

    /**
     * Default constructor
     */
    public MotherNature() {
    }

    /**
     * mother nature id
     */
    private String id;

    /**
     * position of mother nature
     */
    private FixedObject position;

    /**
     * island on which mother nature is located
     */
    private IslandInterface island;

    /**
     * Returns the island on which MotherNature is currently on
     * @return IslandInterface
     */
    public IslandInterface getIsland() {
        return this.island;
    }

    /**
     * Sets the current position of MotherNature on a specific Island
     */
    public void setIsland(IslandInterface island) {
        this.island=island;
    }

    /**
     * @return mother nature position
     */
    public FixedObject getPosition(){
        return this.position;
    }

    /**
     * sets mother nature position
     * @param position
     */
    public void setPosition(FixedObject position) {
        this.position = position;
    }

    /**
     * @return mother nature id
     */
    public String getId() { return this.id; }

}