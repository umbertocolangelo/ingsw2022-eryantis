package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;

import java.io.Serializable;

public class ChooseStudentsFromCloud implements MessageMethod, Serializable {

    /**
     *
     */
    private String cloud;

    /**
     *
     * @param game
     */
    public void apply(Game game) {
        game.chooseCloud(cloud);
    }

    /**
     *
     * @param cloud
     */
    public void setCloud(String cloud) {
        this.cloud = cloud;
    }

}
