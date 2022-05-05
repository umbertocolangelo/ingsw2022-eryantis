package it.polimi.ingsw.model.calculations.influence;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.expertCards.deck.DenyCard;
import it.polimi.ingsw.model.islands.IslandInterface;
import it.polimi.ingsw.model.pawns.MotherNature;
import it.polimi.ingsw.model.pawns.Tower;
import it.polimi.ingsw.model.player.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class InfluenceManager implements Serializable {

    /**
     * references mother nature
     */
    private MotherNature motherNature;

    /**
     * references the expert card DenyCard (if present)
     */
    private DenyCard denyCard;

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
        this.influence = new StandardInfluence(players,this);
    }

    /**
     * Starts the influence calculus (after mother nature is moved) by calling the calculateInfluence() method in the current Influence state
     */
    public void calculateInfluence() {
        if(denyCard!=null){
            if(!checkDeny(motherNature.getIsland())){
                influence.calculateInfluence(motherNature.getIsland());
            }
            return;
        }
        influence.calculateInfluence(motherNature.getIsland());
        setStandardInfluence();
    }

    /**
     * Starts the influence calculus on a specific island, decided by the current player after using the correspondent expert card
     * @param island is where the influence will be calculated
     */

    public void calculateInfluence(IslandInterface island){
        if(denyCard!=null){
            if(!checkDeny(island)){
                influence.calculateInfluence(island);
            }
            return;
        }
        influence.calculateInfluence(island);
        setStandardInfluence();
    }


    /**
     * Sets the influence to ignore a specific student Color in the influence calculus
     * @param color indicates the color to ignore in the influence calculus
     */
    public void setColorInfluence(Color color) {
        influence = new ColorInfluence(players, this, color);
    }

    /**
     *  Sets the influence state to ignore towers in the influence calculus
     */
    public void setTowerInfluence() {
        influence = new TowerInfluence(players,this);
    }

    /**
     *  Sets the influence state to the standard one
     */
    public void setStandardInfluence() {
        this.influence = new StandardInfluence(players,this);
    }

    /**
     * Sets the influence state to the standard one + 2 extra points
     * @param player indicates
     */
    public void setTwoPointsInfluence(Player player){
        influence = new TwoPointsInfluence(players, this, player);
    }

    /**
     * Moves the towers when there is a winner
     */
    public void applyInfluence(Player oldPlayer, Player newPlayer, IslandInterface island) {
        Collection<Tower> towers = island.getTowers();
        Integer numOfTowers = island.numOfTowers();

        if(island.numOfTowers()==0){ // if no one had the island before the calculus
            island.addTower(newPlayer.getSchool().getTowerTable().getTowers().get(0));
            return;
        }

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
     * Sets the instance of the DenyCard
     * @param card
     */
    public void setDenyCard(DenyCard card){
        denyCard = card;
    }

    /**
     * return true if the island has a deny token on and removes it
     * @param island
     * @return
     */
    private boolean checkDeny(IslandInterface island){
        if(island.getDeny()){
            denyCard.addToken();
            return true;
        }
        return false;
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
