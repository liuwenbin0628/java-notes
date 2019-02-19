package com.liuwenbin.note.java.string;

/**
 * @ Description：求最长回文子串
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/12
 */

public class LongestPalindromicSubstring {

    private int start;
    private int maxLen;


    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;

        for (int i = 0; i < len - 1; i++) {
            help(s, i, i);
            help(s, i, i + 1);
        }

        return s.substring(start, start + maxLen);
    }

    private void help(String s, int left, int right) {
        while (left >= 0
                && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (right - left - 1 > maxLen) {
            start = left + 1;
            maxLen = right - left - 1;
        }
    }
}
