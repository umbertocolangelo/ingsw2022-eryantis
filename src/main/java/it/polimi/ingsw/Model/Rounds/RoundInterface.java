package it.polimi.ingsw.Model.Rounds;

import it.polimi.ingsw.Model.Pawns.Student;
import java.util.*;

/**
 * 
 */
public interface RoundInterface {

    /**
     * @param student 
     * @return
     */
    public Boolean moveStudentIngressToHall(String student);

    /**
     * @param student 
     * @param island 
     * @return
     */
    public Boolean moveStudentIngressToIsland(String student, String island);

    /**
     * @param jumps 
     * @return
     */
    public Boolean moveMotherNature(Integer jumps);

    /**
     * @param assistantCard 
     * @return
     */
    public Boolean playAssistantCard(String assistantCard);

    /**
     * @param expertCard 
     * @param parameter 
     * @return
     */
    public Boolean playExpertCard(String expertCard, String parameter);

    /**
     * @param student 
     * @return
     */
    public Boolean moveStudentToBag(String student);

    /**
     * @param student 
     * @param island 
     * @return
     */
    public Boolean expertStudentToIsland(String student, String island);

    /**
     * @param student 
     * @return
     */
    public Boolean expertIngressCardSwap(String student);

    /**
     * @param studentHall 
     * @param studentIngress 
     * @return
     */
    public Boolean expertIngressHallSwap(String studentHall, String studentIngress);

    /**
     * @param student 
     * @return
     */
    public Boolean expertStudentToHall(String student);

    /**
     * @param cloud 
     * @return
     */
    public Boolean chooseCloud(String cloud);

}