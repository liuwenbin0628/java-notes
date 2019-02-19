package com.liuwenbin.note.java.string;

/**
 * @ Description：翻转单词顺序列
 * .            "I am a student." -> "student. a am I"
 * @ Author     ：liuwenbin
 * @ Date       ：2019/1/12
 */

public class ReverseSentence {

    public String reverseSentence(String s) {

        int n = s.length();
        char[] chars = s.toCharArray();

        int i = 0, j = 0;
        while (j <= n) {
            if (j == n || chars[j] == ' ') {
                reverse(chars, i, j);
                i = j + 1;
            }
            j++;
        }
        reverse(chars, 0, n - 1);
        return chars.toString();
    }

    private void reverse(char[] c, int i, int j) {
        while (i < j) {
            swap(c, i++, j--);
        }
    }

    private void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}
