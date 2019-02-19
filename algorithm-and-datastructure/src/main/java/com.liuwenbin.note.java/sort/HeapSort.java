package com.liuwenbin.note.java.sort;

/**
 * @ Description：堆排序
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/12
 */

public class HeapSort {

    public static void sort(int[] a) {
        int n = a.length;

        // 1 建大顶堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            sink(a, i, n);
        }

        // 2 排序
        for (int i = n - 1; i > 0; i--) {
            // a[0]肯定是a[0]到a[i]之间最大的 -> 摞到a[i]位置上
            swap(a, 0, i);
            // 在a[0]到a[i-1]这i个元素之间重新建立大顶堆
            sink(a, 0, i);
        }
    }

    /**
     * 下沉（小数下沉，大数向前）
     */
    private static void sink(int[] a, int i, int n) {
        int temp = a[i];

        for (int k = 2 * i + 1; k < n; k = 2 * k + 1) {

            // 让k先指向子节点中最大的节点
            if (k + 1 < n && a[k] < a[k + 1]) {
                k++;
            }
            // 如果发现子节点更大 -> 进行交换
            if (a[k] > temp) {
                swap(a, i, k);
                i = k;
            } else { // 否则 -> 退出循环
                break;
            }
        }
    }

    /**
     * 交换元素
     */
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {2, 18, 7, 5, -1, 8, 3, 1, 11, 10, 0, 9, 6, 4};
        sort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }


}
