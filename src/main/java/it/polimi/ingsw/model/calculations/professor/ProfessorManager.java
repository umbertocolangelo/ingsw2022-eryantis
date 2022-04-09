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

            for(Player player : players){
                if(player==currentPlayer){continue;}       //Do not consider the current player in the comparison

                if(currentProfessor.getPosition()==null){  //If the prof has no position yet
                    if(currentPlayerLine.numOfStudents() > 0){currentPlayerLine.addProfessor(currentProfessor);}
                    return;
                }

                if(strategy.compare(currentPlayerLine.numOfStudents(),player.getSchool().getHall().getLine(color).numOfStudents())){    //If the currentPlayer should have the professor
                    currentPlayerLine.addProfessor(currentProfessor);
                }

            }
        }

    }


}

