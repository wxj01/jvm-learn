package com.wxj.jvm;

import java.io.File;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2022/1/12 0012 16:36
 */
public class TestDemo01 {
    public static void main(String[] args) {

    }

    private void load(int age, String name, long birthday, boolean sex) {
        System.out.println(age + name + birthday + sex);
    }


    public void store(int age, String name) {
        int temp = age + 2;
        String str = name;
    }


    public void infinityNaN() {
        int i = 10;
        double j = i / 0.0;
        System.out.println(j); // Infinity
        double d1 = 0.0;
        double d2 = d1 / 0.0;
        System.out.println(d2); // NaN
    }

    public void calculate(int age) {
        int add = age + 1;
        int sub = age - 1;
        int mul = age * 2;
        int div = age / 3;
        int rem = age % 4;
        age++;
        age--;
    }

    public static void updown() {
        int i = 10;
        double d = i;
        float f = 10f;
        long ong = (long) f;
    }

    public void newObject() {
        String name = new String("沉默王二");
        File file = new File("无愁河的浪荡汉子.book");
        int[] ages = {};
    }




}