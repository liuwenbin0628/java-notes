package com.liuwenbin.note.java.dp;

/**
 * @ Description：求无序数组中的最大递增序列的长度
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/12
 */

public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] a) {

        /*
         * 数组dp存储着递增子序列的尾部最小值，即：
         * dp[i]代表递增子序列长度为i+1的所有情况中，子序列尾部数字中最小的那一个
         * 很显然，dp会是一个递增有序的数组
         * 所以我们可以用二分查找来动态更新dp
         */
        int[] dp = new int[a.length];

        // 递增序列的最大长度，初始化为0
        int len = 0;

        for (int x : a) {

            // 二分查找的双指针
            int i = 0, j = len;

            // 开始查找
            while (i != j) {
                int mid = i + (j - i) / 2;
                if (dp[mid] < x) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            /*
             * 得到的i可能有两种情况：
             * 1） i在0到len-1之间，即 (dp[i-1] <) x < dp[i]，
             *     说明dp[i]需要更新了（很显然x替代dp[i]）
             * 2） i == len，即没找着，说明 x > dp[len-1]
             *     那没什么好说的，新增dp[len]，并使得len++
             */
            dp[i] = x;
            if (i == len) {
                len++;
            }
        }

        return len;
    }

    public static void main(String[] args) {
        int[] a = {1, 100, 2, -1, 3, 99, 4, -5, 5, 6, -100, 7, 0, 8, 9};
        int len = lengthOfLIS(a);
        System.out.println(len);
    }
}
