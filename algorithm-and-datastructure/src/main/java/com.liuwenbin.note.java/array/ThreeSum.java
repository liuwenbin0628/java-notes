package com.liuwenbin.note.java.array;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @ Description：找出数组中三数之和等于0的所有不同的解
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/4
 */

public class ThreeSum {

    /**
     * case1: nums中没有重复数，可以利用缓存HashMap
     * 时间复杂度O(n^2), 空间复杂度O(n)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(-nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int key = nums[i] + nums[j];
                if (map.containsKey(key) && map.get(key) > j) {
                    res.add(Arrays.asList(nums[i], nums[j], -key));
                }
            }
        }
        return res;
    }

    /**
     * case2: nums内有重复数字，可以利用双指针
     * 时间复杂度O(n^2), 空间复杂度O(1)
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        // 1 先使数组有序(api的底层用的快排，O(n^2))
        Arrays.sort(nums);

        // 2 从头到尾遍历（但是留两位给双指针）
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == nums[i + 1]) {
                continue; // 跳过重复位
            }
            // 3 双指针,从两边往中间扫
            int start = i + 1, end = nums.length - 1;
            int target = -nums[i];
            while (start < end) {

                if (nums[start] + nums[end] == target) {
                    /* 命中 */
                    res.add(Arrays.asList(-target, nums[start], nums[end]));
                    start++;
                    end--;
                    while (start < end && nums[start - 1] == nums[start]) {
                        start++; // 跳过重复位
                    }
                    while (start < end && nums[end + 1] == nums[end]) {
                        end--; // 跳过重复位
                    }
                } else if (nums[start] + nums[end] < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {

    }
}
