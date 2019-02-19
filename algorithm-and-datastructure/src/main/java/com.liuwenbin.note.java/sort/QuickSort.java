package com.liuwenbin.note.java.sort;

/**
 * @ Description：快排
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/11
 */

public class QuickSort {

    public static void sort(int[] a) {

        // TODO 这里最好能提前打乱数组a的顺序,
        // 因为如果数组a有序或者近似有序(无论是正序还是逆序)，
        // 算法的复杂度都会退化为O(n^2)

        sort(a, 0, a.length - 1);
    }

    /**
     * 快排的核心代码
     * 思想：分治 + 递归
     */
    private static void sort(int[] a, int lo, int hi) {

        // 1 处理递归调用的边界
        if (lo >= hi) return;

        // 2 找切分点
        int j = partition(a, lo, hi);

        // 3 排左边
        sort(a, lo, j - 1);

        // 4 排右边
        sort(a, j + 1, hi);
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
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        int[] a = {0, 7, 0, 10, 5, 8, 2, 3, 1, 9, 6, 4};
        sort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
