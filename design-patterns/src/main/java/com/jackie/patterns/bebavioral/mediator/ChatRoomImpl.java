package com.jackie.patterns.bebavioral.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackie on 6/15/2016.
 */
public class ChatRoomImpl implements ChatRoom {
    private List<User> users;

    public ChatRoomImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(User user, String message) {
        users.stream().forEach(u -> {
            if (u != user) {
                u.receiveMessage(message);
            }
        });
    }
}
