package com.jackie.concurrency.reference_escape;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by jackie on 1/5/2017.
 */
public class EventSource extends Thread  {
    private final BlockingQueue<EventListener> listeners =
            new LinkedBlockingQueue<EventListener>();

    public void run() {
        while (true) try {
            EventListener listener = listeners.take();
            try {
                Field this$0 = listener.getClass().getDeclaredField("this$0");
                System.out.println(this$0.getType());
                Method doSomething = this$0.getType().getDeclaredMethod("doSomething", Event.class,String.class);
                doSomething.setAccessible(true);
                doSomething.invoke(this$0.get(listener),new Event(),"reflection call");
                System.out.println("call method success");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            listener.onEvent(null);
        } catch (InterruptedException e) {
            break;
        }
    }

    public void registerListener(EventListener eventListener) {
        listeners.add(eventListener);
    }
}
