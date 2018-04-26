package com.jackie.study.concurrent.memoryModel;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Title(文件名): ModifyFinalField<p>
 * Description(描述):<p>
 * Copyright(版权): Copyright (c) 2016<p>
 * Company(公司): 成都四方伟业软件股份有限公司<p>
 * CreateTime(生成日期):2017/3/14
 *
 * @author SF-2171
 */
public class ModifyFinalField {
    private final int x = 11;

    public void print() {
        System.out.println("x=======" + x);
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ModifyFinalField finalField = new ModifyFinalField();
        finalField.print();
        Field field = finalField.getClass().getDeclaredField("x");
        Field modifiers = Field.class.getDeclaredField("modifiers");
        modifiers.setAccessible(true);
        modifiers.setInt(field,field.getModifiers() & ~Modifier.FINAL);
        field.setAccessible(true);
        field.setInt(finalField,11);
        finalField.print();
        System.out.println(field.get(finalField));
    }
}
