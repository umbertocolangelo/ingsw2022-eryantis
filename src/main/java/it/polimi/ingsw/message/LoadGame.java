package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;

import java.io.Serializable;

public class LoadGame implements Serializable {

    /**
     * Game instance
     */
    private Game game;

    /**
     * Path of the previous game saved
     */
    private String path;

    /**
     * Sets game
     * @param game
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * Sets saved game path
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return game
     */
    public Game getGame() {
        return this.game;
    }

    /**
     * @return saved game path
     */
    public String getPath() {
        return this.path;
    }
}

