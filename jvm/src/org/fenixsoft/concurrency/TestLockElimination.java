package org.fenixsoft.concurrency;

/**
 * Title(文件名): TestLockElimination<p>
 * Description(描述):<p>
 * Copyright(版权): Copyright (c) 2016<p>
 * Company(公司): 成都四方伟业软件股份有限公司<p>
 * CreateTime(生成日期):2016/12/8
 *
 * @author SF-2171
 */
public class TestLockElimination {
    public static void concatString(String s1, String s2, String s3) {
        String result = s1 + s2 + s3;
        System.out.println(result);
    }
}
