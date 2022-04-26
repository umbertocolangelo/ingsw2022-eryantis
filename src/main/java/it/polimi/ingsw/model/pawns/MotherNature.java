package it.polimi.ingsw.model.pawns;

import it.polimi.ingsw.model.calculations.influence.*;
import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.islands.IslandInterface;
import it.polimi.ingsw.model.objectTypes.FixedObject;
import it.polimi.ingsw.model.objectTypes.PlaceableObject;
import it.polimi.ingsw.model.player.Player;

/**
 * 
 */
public class MotherNature implements PlaceableObject {

    /**
     * Default constructor
     */
    public MotherNature() {
    }

    /**
     * 
     */
    private String id;

    /**
     *
     */
    private FixedObject position;


    /**
     * 
     */
    private IslandInterface island;

    /**
     * @return the Island/IslandGroup MotherNature is currently on
     */
    public IslandInterface getIsland() {
        return this.island;
    }

    /**
     *  Sets the current position of MotherNature on a specific Island
     */
    public void setIsland(IslandInterface island) {
        this.island=island;
    }

    /**
     * @return
     */
    public FixedObject getPosition(){
        return this.position;
    }

    /**
     * @param position
     * @return
     */
    public void setPosition(FixedObject position) {
        // TODO implement here
    }

    /**
     * @return id
     */
    public String getId() { return this.id; }

}