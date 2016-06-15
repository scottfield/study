package com.jackie.patterns.bebavioral.mediator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jackie on 6/15/2016.
 */
public class ChatRoomTest {

    @Test
    public void testSendMessage() throws Exception {
        ChatRoom chatRoom = new ChatRoomImpl();
        User jackie = new UserImpl("jackie", chatRoom);
        User tom = new UserImpl("tom", chatRoom);
        User scott = new UserImpl("scott", chatRoom);
        User lily = new UserImpl("lily", chatRoom);
        chatRoom.addUser(jackie);
        chatRoom.addUser(tom);
        chatRoom.addUser(scott);
        chatRoom.addUser(lily);

        jackie.sendMessage("hello my name is jackie");
    }
}