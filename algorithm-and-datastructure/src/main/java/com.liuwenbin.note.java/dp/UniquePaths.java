package com.liuwenbin.note.java.dp;

/**
 * @ Description：从长m宽n的格子矩阵的左上角走到右下角，
 * .             只能往右或者往下走，一共有多少种不同走法
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/9
 */

public class UniquePaths {

    public static int uniquePaths(int m, int n) {

        // dp数组记录着到矩阵第i行第j列有db[i][j]条走法
        int[][] dp = new int[m][n];

        /* 显然，最左边一行和最上面一行都只有一种走法 */
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        /*
         * 因为要走到中间某点，只能从它的上方或者左方走过来，所以：
         * 矩阵中间某一点的走法总数 = 它上面的走法总数 + 它左边的走法总数
         */
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        // 最后，后下角的走法显然就是dp[m-1][n-1]的值
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int res = uniquePaths(3, 7);
        System.out.println(res);
    }
}
