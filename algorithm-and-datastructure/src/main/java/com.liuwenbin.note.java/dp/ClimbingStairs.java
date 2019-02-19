package com.liuwenbin.note.java.dp;

/**
 * @ Description：爬一个n层的梯子，每次只能爬一层或两层，
 * .             问爬到最高处一共有多少种爬法
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/9
 */

public class ClimbingStairs {

    public static int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        // dp[i]代表走到i层有多少种走法
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            // 走到第i层台阶，可能是从i-1走上来的，也可能是从i-2跨上来的
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int res = climbStairs(3);
        System.out.println(res);
    }
}
