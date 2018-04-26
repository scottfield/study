package org.fenixsoft.polymorphic;

/**
 * Created by jackie on 11/28/2016.
 */
public class DynamicDispatch {
    static abstract class Human {
        abstract void sayHello();
    }

    static class Man extends Human {

        @Override
        void sayHello() {
            System.out.println("hello man");
        }
    }

    static class Woman extends Human {

        @Override
        void sayHello() {
            System.out.println("hello woman");
        }
    }

    public void sayHello(Human human) {
        System.out.println("hello human");
    }

    public void sayHello(Man man) {
        System.out.println("hello man");
    }

    public void sayHello(Woman woman) {
        System.out.println("hello woman");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.sayHello();
        woman.sayHello();
        man = new Woman();
        man.sayHello();
    }
}
