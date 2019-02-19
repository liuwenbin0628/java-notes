package com.liuwenbin.note.java.math;

import javafx.scene.effect.SepiaTone;

import java.util.HashSet;
import java.util.Set;

/**
 * @ Description：判断一个数是否是快乐数字
 * .              这里我给出3种解法
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/15
 */

public class HappyNumber {

    /**
     * 方法一：利用一个hashset记录已经遍历过的数
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int sum = 0;
            while (n > 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            if (set.contains(sum)) {
                return false;
            } else {
                set.add(sum);
            }
            n = sum;
        }
        return true;
    }

    /**
     * 方法二：无需另外的内存，直接用双指针，一个指针快一个指针慢，最后重合即为false
     */
    public boolean isHappy2(int n) {
        int slow = n, fast = n;

        do {
            slow = getSquareSum(slow);
            fast = getSquareSum(getSquareSum(fast));
        } while (slow != fast);
        return slow == 1;

    }

    private int getSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }

    /**
     * 方法三：遇到4 -> 非开心数
     * 为什么？
     */
    public boolean isHappy3(int n) {

        while (n != 1 && n != 4) {
            int temp = 0;
            while (n > 0) {
                temp += (n % 10) * (n % 10);
                n /= 10;
            }
            n = temp;
        }
        return n == 1;

    }
}
