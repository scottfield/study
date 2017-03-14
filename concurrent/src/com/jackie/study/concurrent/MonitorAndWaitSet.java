package com.jackie.study.concurrent;

/**
 * Title(文件名): MonitorAndWaitSet<p>
 * Description(描述):<p>
 * Copyright(版权): Copyright (c) 2016<p>
 * Company(公司): 成都四方伟业软件股份有限公司<p>
 * CreateTime(生成日期):2017/3/13
 *
 * @author SF-2171
 */
public class MonitorAndWaitSet {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().interrupt();
            }
        }, "t");
        t.start();
    }
}
