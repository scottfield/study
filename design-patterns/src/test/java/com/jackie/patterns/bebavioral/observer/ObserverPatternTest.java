package com.jackie.patterns.bebavioral.observer;

import org.junit.Test;

/**
 * Created by jackie on 5/31/2016.
 */
public class ObserverPatternTest {
    @Test
    public void testObserverPattern() throws Exception {
        MyTopic topic = new MyTopic();
        Observer jackie = new MyTopicSubscriber("jackie");
        Observer tom = new MyTopicSubscriber("tom");
        Observer scott = new MyTopicSubscriber("scott");
        topic.register(jackie);
        topic.register(tom);
        topic.register(scott);

        topic.publishMessage("this is new subject message");
        topic.notifyObservers("fdafda");
        topic.notifyObservers("fdafda");
        topic.notifyObservers("fdafda");
        topic.notifyObservers("fdafda");
    }
}