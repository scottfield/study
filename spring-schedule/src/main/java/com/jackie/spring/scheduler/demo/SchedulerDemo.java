package com.jackie.spring.scheduler.demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Jackie on 2016/9/29.
 */
@Component
public class SchedulerDemo {
    @Scheduled(fixedRate = 1000)
    public void helloWorld() {
        System.out.println("hello world");
    }
}
