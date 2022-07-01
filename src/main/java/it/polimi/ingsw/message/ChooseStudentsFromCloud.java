package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;

import java.io.Serializable;

public class ChooseStudentsFromCloud implements MessageMethod, Serializable {

    /**
     * cloud chosen by the player
     */
    private String cloud;

    /**
     * Applies the change at the model
     * @param game Game
     */
    public void apply(Game game) {
        game.chooseCloud(cloud);
    }

    /**
     * Sets the cloud chosen
     * @param cloud String
     */
    public void setCloud(String cloud) {
        this.cloud = cloud;
    }

}
