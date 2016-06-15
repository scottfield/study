package com.jackie.patterns.bebavioral.mediator;

/**
 * Created by jackie on 6/15/2016.
 */
public class UserImpl implements User {
    private ChatRoom chatRoom;
    private String name;

    public UserImpl(String name, ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
        this.name = name;
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(name + " send message:" + message);
        chatRoom.sendMessage(this, message);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(name + " received message:" + message);
    }
}
