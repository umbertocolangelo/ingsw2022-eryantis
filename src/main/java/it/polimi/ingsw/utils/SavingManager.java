package it.polimi.ingsw.utils;

import it.polimi.ingsw.model.Game;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SavingManager {

    /**
     * Default constructor
     */
    public SavingManager(){}

    /**
     * Stores the unique instance
     */
    private static SavingManager instance;

    /**
     *
     * @return the unique instance of SavingManager
     */
    public static SavingManager getInstance(){
        if(instance!=null){
            return instance;
        }
        return new SavingManager();
    }

    /**
     * Saves the current state of the game on a file
     * @param game
     * @return
     */
    public Boolean saveGame(Game game){
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File("eriantys.save"))) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(game);
            return true;
        } catch (IOException e) {
            return false;
        }
    }



}
