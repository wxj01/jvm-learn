package com.wxj.jvm;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2022/1/12 0012 16:03
 */
public class StackStruTest {
    public static void main(String[] args) {
        //int i = 2 + 3;
        int i = 2;
        int j = 3;
        int k = i + j;

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("hello");
    }
}
/*

         0 iconst_2
         1 istore_1
         2 iconst_3
         3 istore_2
         4 iload_1
         5 iload_2
         6 iadd
         7 istore_3
         8 ldc2_w #2 <6000>
        11 invokestatic #4 <java/lang/Thread.sleep : (J)V>
        14 goto 24 (+10)
        17 astore 4
        19 aload 4
        21 invokevirtual #6 <java/lang/InterruptedException.printStackTrace : ()V>
        24 getstatic #7 <java/lang/System.out : Ljava/io/PrintStream;>
        27 ldc #8 <hello>
        29 invokevirtual #9 <java/io/PrintStream.println : (Ljava/lang/String;)V>
        32 return*/
