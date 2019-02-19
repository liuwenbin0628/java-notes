package com.liuwenbin.note.java.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Description：输入有序数组和目标数，返回所有可能的组合，使之和为目标数
 * .             注意，输入数组均为正整数，且不重复。输出集合可以包含重复数字。
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/24
 */

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] a, int remain, int index,
                           ArrayList<Integer> temp, List<List<Integer>> res) {

        if (remain == 0) {
            res.add(new ArrayList<>(temp));
        } else if (remain > 0) {
            for (int i = index; i < a.length; i++) {
                temp.add(a[i]);
                backtrack(a, remain - a[i], i, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {

    }
}
