package it.polimi.ingsw.model.calculations.professor;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.pawns.Professor;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.player.board.Line;

import java.util.ArrayList;
import java.util.Collection;

public class ProfessorManager {

    /**
     * Stores the players
     */
    private Collection<Player> players;

    /**
     * Stores the strategy used in the checkProfessor method
     */
    private ProfessorStrategy strategy;

    /**
     * Default constructor
     */
    public ProfessorManager(Collection<Player> players){
        this.players = new ArrayList<>(players);
        this.strategy = new StandardStrategy();
    }

    /**
     * Checks if a professor has to be acquired by a player and moves it to the corresponding Line
     */
    public void checkProfessor(Player currentPlayer){

        for(Color color : Color.values()){  //For each color

            Professor currentProfessor = Professor.getProfessor(color);
            Line currentPlayerLine = currentPlayer.getSchool().getHall().getLine(color);

            if(currentProfessor.getPosition()==null){  //If the professor has no position yet
                if(currentPlayerLine.numOfStudents() > 0){
                    //System.out.println(currentPlayer.getName()+" takes the "+color+" professor");
                    currentPlayerLine.addProfessor(currentProfessor);
                    continue;
                }
            }

            int max = maxStudentNum(currentPlayer, color);

            if(strategy.compare(currentPlayerLine.numOfStudents(),max,color)){    //If the currentPlayer should have the professor
                //System.out.println(currentPlayer.getName()+" takes the "+color+" professor");
                currentPlayerLine.addProfessor(currentProfessor);
            }

        }


    }

    /**
     *
     * @param currentPlayer is the player to be compared
     * @param color is the color of the students that will be counted
     * @return the maximum number of student owned by every player except the currentPlayer
     */
    private int maxStudentNum(Player currentPlayer, Color color){
        int max = 0;
        for(Player player : players){
            if(player==currentPlayer){continue;}       //Do not consider the current player in the comparison
            if(max<player.getSchool().getHall().getLine(color).numOfStudents()){
                max = player.getSchool().getHall().getLine(color).numOfStudents();
            }
        }
        return max;
    }

    /**
     *  Sets the strategy to the standard one (StandardStrategy)
     */
    public void setStandardCheck(){
        strategy = new StandardStrategy();
    }

    /**
     *  Sets the strategy to EqualStrategy after the relative expert card use
     */
    public void setEqualCheck(){
        strategy = new EqualStrategy();
    }

}

