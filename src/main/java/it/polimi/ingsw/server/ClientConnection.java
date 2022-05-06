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

    /**
     *
     * @param message
     */
    void asyncSend(Object message);


}
