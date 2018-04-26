package org.fenixsoft.polymorphic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by jackie on 11/29/2016.
 */
public class DynamicProxyTest {
    interface IHello {
        void hello();
    }

    static class Hello implements IHello {
        @Override
        public void hello() {
            System.out.println("hello world");
        }
    }

    static class DynamicProxy implements InvocationHandler {
        private Object originalObj;

        Object bind(Object originalObj) {
            this.originalObj = originalObj;
            return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(), originalObj.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("welcome");
            return method.invoke(originalObj, args);
        }
    }

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", true);
        IHello proxy = (IHello) (new DynamicProxy().bind(new Hello()));
        proxy.hello();
    }
}
