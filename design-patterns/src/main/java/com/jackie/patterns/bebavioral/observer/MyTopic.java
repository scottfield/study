package com.jackie.patterns.bebavioral.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by jackie on 5/31/2016.
 */
public class MyTopic implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private final Object mutex = new Object();
    private boolean changed = false;

    @Override
    public void register(Observer observer) {
        synchronized (mutex) {
            if (Objects.isNull(observer)) {
                throw new IllegalArgumentException("observer is null");
            }
            if (observers.contains(observer)) {
                return;
            }
            observers.add(observer);
        }
    }

    @Override
    public void unregister(Observer observer) {
        synchronized (mutex) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers(Object message) {
        synchronized (mutex) {
            if (!changed) {
                return;
            }
            for (Observer observer : observers) {
                observer.update(this, message);
            }
            changed = false;
        }
    }

    public void publishMessage(String message) {
        System.out.println("publish topic message");
        changed = true;
        notifyObservers(message);
    }
}
