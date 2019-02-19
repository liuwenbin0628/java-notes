package com.liuwenbin.note.java.array;

/**
 * @ Description：在长度为n的数组里的所有数字都在0到n-1之间。
 * .             数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
 * .             请找出数组中任意一个重复的数字。
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/9
 */

public class FindDuplicates {

    /**
     * case1 时间O(n) + 空间O(n)
     */
    public static int findI(int[] nums) {
        int n = nums.length;
        int[] hash = new int[n];

        for (int i = 0; i < n; i++) {
            if (hash[nums[i]] == 1) {
                return nums[i];
            } else {
                hash[nums[i]] = 1;
            }
        }
        return -1;
    }

    /**
     * case2 时间O(n) + 空间O(1) 即不允许使用额外空间。
     * 在上面方法的基础上，更进一步，
     * 这种数组元素在 [0, n-1] 范围内的问题，
     * 我们可以直接在原数组上操作，将值为 i 的元素调整到第 i 个位置上。
     */
    public static int findII(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            // 保证 num[i] == i
            while (nums[i] != i) {

                // 遇到重复的数了，就是我们要找的！
                if (nums[i] == nums[nums[i]])
                    return nums[i];

                // 把num[i]位置上放上合适的数，使得 nums[i] == i
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 0, 2, 5};
        System.out.println(findI(a));
        System.out.println(findII(a));
    }


}
