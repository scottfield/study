package com.jackie.patterns.bebavioral.observer;

/**
 * Created by jackie on 5/31/2016.
 */
public interface Subject {
    //methods to register and unregister observers
    void register(Observer obj);

    void unregister(Observer obj);

    //method to notify observers of change
    void notifyObservers(Object message);
}
