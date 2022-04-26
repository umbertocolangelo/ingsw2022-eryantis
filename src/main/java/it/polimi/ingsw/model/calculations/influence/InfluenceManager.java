package it.polimi.ingsw.model.calculations.influence;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.islands.IslandInterface;
import it.polimi.ingsw.model.pawns.MotherNature;
import it.polimi.ingsw.model.pawns.Tower;
import it.polimi.ingsw.model.player.Player;

import java.util.ArrayList;
import java.util.Collection;

public class InfluenceManager {

    private MotherNature motherNature;

    /**
     * Stores the players
     */
    private Collection<Player> players;

    /**
     * The class that defines how the influence is calculated in the calculateInfluence method
     */
    private InfluenceCalculator influence;

    /**
     * Constructor
     * @param players is a collection of players
     */
    public InfluenceManager(MotherNature motherNature, Collection<Player> players) {
        this.motherNature = motherNature;
        this.players = new ArrayList<Player>(players);
        influence = new StandardInfluence(players,motherNature,this);
    }

    /**
     * Starts the influence calculus by calling the calculateInfluence() method in the current Influence state
     */
    public void calculateInfluence() {
        influence.calculateInfluence();
    }

    /**
     * Sets the influence to ignore a specific student Color in the influence calculus
     * @param color indicates the color to ignore in the influence calculus
     */
    public void setColorInfluence(Color color) {
        influence = new ColorInfluence(players, motherNature, this, color);
    }

    /**
     *  Sets the influence state to ignore towers in the influence calculus
     */
    public void setTowerInfluence() {
        influence = new TowerInfluence(players, motherNature);
    }

    /**
     *  Sets the influence state to calculate the influence on a different island instead of the island
     *  MotherNature is currently on
     *
     * @param island indicates the island to calculate the influence ond
     */
    public void setIslandInfluence(Island island) {
        influence = new IslandInfluence(players, island, this);
    }

    /**
     *  Sets the influence state to the standard one
     */
    public void setStandardInfluence() {
        this.influence = new StandardInfluence(players, motherNature,this);
    }

    /**
     * Sets the influence state to the standard one + 2 extra points
     * @param player indicates
     */
    public void setTwoPointsInfluence(Player player){
        influence = new TwoPointsInfluence(players, motherNature, this, player);
    }

    /**
     * Moves the towers when there is a winner
     */
    public void applyInfluence(Player oldPlayer, Player newPlayer, IslandInterface island) {
        Collection<Tower> towers = island.getTowers();
        Integer numOfTowers = island.numOfTowers();

        for(Tower tower : towers){  // removes the current tower
            oldPlayer.getSchool().getTowerTable().addTower(tower);
        }

        for(Integer place = 0; place < numOfTowers; place++){
            Tower tower = newPlayer.getSchool().getTowerTable().getTowers().get(0);
            if(tower != null){
                island.addTower(tower);
                continue;
            }
            return;
        }

    }

    /**
     * used only in tests
     * @return
     */
    public MotherNature getMotherNature() {return this.motherNature;}

    /**
     * used only in tests
     */
    public InfluenceCalculator getInfluence() {return this.influence;}

}
