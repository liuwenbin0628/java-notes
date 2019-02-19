package com.liuwenbin.note.java.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ Description：全排列
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/24
 */

public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, new ArrayList<>());
        return res;
    }

    private static void backtrack(int[] a, List<List<Integer>> res, List<Integer> temp) {
        if (temp.size() == a.length) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < a.length; i++) {
                if (temp.contains(a[i])) continue;
                temp.add(a[i]);
                backtrack(a, res, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        List<List<Integer>> res = permute(a);
        for (List list : res) {
            System.out.println(list);
        }
    }

}
