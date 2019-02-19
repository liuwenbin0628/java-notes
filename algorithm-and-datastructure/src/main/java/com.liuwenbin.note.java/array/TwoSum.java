package com.liuwenbin.note.java.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Description：找出数组中两数的和等于目标数的一个解
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/4
 */

public class TwoSum {

    /**
     * 时间复杂度：O(n), 空间复杂度O(n)
     *
     * @param nums   输入的数组
     * @param target 目标数
     * @return 和是目标数的两个数在数组中的下标
     */
    public static int[] twoSum(int[] nums, int target) {

        // 缓存，key：nums[i], val: i
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历数组，时间复杂度O(n)
        for (int i = 0; i < nums.length; i++) {
            // 从map内获取值，时间复杂度O(1)
            if (map.containsKey(target - nums[i])) {
                // 命中：返回结果
                return new int[]{map.get(target - nums[i]), i};
            }
            // 没有命中：添加缓存
            map.put(nums[i], i);
        }
        // 无解，抛异常
        throw new IllegalArgumentException("No Solution!");

    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15, 14};
        int target = 18;
        int[] res = twoSum(nums, target);
        System.out.println(res[0] + ", " + res[1]);
    }
}
