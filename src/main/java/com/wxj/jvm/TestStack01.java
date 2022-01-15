package com.wxj.jvm;

/**
 * @author wxj
 * @version 1.0.0
 * @ClassName TestStack01.java
 * @Description TODO
 * @createTime 2022年01月15日 10:05:00
 */
public class TestStack01 {

    public static void main(String[] args) {
        show(1);
    }

    public static  int show(int a){
        a++;
        if( a > 8) { return  a ;}
        show(a);
        return a;
    }
}
