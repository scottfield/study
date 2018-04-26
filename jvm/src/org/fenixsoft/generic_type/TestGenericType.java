package org.fenixsoft.generic_type;

import java.util.HashMap;
import java.util.Map;

/**
 * Title(文件名): TestGenericType<p>
 * Description(描述):<p>
 * Copyright(版权): Copyright (c) 2016<p>
 * Company(公司): 成都四方伟业软件股份有限公司<p>
 * CreateTime(生成日期):2016/11/30
 *
 * @author SF-2171
 */
public class TestGenericType {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("hello", "你好");
        map.put("how are you?", "吃了没?");
        System.out.println(map.get("hello"));
        System.out.println(map.get("how are you?"));

    }
}
