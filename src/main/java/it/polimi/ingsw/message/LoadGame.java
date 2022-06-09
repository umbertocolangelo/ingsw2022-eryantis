package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;

import java.io.Serializable;

public class LoadGame implements Serializable {

    /**
     *
     */
    private Game game;

    /**
     *
     */
    private String path;

    /**
     *
     * @param game
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     *
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     *
     * @return
     */
    public Game getGame() {
        return this.game;
    }

    /**
     *
     * @return
     */
    public String getPath() {
        return this.path;
    }
}

