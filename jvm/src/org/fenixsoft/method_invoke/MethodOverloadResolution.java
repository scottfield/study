package org.fenixsoft.method_invoke;

/**
 * Title(文件名): MethodOverloadResolution<p>
 * Description(描述):<p>
 * Copyright(版权): Copyright (c) 2016<p>
 * Company(公司): 成都四方伟业软件股份有限公司<p>
 * CreateTime(生成日期):2016/11/28
 *
 * @author SF-2171
 */
public class MethodOverloadResolution {
    public static void sayHello() {
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        sayHello();
    }
}
