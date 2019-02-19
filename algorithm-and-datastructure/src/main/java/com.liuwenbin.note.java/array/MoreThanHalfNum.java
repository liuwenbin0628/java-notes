package com.liuwenbin.note.java.array;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ Description：数组中出现次数超过一半的数字(假设肯定存在）
 * @ Author     ：liuwenbin
 * @ Date       ：2019/1/12
 */

public class MoreThanHalfNum {

    public int solve(int[] nums) {
        int major = nums[0];

        for (int i = 1, count = 1; i < nums.length; i++) {
            count += major == nums[i] ? 1 : -1;
            if (count == 0) {
                major = nums[i];
                count++;
            }
        }

        return major;
    }

}
