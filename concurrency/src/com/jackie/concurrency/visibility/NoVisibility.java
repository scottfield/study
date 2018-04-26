package com.jackie.concurrency.visibility;

/**
 * Created by jackie on 1/4/2017.
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;
    private static class ReaderThread extends Thread{
        @Override
        public void run() {
            System.out.println("ready:"+ready);
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i=0;i<100;i++) {
            new ReaderThread().start();
        }
        number=42;
        ready = true;
    }
}
