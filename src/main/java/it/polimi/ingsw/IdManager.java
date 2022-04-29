package it.polimi.ingsw;

import it.polimi.ingsw.model.enumerations.AssistantCard;
import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.enumerations.Wizard;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.studentSuppliers.Cloud;

import java.util.HashMap;


public class IdManager {

    public IdManager() {
        idMap = new HashMap<>();
    }

    /**
     *
     */
    private static HashMap<Object, String> idMap;

    /**
     * @param player
     */
    public void addPlayer(Player player) {
        idMap.put(player, player.getId());
    }

    /**
     * @param playerColor
     */
    public void addPlayerColor(PlayerColor playerColor) {
        idMap.put(playerColor, playerColor.getId());
    }

    /**
     * @param color
     */
    public void addColor(Color color) {
        idMap.put(color, color.getId());
    }

    /**
     * @param wizard
     */
    public void addWizard(Wizard wizard) {
        idMap.put(wizard, wizard.getId());
    }

    /**
     * @param assistantCard
     */
    public void addAssistantCard(AssistantCard assistantCard) {
        idMap.put(assistantCard, assistantCard.getId());
    }

    /**
     * @param island
     */
    public void addIsland(Island island) {
        idMap.put(island, island.getId());
    }

    /**
     * @param expertCard
     */
    public void addExpertCard(ExpertCard expertCard) {
        idMap.put(expertCard, expertCard.getId());
    }

    /**
     * @param cloud
     */
    public void addCloud(Cloud cloud) {
        idMap.put(cloud, cloud.getId());
    }

    /**
     * @param student
     */
    public void addStudent(Student student) {
        idMap.put(student, student.getId());
    }

}
