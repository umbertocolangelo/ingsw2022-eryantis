package it.polimi.ingsw.message;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.studentSuppliers.Cloud;

import java.io.Serializable;

public class ChooseStudentsFromCloud implements MessageMethod, Serializable {

    /**
     *
     */
    private Cloud cloud;

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
    public void setCloud(Cloud cloud) {
        this.cloud = cloud;
    }

}
