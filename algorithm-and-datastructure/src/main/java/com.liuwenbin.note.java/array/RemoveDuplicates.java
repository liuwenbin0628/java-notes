package com.liuwenbin.note.java.array;

/**
 * @ Description：移除排序数组的相同数
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/6
 */

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        if (nums.length < 2) {
            return nums.length;
        }

        int index = 1;
        // 变量i负责遍历原数组，index负责建新数组。建完后的数组长度就是index+1
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
            }
        }
        return index;

    }
}
