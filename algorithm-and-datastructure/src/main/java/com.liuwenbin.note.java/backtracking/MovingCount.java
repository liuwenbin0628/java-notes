package com.liuwenbin.note.java.backtracking;

/**
 * @ Description：地上有一个m行和n列的方格。
 * .              一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * .              但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * .              例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * .              但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * .              请问该机器人能够达到多少个格子？
 * @ Author     ：liuwenbin
 * @ Date       ：2019/1/12
 */

public class MovingCount {

    public int count(int k, int rows, int cols) {
        int[][] flag = new int[rows][cols];
        return help(0, 0, rows, cols, flag, k);
    }

    private int help(int i, int j, int rows, int cols,
                     int[][] flag, int k) {

        boolean error = i < 0 || i >= rows || j < 0 || j >= cols // 边界
                || numSum(i) + numSum(j) > k                     // 位数之和大于k
                || flag[i][j] == 1;                              // 走过了
        if (error) return 0;

        return help(i + 1, j, rows, cols, flag, k)
                + help(i, j + 1, rows, cols, flag, k)
                + 1;
    }

    private int numSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
