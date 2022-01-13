package com.wxj.jvm;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2022/1/13 0013 14:09
 */
public class Dup {
    int age;

    public int incAndGet() {
        return ++age;
    }

    public void lcmp(long a, long b) {
        if (a > b) {
        }
    }

    public void fi() {
        int a = 0;
        if (a == 0) {
            a = 10;
        } else {
            a = 20;
        }
    }

    public void compare() {
        int i = 10;
        int j = 20;
        System.out.println(i > j);
    }


    public void switchTest(int select) {
        int num;
        switch (select) {
            case 1:
                num = 10;
                break;
            case 2:
            case 3:
                num = 30;
                break;
            default:
                num = 40;
        }
    }


}
