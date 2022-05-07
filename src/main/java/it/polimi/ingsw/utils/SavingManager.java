package it.polimi.ingsw.utils;

import it.polimi.ingsw.model.Game;

import java.io.*;

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

    /**
     * Loads a saved game
     * @return
     */
    public Game loadGame(){
        Game game;
        try (FileInputStream fileInputStream = new FileInputStream(new File("eriantys.save"))) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Game) objectInputStream.readObject();

        }
        catch (IOException e) {System.out.println("File not found");}
        catch (ClassNotFoundException e) {}
        return null;
    }



}
