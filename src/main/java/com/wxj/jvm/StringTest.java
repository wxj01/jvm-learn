package com.wxj.jvm;

import org.junit.jupiter.api.Test;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO 字符串
 * @date 2022/1/18 0018 13:18
 */
public class StringTest {

    @Test
    public void test(){

        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4); // true
        System.out.println(s3 == s5); // false
        System.out.println(s3 == s6); // false
        System.out.println(s3 == s7); // false
        System.out.println(s5 == s6); // false
        System.out.println(s5 == s7); // false
        System.out.println(s6 == s7); // false

        String s8 = s6.intern();
        System.out.println(s3 == s8);  // true

    }

    @Test
    public void test2(){
        String s1 = "beijing";
        String s2 = new String("beijing");
        String s3 = s2.intern();

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
    }

    @Test
    public void test3(){
        String s = new String("a") + new String("b");
        String s2 = s.intern();

        System.out.println(s2 == "ab");
        System.out.println(s == "ab");

    }
}