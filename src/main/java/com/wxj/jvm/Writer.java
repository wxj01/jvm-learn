package com.wxj.jvm;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2022/1/13 0013 13:32
 */
public class Writer {
    private String name;
    static String mark = "作者";

    public static void main(String[] args) {
        print(mark);
        Writer w = new Writer();
        print(w.name);
    }

    public static void print(String arg) {
        System.out.println(arg);
    }
}