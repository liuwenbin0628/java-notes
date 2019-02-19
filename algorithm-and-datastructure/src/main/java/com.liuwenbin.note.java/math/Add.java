package com.liuwenbin.note.java.math;

/**
 * @ Description：求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * @ Author     ：liuwenbin
 * @ Date       ：2019/1/6
 */

public class Add {

    public static int add(int a, int b) {

        return b == 0 ? a : add(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        System.out.println(add(165, 480));
    }
}
