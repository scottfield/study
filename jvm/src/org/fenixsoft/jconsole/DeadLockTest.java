package org.fenixsoft.jconsole;

/**
 * Created by jackie on 12/15/2016.
 */
public class DeadLockTest {
    static class Caculator implements Runnable {
        private Object a;
        private Object b;

        public Caculator(Object a, Object b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (a) {
                synchronized (b) {
                    for (int i = 0; i < 100; i++) {
                        System.out.println("dafdafdfa");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        for (int i = 0; i < 2000; i++) {
            new Thread(new Caculator(a, b)).start();
            new Thread(new Caculator(b, a)).start();
        }
    }
}
