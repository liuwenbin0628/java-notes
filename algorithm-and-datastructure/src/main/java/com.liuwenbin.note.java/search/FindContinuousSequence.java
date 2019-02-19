package com.liuwenbin.note.java.search;

import java.util.ArrayList;

/**
 * @ Description：找出所有和为S的连续正数序列
 * @ Author     ：liuwenbin
 * @ Date       ：2019/1/5
 */

public class FindContinuousSequence {

    public ArrayList<ArrayList<Integer>> find(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        // 假设序列的长度为n，n最小是2，最大是sqrt(2sum)
        int min = 2, max = (int) Math.sqrt(2 * sum);

        for (int n = max; n >= min; n--) {

            // 1 n是奇数，则中间的数就是平均数 -> sum % n == 0
            // 2 n是偶数，则平均值小数部分是0.5 -> (sum % n) * 2 = n

            if ((n & 1) == 1 && (sum % n) == 0  // 奇数
                    || (sum % n) * 2 == n) {    // 偶数

                ArrayList<Integer> list = new ArrayList<>();
                int k = sum / n - (n - 1) / 2, count = n;
                while (count > 0) {
                    list.add(k++);
                    count--;
                }

                res.add(list);
            }
        }
        return res;
    }
}
