package com.jackie.patterns.bebavioral.observer;

import java.util.Objects;

/**
 * Created by jackie on 5/31/2016.
 */
public class MyTopicSubscriber implements Observer {
    private String subscriber;

    public MyTopicSubscriber(String subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public void update(Subject subject, Object argument) {
        if (Objects.isNull(subject)) {
            throw new IllegalArgumentException("the subscribed subject cannot be null");
        }
        System.out.println("subscriber " + subscriber + " consume updated subject message ==>"+argument);
    }
}
