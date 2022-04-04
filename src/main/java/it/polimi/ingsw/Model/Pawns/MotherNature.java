package it.polimi.ingsw.Model.Pawns;

import it.polimi.ingsw.Model.Calculations.Influence.*;
import it.polimi.ingsw.Model.Enumerations.Color;
import it.polimi.ingsw.Model.Islands.Island;
import it.polimi.ingsw.Model.Islands.IslandInterface;
import it.polimi.ingsw.Model.ObjectTypes.FixedObject;
import it.polimi.ingsw.Model.ObjectTypes.PlaceableObject;
import java.util.*;

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
     *
     */
    private InfluenceCalculator influence;

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
     *  Starts the influence calculus by calling the calculateInfluence() method in the current Influence state
     */
    public void calculateInfluence() {
        this.influence.calculateInfluence();
    }

    /**
     *  Sets the influence to ignore a specific student Color in the influence calculus
     *
     * @param color indicates the color to ignore in the influence calculus
     */
    public void setColorInfluence(Color color) {
        this.influence = new ColorInfluence();
    }

    /**
     *  Sets the influence state to ignore towers in the influence calculus
     */
    public void setTowerInfluence() {
        this.influence = new TowerInfluence();
    }

    /**
     *  Sets the influence state to calculate the influence on a different island instead of the island
     *  MotherNature is currently on
     *
     * @param island indicates the island to calculate the influence ond
     */
    public void setIslandInfluence(Island island) {
        this.influence = new IslandInfluence();
    }

    /**
     *  Sets the influence state to the standard one
     */
    public void setStandardInfluence() {
        this.influence = new StandardInfluence();
    }

}