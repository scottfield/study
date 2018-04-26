package org.fenixsoft.multithread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by jackie on 12/6/2016.
 */
public class VolatileTest {
    private static volatile int race = 0;
    private static CountDownLatch latch = new CountDownLatch(20);

    public static void increase() {
        race++;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        increase();
                    }
                    latch.countDown();
                }
            });
            t.start();
        }
        latch.await();
        System.out.println(race);
    }
}
