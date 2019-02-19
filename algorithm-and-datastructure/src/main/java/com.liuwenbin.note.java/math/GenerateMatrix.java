package com.liuwenbin.note.java.math;

/**
 * @ Description：
 * @ Author     ：liuwenbin
 * @ Date       ：2019/1/11
 */

public class GenerateMatrix {

    public int[][] generate(int n) {
        int[][] res = new int[n][n];

        // 边界
        if (n == 0) return res;

        // 四个指针，一个计数器
        int rowLo = 0, rowHi = n - 1, colLo = 0, colHi = n - 1, count = 1;

        // 开始跑
        while (rowLo <= rowHi && colLo <= colHi) {

            // 上边界
            for (int i = colLo; i <= colHi; i++)
                res[rowLo][i] = count++;
            rowLo++;

            // 右边界
            for (int i = rowLo; i < rowHi; i++)
                res[i][colHi] = count++;
            colHi--;

            // 下边界
            for (int i = colHi; i >= colLo; i--)
                if (rowLo <= rowHi)
                    res[rowHi][i] = count++;
            rowHi--;

            // 左边界
            for (int i = rowHi; i >= rowLo; i--)
                if (colLo <= colHi)
                    res[colLo][i] = count++;
            colLo++;
        }
        return res;
    }
}
