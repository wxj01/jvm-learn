package com.wxj.jvm;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2022/1/13 0013 10:20
 */
public class ClassFile01 {
    public static final String J = "2222222";

    private int k;

    public int getK() {
        return k;
    }

    public void setK(int k) throws Exception {

        try {
            this.k = k;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } finally {
            System.out.println(11);
        }
    }

    public static void main(String[] args) {
    }
}

