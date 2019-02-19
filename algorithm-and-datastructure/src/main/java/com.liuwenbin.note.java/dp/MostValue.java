package com.liuwenbin.note.java.dp;

/**
 * @ Description：礼物的最大价值
 * .             在一个 m*n 的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于 0）。
 * .             从左上角开始拿礼物，每次向右或向下移动一格，直到右下角结束。
 * .             给定一个棋盘，求拿到礼物的最大价值。
 * @ Author     ：liuwenbin
 * @ Date       ：2019/1/12
 */

public class MostValue {

    public int getMost(int[][] values) {

        // 边界
        if (values == null
                || values.length == 0
                || values[0].length == 0) {
            return 0;
        }

        int cols = values[0].length;
        int[] dp = new int[cols];

        for (int[] value : values) {
            dp[0] += value[0];
            for (int i = 1; i < cols; i++) {
                dp[i] = Math.max(dp[i], dp[i - 1]) + value[i];
            }
        }
        return dp[cols - 1];
    }
}
