package org.fenixsoft.polymorphic;

import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * Created by jackie on 11/28/2016.
 */
public class Test {
    class GrandFather {
        public void thinking() {
            System.out.println("grandfather thinking");
        }
    }

    class Father extends GrandFather {
        public void thinking() {
            System.out.println("father thinking");
        }
    }

    class Son extends Father {
        public void thinking() {
            MethodType methodType = MethodType.methodType(void.class);
            try {
                lookup().findSpecial(GrandFather.class, "thinking", methodType, getClass()).invoke(this);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        (new Test().new Son()).thinking();
    }
}
