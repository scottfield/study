package com.jackie.patterns.bebavioral.mediator;

/**
 * Created by jackie on 6/15/2016.
 */
public interface ChatRoom {
    void sendMessage(User user ,String message);

    void addUser(User user);
}
