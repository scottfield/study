package com.jackie.study.concurrent.synchronizer;

import java.util.concurrent.CountDownLatch;

/**
 * Title(文件名): TestHarness<p>
 * Description(描述):<p>
 * Copyright(版权): Copyright (c) 2016<p>
 * Company(公司): 成都四方伟业软件股份有限公司<p>
 * CreateTime(生成日期):2017/1/19
 *
 * @author SF-2171
 */
public class TestHarness {
    public long timeTasks(int nThreads, final Runnable task)
            throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);
        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException ignored) {
                    }
                }
            };
            t.start();
        }
        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) throws InterruptedException {
       /* TestHarness harness = new TestHarness();
        harness.timeTasks(10000, new Runnable() {
            @Override
            public void run() {
                int x = 1+ 1;
            }
        });*/
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
    }
}
