package com.liuwenbin.note.java.array;

import com.liuwenbin.note.java.api.ListNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @ Description：在数组中找出第k大的数，注意，数组中可能存在重复的数字。
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/12
 */

public class FindKthLargest {

    /**
     * 找前k大的元素
     */
    public static List<Integer> findAll(int[] a, int k) {
        List<Integer> res = new ArrayList<>();
        find(a, k);
        for (int i = a.length - k; i < a.length; i++) {
            res.add(a[i]);
        }
        return res;
    }

    /**
     * 找第k大的元素（可单独出题）
     */
    public static int find(int[] a, int k) {

        // 找第k大的数，就是找第（a.length - k）小的数
        k = a.length - k;

        // 定义两个指针
        int lo = 0, hi = a.length - 1;

        // 二分搜索
        while (lo < hi) {
            // 找切分点
            int j = partition(a, lo, hi);

            if (j == k) // 命中
                break;
            else if (j < k)
                lo = j + 1;
            else
                hi = j - 1;
        }
        return a[k];
    }

    /**
     * 找切分点，使得切分点左边小于自己，右边大于自己
     */
    private static int partition(int[] a, int lo, int hi) {

        // 1 定义左右两个指针
        int i = lo, j = hi + 1;

        // 2 为简单起见，切分点的值就选第一个元素
        int v = a[lo];

        // 3 找切分点的下标
        while (true) {
            // 左指针向右移，注意边界
            while (a[++i] < v && i < hi) ;
            // 右指针向左移，注意边界
            while (a[--j] > v && j > lo) ;
            // 指针相遇了，也是边界
            if (i >= j) break;
            // 没相遇 -> 交换
            swap(a, i, j);
        }

        // 4 找到切分点的位置了，把值（第一个）放到正确的位置
        swap(a, lo, j);

        // 5 返回切分点的位置
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {4, 5, -99, 100, 1, 2, 7, -4, 6, 3, 9, 8, -1, 44, 0};
        int res = find(a, 5);
        System.out.println(res);
        System.out.println(findAll(a, 3));
    }
}
