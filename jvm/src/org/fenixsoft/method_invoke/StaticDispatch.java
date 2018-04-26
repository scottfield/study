package org.fenixsoft.method_invoke;

/**
 * Title(文件名): StaticDispatch<p>
 * Description(描述):<p>
 * Copyright(版权): Copyright (c) 2016<p>
 * Company(公司): 成都四方伟业软件股份有限公司<p>
 * CreateTime(生成日期):2016/11/28
 *
 * @author SF-2171
 */
public class StaticDispatch {
    static abstract class Human{}
    static class Man extends Human{}
    static class Woman extends Human{}

    public void sayHello(Human guy) {
        System.out.println("hello guy");
    }
    public void sayHello(Man man) {
        System.out.println("hello man");
    }
    public void sayHello(Woman woman) {
        System.out.println("hello woman");
    }
    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sd = new StaticDispatch();
        sd.sayHello(man);
        sd.sayHello(woman);
    }
}
