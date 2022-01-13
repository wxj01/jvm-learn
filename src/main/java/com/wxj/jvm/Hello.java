package com.wxj.jvm;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO 二进制字节码
 * @date 2022/1/13 0013 14:50
 */

public class Hello {
    public String hello(String word){
        String prifix="hello,";
        String stanse=prifix+word;
        return stanse;
    }
    public static void main(String[] args) {
        Hello hello=new Hello();
        String word="world";
        String stanse=hello.hello(word);
        System.out.println(stanse);
    }
}