package com.liuwenbin.note.java.dp;

/**
 * @ Description：求最大连续子数组的和
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/24
 */

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {

        // dp[i]表示以i结尾的子数组的和的最大解
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < nums.length; i++) {

            // 1 计算dp[i]
            // 如果dp[i-1]大于0，那就用当前值加上它
            // 否则，就是当前值
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);

            // 2 更新max
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
