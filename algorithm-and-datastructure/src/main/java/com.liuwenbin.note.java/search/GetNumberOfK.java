package com.liuwenbin.note.java.search;

/**
 * @ Description：数字k在排序数组中出现的次数
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/14
 */

public class GetNumberOfK {

    public int get(int[] nums, int k) {
        int first = binarySearch(nums, k);
        int last = binarySearch(nums, k + 1);
        return (first == nums.length || nums[first] != k)
                ? 0 // 没找着
                : last - first;
    }

    private int binarySearch(int[] nums, int k) {
        int lo = 0, hi = nums.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
