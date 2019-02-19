package com.liuwenbin.note.java.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ Description：输入一正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * .              例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * @ Author     ：liuwenbin
 * @ Date       ：2019/1/6
 */

public class MakeUpMinNumber {

    public static String print(int[] nums) {

        StringBuilder s = new StringBuilder();
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            list.add(num);
        }

        Collections.sort(list, (Integer a, Integer b) -> {
            String s1 = a + "" + b;
            String s2 = b + "" + a;
            return s1.compareTo(s2);
        });

        for (int num : list) {
            s.append(num);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3, 32, 321};
        System.out.println(print(nums));
    }
}
