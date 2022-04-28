package it.polimi.ingsw.listener;


import it.polimi.ingsw.model.Game;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PropertyObserver implements PropertyChangeListener {

    public PropertyObserver(Game game)
    {
        this.game=game;
        game.addListener(this);
    }
    private Game game;
    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Old value   "+ evt.getPropertyName());
        System.out.println("Value changed    "+ evt.getOldValue());
        System.out.println("New value    " +evt.getNewValue());
        System.out.println("Do something, probably will change the json");
    }
}
