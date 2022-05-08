package it.polimi.ingsw.server;

import it.polimi.ingsw.listener.PropertyObserver;
public interface ClientConnection{

    /**
     *
     */
    void closeConnection();

    /**
     *
     * @param observer
     */
    void addObserver(PropertyObserver observer);




}
