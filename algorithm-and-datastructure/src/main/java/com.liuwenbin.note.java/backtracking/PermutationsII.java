package com.liuwenbin.note.java.backtracking;

import java.util.ArrayList;

/**
 * @ Description：全排列（打印字符串）
 * @ Author     ：liuwenbin
 * @ Date       ：2019/1/12
 */
 
public class PermutationsII {

    public static void solve(String s) {
        char[] chars = s.toCharArray();
        backtracking(chars, new ArrayList<Character>());
    }

    private static void backtracking(char[] chars, ArrayList<Character> list) {
        if (list.size() == chars.length) {
            for (char c : list) {
                System.out.print(c);
            }
            System.out.println(";");
        } else {
            for (int i = 0; i < chars.length; i++) {
                if (list.contains(chars[i])) continue;
                list.add(chars[i]);
                backtracking(chars, list);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        solve("abc");
    }
}
