package it.polimi.ingsw.model.expertCards.deck;

import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.pawns.Student;

/**
 * carta #3
 */
public class IslandInfluenceCard implements ExpertCard {

    /**
     * Default constructor
     */
    public IslandInfluenceCard() {
    }

    /**
     * 
     */
    private String id;

    /**
     *
     */
    private Integer cost = 3;

    /**
     *
     */
    private CardManager manager;

    /**
     * @param island
     */
    public void apply(Island island) {
        manager.getMotherNature().setIslandInfluence(island);
        incrementCost();
    }

    /**
     * @return
     */
    public Integer getCost() {
        return this.cost;
    }

    /**
     * 
     */
    public void incrementCost() {
        cost = cost + 1;
    }

    @Override
    public String getId() {
        return null;
    }

    /**
     * @param student
     */
    @Override
    public void removeStudent(Student student) {

    }

    /**
     * @param student
     */
    @Override
    public void addStudent(Student student) {

    }

    @Override
    public void setId(String id) {

    }

}