package com.jackie.study.concurrent;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Title(文件名): OutOfTime<p>
 * Description(描述):<p>
 * Copyright(版权): Copyright (c) 2016<p>
 * Company(公司): 成都四方伟业软件股份有限公司<p>
 * CreateTime(生成日期):2017/1/20
 *
 * @author SF-2171
 */
public class OutOfTime {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new ThrowTask(), 1);
        TimeUnit.SECONDS.sleep(1);
        timer.schedule(new ThrowTask(), 1);
        TimeUnit.SECONDS.sleep(5);

    }

    static class ThrowTask extends TimerTask {
        @Override
        public void run() {
            throw new RuntimeException();
        }
    }
}
