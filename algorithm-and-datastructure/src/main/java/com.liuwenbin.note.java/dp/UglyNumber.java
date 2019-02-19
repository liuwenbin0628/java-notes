package com.liuwenbin.note.java.dp;

/**
 * @ Description：把只包含因子 2、3 和 5 的数称作丑数。
 * .             例如 6、8 都是丑数，但 14 不是，因为它包含因子 7。
 * .             习惯上我们把 1 当做是第一个丑数。求按从小到大的顺序的第 n 个丑数。
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/14
 */

public class UglyNumber {

    public static int getUglyNumber(int n) {

        if (n < 6) return n;
        int i2 = 0, i3 = 0, i5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            int u2 = dp[i2] * 2, u3 = dp[i3] * 3, u5 = dp[i5] * 5;

            dp[i] = Math.min(Math.min(u2, u3), u5);

            if (dp[i] == u2) i2++;
            if (dp[i] == u3) i3++;
            if (dp[i] == u5) i5++;
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int res = getUglyNumber(10);
        System.out.println(res);
    }
}
