package com.liuwenbin.note.java.array;

/**
 * @ Description：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * .             1 输入一个递增数组的一个旋转，输出旋转数组的最小元素。
 * .             2 假如这个数组是非递减（允许出现重复元素）的呢？
 * @ Author     ：liuwenbin
 * @ Date       ：2019/1/12
 */

public class MinNumberInRotateArray {

    /**
     * 数组是递增的，没有重复元素
     */
    public int findI(int[] nums) {

        if (nums.length == 0) return 0;

        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] <= nums[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return nums[lo];
    }

    /**
     * 数组是非递减的，有重复元素
     */
    public int findII(int[] nums) {
        if (nums.length == 0) return 0;

        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[lo] == nums[mid] && nums[mid] == nums[hi]) {
                return minNum(nums, lo, hi);
            } else if (nums[mid] <= nums[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return nums[lo];
    }

    private int minNum(int[] nums, int lo, int hi) {
        for (int i = lo; i < hi; i++) {
            if (nums[i] > nums[i + 1])
                return nums[i + 1];
        }
        return nums[lo];
    }

}
