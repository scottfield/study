package org.fenixsoft.polymorphic;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * Created by jackie on 11/28/2016.
 */
public class MethodHandleTest {
    static class ClassA {
        public void println(String s) {
            System.out.println("classa print:"+s);
        }
    }

    public static void main(String[] args) throws Throwable {
        Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
        MethodHandle method = getMethod(obj);
        method.invokeExact("hello world");

    }

    public static MethodHandle getMethod(Object receiver) throws NoSuchMethodException, IllegalAccessException {
        MethodType methodType = MethodType.methodType(void.class, String.class);
        return lookup().findVirtual(receiver.getClass(), "println", methodType).bindTo(receiver);
    }
}
