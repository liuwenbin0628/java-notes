package com.liuwenbin.note.java.dp;

/**
 * @ Description：求最大子数组的乘积
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/9
 */

public class MaxProductSubarray {

    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        // 记录到当前位置(含当前位置)的最大乘积, 最小乘积
        int sofarMax = nums[0], sofarMin = nums[0];
        int res = nums[0];

        for (int i = 1; i < n; i++) {
            int preMax = sofarMax;
            sofarMax = Math.max(Math.max(nums[i] * sofarMax, nums[i] * sofarMin), sofarMax);
            sofarMin = Math.min(Math.min(nums[i] * preMax, nums[i] * sofarMin), sofarMin);
            res = Math.max(res, sofarMax);
        }

        return res;
    }
}
