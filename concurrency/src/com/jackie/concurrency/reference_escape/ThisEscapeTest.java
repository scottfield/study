package com.jackie.concurrency.reference_escape;

/**
 * Created by jackie on 1/5/2017.
 */
public class ThisEscapeTest {
    public static void main(String[] args) {
        EventSource es = new EventSource();
        es.start();
        while(true) {
            new ThisEscape(es);
        }
    }
}
