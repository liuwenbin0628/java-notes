package com.liuwenbin.note.java.string;

import java.rmi.MarshalException;
import java.util.Arrays;

/**
 * @ Description：最长不含重复字符的子字符串
 * @ Author     ：liuwenbin
 * @ Date       ：2019/1/12
 */

public class LongestSubStringWithoutDuplication {

    public int find(String s) {

        int currLen = 0, maxLen = 0;
        int[] preIndex = new int[26];
        Arrays.fill(preIndex, -1);

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            int pre = preIndex[c];

            if (pre == -1                   // 第一次出现
                    || i - pre > currLen) { // 以前出现过，但是太远，和现在没关系
                currLen++;
            } else {                        // 这一次的尝试到头了
                maxLen = Math.max(maxLen, currLen);
                currLen = i - pre;
            }
            // 更新到最新
            preIndex[c] = i;
        }
        maxLen = Math.max(maxLen, currLen);
        return maxLen;
    }
}
