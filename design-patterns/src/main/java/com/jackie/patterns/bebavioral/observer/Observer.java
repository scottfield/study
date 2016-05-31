package com.jackie.patterns.bebavioral.observer;

/**
 * Created by jackie on 5/31/2016.
 */
public interface Observer {
    //method to update the observer, used by subject
    void update(Subject subject,Object argument);
}
