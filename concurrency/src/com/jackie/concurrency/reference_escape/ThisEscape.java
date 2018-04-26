package com.jackie.concurrency.reference_escape;

import java.util.Date;

/**
 * Created by jackie on 1/5/2017.
 */
public class ThisEscape {
    private final int num;

    public ThisEscape(EventSource source) {
        source.registerListener(
                new EventListener() {
                    public void onEvent(Event e) {
                        doSomething(e,"event");
                    }
                });
        num = 42;
    }

    private void doSomething(Event e,String location) {
        System.out.println(location);
        if (num != 42) {
            System.out.println("Race condition detected at " +
                    new Date());
        }
    }
}
