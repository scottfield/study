package com.jackie.study.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Title(文件名): ScheduleWithThreadPool<p>
 * Description(描述):<p>
 * Copyright(版权): Copyright (c) 2016<p>
 * Company(公司): 成都四方伟业软件股份有限公司<p>
 * CreateTime(生成日期):2017/1/20
 *
 * @author SF-2171
 */
public class ScheduleWithThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        ScheduledFuture<?> scheduledFuture = executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("dsfdffds");
//                throw new RuntimeException();
            }
        }, 1, 3, TimeUnit.SECONDS);
        boolean canceled = scheduledFuture.cancel(true);
        System.out.println(canceled);
        TimeUnit.SECONDS.sleep(3);
        executorService.shutdown();
    }
}
