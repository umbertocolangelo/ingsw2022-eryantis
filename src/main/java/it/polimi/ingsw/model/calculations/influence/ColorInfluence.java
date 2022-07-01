package it.polimi.ingsw.model.calculations.influence;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.islands.IslandInterface;
import it.polimi.ingsw.model.pawns.MotherNature;
import it.polimi.ingsw.model.pawns.Professor;
import it.polimi.ingsw.model.player.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * State pattern of calculus used to ignore a specific color in the influence calculus
 */
public class ColorInfluence implements InfluenceCalculator, Serializable {

    /**
     * Default constructor
     * @param playerList PlayerList
     * @param manager InfluenceManager
     * @param color Color
     */
    public ColorInfluence(Collection<Player> playerList, InfluenceManager manager, Color color) {
        this.players = new ArrayList<Player>(playerList);
        this.manager = manager;
        this.color = color;
    }

    /**
     * Stores the players
     */
    private Collection<Player> players;

    /**
     * Stores the color to ignore
     */
    private Color color;

    /**
     * References the influenceManager
     */
    private InfluenceManager manager;

    /**
     * Calculates the influence with the standard method
     */
    public void calculateInfluence(IslandInterface island) {

        Integer maxCount = null; // indicates if there is currently a draft
        Player winner = null; // references the winner if currently there is one
        Player oldWinner = null; //references the winner of the previous calculus

        for (Player player : players) {
            Integer count = 0;

            if (player.getPlayerColor()==island.getInfluenceColor()) { //if the player has control over the island
                oldWinner = player;
                count = island.numOfTowers(); // add the number of tower to the points of the player
            }

            for (Color color : Color.values()) { // for every color

                if (color==this.color) { // skips the color requested
                    continue;
                }

                if (player.getSchool().getHall().getLine(color)== Professor.getProfessor(color).getPosition()) { // if the player has control of the Professor
                    count += island.numOfStudents(color); //he gets his student points
                }
            }

            if (maxCount==null) {     // if it is the first count
                maxCount = count;
                if (count>0) {
                    winner = player;
                }
                continue;
            }

            if (count.equals(maxCount)) {    // if there is a draft
                winner = null;
            }

            if (count>maxCount) {     // if maxCount is lower than count
                maxCount = count;
                winner = player;
            }
        }

        if (winner!=null && island.getInfluenceColor()!=winner.getPlayerColor()) {    //if towers have to be mover
            manager.applyInfluence(oldWinner, winner, island); // apply changes
        }
    }

}
