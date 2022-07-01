package it.polimi.ingsw.utils;

import it.polimi.ingsw.model.Game;

import java.io.*;
import java.nio.file.Files;
import java.util.LinkedList;

/**
 * Class used to manage the saving and loading of matches
 */
public class SavingManager implements Serializable{

    /**
     * Default constructor
     */
    public SavingManager() {

    }

    /**
     * Stores the unique instance
     */
    private static SavingManager instance;

    /**
     *
     * @return the unique instance of SavingManager
     */
    public static SavingManager getInstance(){
        if (instance==null) {
            instance = new SavingManager();
        }
        return instance;
    }

    /**
     * Saves the current state of the game on a file
     * @param game is the instance of the game that will be saved
     * @param path is the path the game will be saved to
     * @return true if succeeded
     */
    public Boolean saveGame(Game game, String path) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(path))) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(game);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Loads a saved game
     * @param playerNames contains the names of the players
     * @return the loaded instance of Game, return null if not present
     */
    public Game loadGame(LinkedList<String> playerNames, Boolean expertMode) {

        java.util.Collections.sort(playerNames); // sorts the playerNames list alphabetically

        String path = "eriantys";

        if(expertMode){ // specifies the mode
            path = path + "_exp";
        }else{
            path = path + "_cls";
        }
        for(String name : playerNames){
            path = path + "-" + name;
        }
        path = path + ".save";
        try (FileInputStream fileInputStream = new FileInputStream(new File(path))) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Game) objectInputStream.readObject();
        }
        catch (IOException e) {System.out.println("File not found");}
        catch (ClassNotFoundException e) {}
        return null;
    }

    /**
     * Deletes the saved game file
     * @param path is the path of the file to delete
     * @return true if succeeded
     */
    public Boolean deleteSavedGame(String path) {
        File file = new File(path);
        try {
            if (Files.deleteIfExists(file.toPath())) {
                return true;
            }
        } catch (IOException e) {
            return false;
        }
        return false;
    }
}
