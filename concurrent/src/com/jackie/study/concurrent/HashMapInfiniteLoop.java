package com.jackie.study.concurrent;

import java.util.HashMap;

/**
 * Title(文件名): HashMapInfiniteLoop<p>
 * Description(描述):<p>
 * Copyright(版权): Copyright (c) 2016<p>
 * Company(公司): 成都四方伟业软件股份有限公司<p>
 * CreateTime(生成日期):2017/1/13
 *
 * @author SF-2171
 */
public class HashMapInfiniteLoop {

    private static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(2, 0.75f);

    public static void main(String[] args) {
        map.put(5, 55);

        new Thread("Thread1") {
            public void run() {
                map.put(7, 77);
                System.out.println(map);
            }
        }.start();
        new Thread("Thread2") {
            public void run() {
                map.put(3, 33);
                System.out.println(map);
            }
        }.start();

    }

}