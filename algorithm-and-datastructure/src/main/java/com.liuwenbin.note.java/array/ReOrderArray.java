package com.liuwenbin.note.java.array;

/**
 * @ Description：调整数组顺序使奇数位于偶数前面
 * @ Author     ：liuwenbin
 * @ Date       ：2019/1/12
 */
 
public class ReOrderArray {

    public void reOrder(int[] a) {

        // 奇数的个数
        int oddCount = 0;
        for (int v : a) {
            if ((v & 1) == 1)
                oddCount++;
        }
        int[] copy = a.clone();

        int i = 0;
        // 从克隆数组往原数组写
        for (int v : copy) {
            if ((v & 1) == 1) {
                a[i++] = v;
            } else {
                a[oddCount++] = v;
            }
        }
    }
}
