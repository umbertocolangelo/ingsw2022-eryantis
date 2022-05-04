package it.polimi.ingsw.server;
import it.polimi.ingsw.listener.PropertyObserver;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
public interface ClientConnection{

    void closeConnection();

    void addObserver(PropertyObserver observer);

    void asyncSend(Object message);
}
