package com.liuwenbin.note.java.array;

import java.util.Arrays;

/**
 * @ Description：找出数组中三数之和离目标数最近的解
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/6
 */

public class ThreeSumClosest {

    /**
     * 时间复杂度O(n^2)
     */
    public static int threeSumClosest(int[] nums, int target) {

        int res = nums[0] + nums[1] + nums[2];

        // 1 先排序
        Arrays.sort(nums);

        // 2 从前往后扫，留两位给双指针
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            // 3 双指针从两边往中间扫
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == target) {// 遇到相等的，直接返回
                    return target;
                } else if (sum < target) {
                    start++;
                } else {
                    end--;
                }
                // 遇到更近的 就替换掉原来的解
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-3, -2, -5, 3, -4};
        int res = threeSumClosest(nums, -1);
        System.out.println(res);
    }
}
