package com.liuwenbin.note.java.sort;

/**
 * @ Description：归并排序
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/12
 */

public class MergeSort {

    public static void sort(int[] a) {
        int[] aux = new int[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private static void sort(int[] a, int[] aux, int lo, int hi) {

        // 1 处理递归调用的边界
        if (lo >= hi) return;

        // 2 用分治思想排序，以中点切分数组
        int mid = lo + (hi - lo) / 2;

        // 3 排左边
        sort(a, aux, lo, mid);

        // 4 排右边
        sort(a, aux, mid + 1, hi);

        // 5 合并
        merge(a, aux, lo, mid, hi);
    }

    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {

        // 1 复制原数组到辅助数组
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        // 也可以这么写：
        // System.arraycopy(a, lo, aux, lo, hi - lo + 1);

        // 2 定义两个指针
        int i = lo, j = mid + 1;

        // 3 从辅助数组往原数组写
        for (int k = lo; k <= hi; k++) {
            if (i > mid)              // 处理i指针的边界
                a[k] = aux[j++];
            else if (j > hi)          // 处理j指针的边界
                a[k] = aux[i++];
            else if (aux[i] < aux[j]) // 小的排前面
                a[k] = aux[i++];
            else                      // 小的排前面
                a[k] = aux[j++];

        }
    }

    public static void main(String[] args) {
        int[] a = {2, 7, 6, 5, 8, 3, 1, 9, 4};
        sort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
