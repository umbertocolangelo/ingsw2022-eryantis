package it.polimi.ingsw.model.calculations.influence;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.islands.IslandInterface;
import it.polimi.ingsw.model.pawns.MotherNature;
import it.polimi.ingsw.model.pawns.Professor;
import it.polimi.ingsw.model.player.Player;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 
 */
public class TwoPointsInfluence implements InfluenceCalculator {

    /**
     * Default constructor
     * @param motherNature points to motherNature instance
     */
    public TwoPointsInfluence(Collection<Player> playerList, MotherNature motherNature, InfluenceManager manager, Player player) {
        this.motherNature = motherNature;
        this.players = new ArrayList<Player>(playerList);
        this.manager = manager;
        this.currentPlayer=player;
    }

    /**
     * Stores the players
     */
    private Collection<Player> players;

    /**
     * References the influenceManager
     */
    private InfluenceManager manager;

    /**
     * References the player that played the expert card
     */
    private Player currentPlayer;

    /**
     * References motherNature instance
     */
    private MotherNature motherNature;

    /**
     * Calculates the influence with the standard method
     */
    public void calculateInfluence() {
        IslandInterface island = motherNature.getIsland();


        Integer maxCount = null; // indicates if there is currently a draft
        Player winner = null; // references the winner if currently there is one
        Player oldWinner = null; //references the winner of the previous calculus

        for(Player player : players){
            Integer count = 0;

            if(player == currentPlayer){
                count += 2;
            }

            if(player.getPlayerColor()==island.getInfluenceColor()){ //if the player has control over the island
                oldWinner = player;
            }


            for(Color color : Color.values()) { // for every color

                if (player.getSchool().getHall().getLine(color)== Professor.getProfessor(color).getPosition()){ // if the player has control of the Professor
                    count += island.numOfStudents(color); //he gets his student points
                }
            }

            if(maxCount==null){     // if it is the first count
                maxCount=count;
                if(count>0){
                    winner = player;
                }
                continue;
            }

            if(count.equals(maxCount)){    // if there is a draft
                winner = null;
            }

            if(count>maxCount){     // if maxCount is lower than count
                maxCount = count;
                winner = player;
            }
        }

        if(winner!=null && island.getInfluenceColor()!=winner.getPlayerColor()){    //if towers have to be mover
            manager.applyInfluence(oldWinner, winner, (Island) island); // apply changes
        }

    }


}