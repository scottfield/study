package com.jackie.study.concurrent.collection;

import java.util.concurrent.SynchronousQueue;

/**
 * Title(文件名): TestSynchronousQueue<p>
 * Description(描述):<p>
 * Copyright(版权): Copyright (c) 2016<p>
 * Company(公司): 成都四方伟业软件股份有限公司<p>
 * CreateTime(生成日期):2017/3/10
 *
 * @author SF-2171
 */
public class TestSynchronousQueue {
    public static void main(String[] args) {
        final SynchronousQueue<String> queue = new SynchronousQueue<>();
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println(Thread.currentThread().getName() + ":hello");
                        queue.put(Thread.currentThread().getName() + ":hello");
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            }

        }, "producer");
        producer.start();
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println(Thread.currentThread().getName() + queue.take());
                    } catch (InterruptedException e) {
                        break;
                    }
                }

            }
        }, "consumer");
        consumer.start();
    }
}
