package com.wxj.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2022/1/13 0013 13:43
 */
public class InvokeExamples {
    private void run() {
        List ls = new ArrayList();
        ls.add("难顶");
        ArrayList als = new ArrayList();
        als.add("学不动了");
    }

    public static void print() {
        System.out.println("invokestatic");
    }

    public static void main(String[] args) {
        print();
        InvokeExamples invoke = new InvokeExamples();
        invoke.run();
    }
}
