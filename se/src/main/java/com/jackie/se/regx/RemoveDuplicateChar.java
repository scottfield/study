package com.jackie.se.regx;

/**
 * Created by jackie on 6/1/2016.
 * 将连续出现的重复字符替换为单个字符
 */
public class RemoveDuplicateChar {
    public static void main(String[] args) {
        String str = "aaeaabbbcccdeaa";
        System.out.println(str);
        System.out.println("*****************");
        str = str.replaceAll("(.)(\\1+)", "$1");
        System.out.println(str);
    }
}
