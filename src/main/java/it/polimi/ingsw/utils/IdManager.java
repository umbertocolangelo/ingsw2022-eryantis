package it.polimi.ingsw.utils;

import it.polimi.ingsw.model.enumerations.AssistantCard;
import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.enumerations.Wizard;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.studentSuppliers.Cloud;

import java.io.Serializable;
import java.util.HashMap;


public class IdManager implements Serializable {

    public IdManager() {
        idMap = new HashMap<>();

        // Adds the enumerations to idMap
        for(Color color : Color.values()){
            addColor(color);
        }
        for(PlayerColor playerColor : PlayerColor.values()){
            addPlayerColor(playerColor);
        }
        for(AssistantCard card : AssistantCard.values()){
            addAssistantCard(card);
        }
        for(Wizard wizard : Wizard.values()){
            addWizard(wizard);
        }
    }

    /**
     * Stores the unique instance of IdManager
     */
    private static IdManager instance;

    /**
     * Associates every object with an id
     */
    private static HashMap<String, Object> idMap;

    /**
     *
     * @return the unique instance of IdManager
     */
    public static IdManager getInstance(){
        if(instance==null) {
            instance = new IdManager();
        }
        return instance;
    }

    /**
     * @param player
     */
    public void addPlayer(Player player) {
        idMap.put(player.getId(), player);
    }

    /**
     * @param playerColor
     */
    public void addPlayerColor(PlayerColor playerColor) {
        idMap.put(playerColor.getId(), playerColor);
    }

    /**
     * @param color
     */
    public void addColor(Color color) {
        idMap.put(color.getId(), color);
    }

    /**
     * @param wizard
     */
    public void addWizard(Wizard wizard) {
        idMap.put(wizard.getId(), wizard);
    }

    /**
     * @param assistantCard
     */
    public void addAssistantCard(AssistantCard assistantCard) {
        idMap.put(assistantCard.getId(), assistantCard);
    }

    /**
     * @param island
     */
    public void addIsland(Island island) {
        idMap.put(island.getId(), island);
    }

    /**
     * @param expertCard
     */
    public void addExpertCard(ExpertCard expertCard) {
        idMap.put(expertCard.getId(), expertCard);
    }

    /**
     * @param cloud
     */
    public void addCloud(Cloud cloud) {
        idMap.put(cloud.getId(), cloud);
    }

    /**
     * @param student
     */
    public void addStudent(Student student) {
        idMap.put(student.getId(), student);
    }

    /**
     * @param id
     * @return
     */
    public Player getPlayer(String id) {
        if (Integer.parseInt(id)>0 && Integer.parseInt(id)<4)
            return (Player) idMap.get(id);
        else
            return null;
    }

    /**
     * @param id
     * @return
     */
    public PlayerColor getPlayerColor(String id) {
        if(Integer.parseInt(id)>3 && Integer.parseInt(id)<7)
            return (PlayerColor) idMap.get(id);
        else
            return null;
    }

    /**
     * @param id
     * @return
     */
    public Color getColor(String id) {
        if (Integer.parseInt(id)>6 && Integer.parseInt(id)<12)
            return (Color) idMap.get(id);
        else
            return null;
    }

    /**
     * @param id
     * @return
     */
    public Wizard getWizard(String id) {
        if (Integer.parseInt(id)>11 && Integer.parseInt(id)<16)
            return (Wizard) idMap.get(id);
        else
            return null;
    }

    /**
     * @param id
     * @return
     */
    public AssistantCard getAssistantCard(String id) {
        if (Integer.parseInt(id)>15 && Integer.parseInt(id)<26)
            return (AssistantCard) idMap.get(id);
        else
            return null;
    }

    /**
     * @param id
     * @return
     */
    public Island getIsland(String id) {
        if (Integer.parseInt(id)>25 && Integer.parseInt(id)<38)
            return (Island) idMap.get(id);
        else
            return null;
    }

    /**
     * @param id
     * @return
     */
    public ExpertCard getExpertCard(String id) {
        if (Integer.parseInt(id)>37 && Integer.parseInt(id)<50)
            return (ExpertCard) idMap.get(id);
        else
            return null;
    }

    /**
     * @param id
     * @return
     */
    public Cloud getCloud(String id) {
        if (Integer.parseInt(id)>49 && Integer.parseInt(id)<53)
            return (Cloud) idMap.get(id);
        else
            return null;
    }

    /**
     * @param id
     * @return
     */
    public Student getStudent(String id) {
        if (Integer.parseInt(id)>52)
            return (Student) idMap.get(id);
        else
            return null;
    }

}
