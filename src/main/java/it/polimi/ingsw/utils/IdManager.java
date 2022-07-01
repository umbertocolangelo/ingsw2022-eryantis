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
import java.util.Map;

/**
 * class used to track objects that helps the communication between server and client
 */
public class IdManager implements Serializable {

    /**
     * Default constructor
     */
    public IdManager() {

        // Adds the enumerations to idMap
        for (Color color : Color.values()) {
            addColor(color);
        }
        for (PlayerColor playerColor : PlayerColor.values()) {
            addPlayerColor(playerColor);
        }
        for (AssistantCard card : AssistantCard.values()) {
            addAssistantCard(card);
        }
        for (Wizard wizard : Wizard.values()) {
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
    private Map<String, Object> idMap = new HashMap<>();

    /**
     * Stores the current available id
     */
    private Integer studentId = 53;

    /**
     *
     * @return the unique instance of IdManager
     */
    public static IdManager getInstance(){
        if (instance==null) {
            instance = new IdManager();
        }
        return instance;
    }

    /**
     * Sets the instance of the IdManager to an old one already created
     * @param oldInstance is the old instance of the IdManager
     */
    public static void setInstance(IdManager oldInstance){
        instance = oldInstance;
    }

    /**
     * add the player to the map in id manager
     * @param player Player
     */
    public void addPlayer(Player player) {
        idMap.put(player.getId(), player);
    }

    /**
     * add the player color to the map in id manager
     * @param playerColor PlayerColor
     */
    public void addPlayerColor(PlayerColor playerColor) {
        idMap.put(playerColor.getId(), playerColor);
    }

    /**
     * add the color to the map in id manager
     * @param color Color
     */
    public void addColor(Color color) {
        idMap.put(color.getId(), color);
    }

    /**
     * add the wizard to the map in id manager
     * @param wizard Wizard
     */
    public void addWizard(Wizard wizard) {
        idMap.put(wizard.getId(), wizard);
    }

    /**
     * add the assistant card to the map in id manager
     * @param assistantCard AssistantCard
     */
    public void addAssistantCard(AssistantCard assistantCard) {
        idMap.put(assistantCard.getId(), assistantCard);
    }

    /**
     * add the island to the map in id manager
     * @param island Island
     */
    public void addIsland(Island island) {
        idMap.put(island.getId(), island);
    }

    /**
     * add the expert card to the map in id manager
     * @param expertCard ExpertCard
     */
    public void addExpertCard(ExpertCard expertCard) {
        idMap.put(expertCard.getId(), expertCard);
    }

    /**
     * add the cloud to the map in id manager
     * @param cloud Cloud
     */
    public void addCloud(Cloud cloud) {
        idMap.put(cloud.getId(), cloud);
    }

    /**
     * add the student to the map in id manager
     * @param student Student
     */
    public void addStudent(Student student) {
        student.setId(studentId.toString());
        idMap.put(studentId.toString(), student);
        studentId++;
    }

    /**
     * returns the player with that id from the map
     * @param id String
     * @return Player
     */
    public Player getPlayer(String id) {
        if (Integer.parseInt(id)>0 && Integer.parseInt(id)<4) {
            return (Player) idMap.get(id);
        } else {
            return null;
        }
    }

    /**
     * returns the player color with that id from the map
     * @param id String
     * @return PlayerColor
     */
    public PlayerColor getPlayerColor(String id) {
        if(Integer.parseInt(id)>3 && Integer.parseInt(id)<7) {
            return (PlayerColor) idMap.get(id);
        } else {
            return null;
        }
    }

    /**
     * returns the color with that id from the map
     * @param id String
     * @return Color
     */
    public Color getColor(String id) {
        if (Integer.parseInt(id)>6 && Integer.parseInt(id)<12) {
            return (Color) idMap.get(id);
        } else {
            return null;
        }
    }

    /**
     * returns the wizard with that id from the map
     * @param id String
     * @return Wizard
     */
    public Wizard getWizard(String id) {
        if (Integer.parseInt(id)>11 && Integer.parseInt(id)<16) {
            return (Wizard) idMap.get(id);
        } else {
            return null;
        }
    }

    /**
     * returns the assistant card with that id from the map
     * @param id String
     * @return AssistantCard
     */
    public AssistantCard getAssistantCard(String id) {
        if (Integer.parseInt(id)>15 && Integer.parseInt(id)<26) {
            return (AssistantCard) idMap.get(id);
        } else {
            return null;
        }
    }

    /**
     * returns the island with that id from the map
     * @param id String
     * @return Island
     */
    public Island getIsland(String id) {
        if (Integer.parseInt(id)>25 && Integer.parseInt(id)<38) {
            return (Island) idMap.get(id);
        } else {
            return null;
        }
    }

    /**
     * returns the expert card with that id from the map
     * @param id String
     * @return ExpertCard
     */
    public ExpertCard getExpertCard(String id) {
        if (Integer.parseInt(id)>37 && Integer.parseInt(id)<50) {
            return (ExpertCard) idMap.get(id);
        } else {
            return null;
        }
    }

    /**
     * returns the cloud with that id from the map
     * @param id String
     * @return Cloud
     */
    public Cloud getCloud(String id) {
        if (Integer.parseInt(id)>49 && Integer.parseInt(id)<53) {
            return (Cloud) idMap.get(id);
        } else {
            return null;
        }
    }

    /**
     * returns the student with that id from the map
     * @param id String
     * @return Student
     */
    public Student getStudent(String id) {
        if (Integer.parseInt(id)>52) {
            return (Student) idMap.get(id);
        } else {
            return null;
        }
    }

}
