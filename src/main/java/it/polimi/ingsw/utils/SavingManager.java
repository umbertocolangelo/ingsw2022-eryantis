package it.polimi.ingsw.utils;

import it.polimi.ingsw.model.Game;

import java.io.*;
import java.nio.file.Files;

public class SavingManager implements Serializable{

    /**
     * Default constructor
     */
    public SavingManager(){

    }

    /**
     * Stores the unique instance
     */
    private static SavingManager instance;

    /**
     * Path
     */
    private String path = "eriantys.save";

    /**
     *
     * @return the unique instance of SavingManager
     */
    public static SavingManager getInstance(){
        if(instance==null){
            instance = new SavingManager();
        }
        return instance;
    }

    /**
     * Saves the current state of the game on a file
     * @param game
     * @return true if succeeded
     */
    public Boolean saveGame(Game game){
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
     * @return the loaded instance of Game
     */
    public Game loadGame(){
        Game game;
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
     * @return true if succeeded
     */
    public Boolean deleteSavedGame() {
        File file = new File(path);
        try {
            Files.deleteIfExists(file.toPath());
            return true;
        } catch (IOException e) {
            System.out.println("Failed to delete file");
        }
        return false;
    }
}
