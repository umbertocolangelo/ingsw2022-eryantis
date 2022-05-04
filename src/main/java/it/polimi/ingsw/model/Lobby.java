package it.polimi.ingsw.model;

import it.polimi.ingsw.model.player.Player;

import java.util.LinkedList;

/**
 * 
 */
public class Lobby {

    /**
     * Default constructor
     */
    public Lobby() {
    }
    /**
     *
     */
    private Game game;
    /**
     * 
     */
    private Integer playerNumber;

    /**
     *
     */
    private LinkedList<Player> players;

    /**
     * @param name
     */
    public Boolean addPlayer(String name) {
        for (int i=0;i<players.size();i++) {
            if (players.get(i).getName().equals(name)){
                return false;
            }
        }
            Player player=new Player(name);
        players.add(player);
        if(isFull())
            this.game.startGame(players);
        return true;
    }
    /**
     *
     *
     */
    public Boolean setPlayerNumber(Integer number){
        if(number==2)
            return true;
        if(number==3)
        {

            return false;
        }
        return true;
    }


    /**
     * @return
     */
    private Boolean isFull() {
       if(players.size()==playerNumber){
           return true;
       }
       return false;
    }

    /**
     *
     */

}