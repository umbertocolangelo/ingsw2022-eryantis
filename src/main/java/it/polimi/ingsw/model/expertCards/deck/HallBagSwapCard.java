package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.utils.IdManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Expert card n.12, that forces every player to put back in the bag three students of a specific color from their ingress
 */
public class HallBagSwapCard implements ExpertCard, Serializable {

    /**
     * Default constructor
     */
    public HallBagSwapCard(CardManager cardManager) {
        this.id = "49";
        this.cardManager = cardManager;
        IdManager.getInstance().addExpertCard(this);
    }

    /**
     * Reference to card manager
     */
    private CardManager cardManager;

    /**
     * card cost
     */
    private Integer cost = 3;

    /**
     * card id
     */
    private String id;

    /**
     *
     */
    public void apply(Color color) {
        incrementCost();
        ArrayList<Player> players = cardManager.getPlayerList();
        System.out.println(cardManager.getPlayerList());
        for(Player player : players) {
            LinkedList<Student> students = player.getSchool().getHall().getLine(color).getStudents();
            for (int i=0 ; i<3 ;i++) {
                if (!students.isEmpty()) {
                    player.getSchool().getHall().getLine(color).removeStudent(students.removeLast());
                }
                cardManager.getBag().reinsertStudent(color);
            }
        }
    }

    /**
     * @return card cost
     */
    public Integer getCost() {
        return this.cost;
    }

    /**
     * increments card cost
     */
    private void incrementCost() {
        cost = cost + 1;
    }

    /**
     * @return card id
     */
    @Override
    public String getId() {
        return this.id;
    }

}