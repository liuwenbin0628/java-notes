package com.liuwenbin.note.java.search;

/**
 * @ Description：在有序数组中找到目标数的下标，如果找不到，就返回它本应该出现的位置
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/24
 */

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int lo = 0, hi = len - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}
