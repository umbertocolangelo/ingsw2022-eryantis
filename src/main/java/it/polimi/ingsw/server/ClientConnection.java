package it.polimi.ingsw.server;

import it.polimi.ingsw.listener.PropertyObserver;
public interface ClientConnection{

    void closeConnection();

    void addObserver(PropertyObserver observer);

    void asyncSend(Object message);


}
