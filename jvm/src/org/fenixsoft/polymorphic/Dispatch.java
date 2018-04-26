package org.fenixsoft.polymorphic;

/**
 * Created by jackie on 11/28/2016.
 */
public class Dispatch {
    static class QQ {
    }

    static class _360 {
    }

    public static class Father {
        public void hardChoice(QQ arg
        ) {
            System.out.println("father choose qq");
        }
        public void hardChoice(_360 arg
        ) {
            System.out.println("father choose _360");
        }

    }
    public static class Son extends Father {
        public void hardChoice(QQ arg
        ) {
            System.out.println("son choose qq");
        }
        public void hardChoice(_360 arg
        ) {
            System.out.println("son choose _360");
        }

    }

    public static void main(String[] args) {
        Father father = new Father();
        Son son = new Son();
        father.hardChoice(new QQ());
        son.hardChoice(new QQ());
    }
}
