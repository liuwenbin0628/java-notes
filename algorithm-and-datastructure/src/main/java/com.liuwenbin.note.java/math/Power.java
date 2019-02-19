package com.liuwenbin.note.java.math;

/**
 * @ Description：求 x^n
 * @ Author     ：liuwenbin
 * @ Date       ：2019/1/12
 */
 
public class Power {

    public static double power(double x, int n) {

        // 1 考虑边界
        if (n == 0) return 1;
        if (n == 1) return x;

        // 2 考虑 x<0 的情况
        boolean flag = false;
        if (x < 0) {
            x = -x;
            flag = true;
        }

        // 3 递归调用。考虑x为奇数和偶数两种情况。
        double res = power(x * x, n / 2);
        if (n % 2 == 1)
            res *= x;

        return flag
                ? 1 / res  // x < 0
                : res;     // x > 0
    }

    public static void main(String[] args) {
        System.out.println(power(2, 10));
        System.out.println(power(-2, 3));
    }
}
