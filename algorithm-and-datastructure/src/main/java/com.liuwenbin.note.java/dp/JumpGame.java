package com.liuwenbin.note.java.dp;

/**
 * @ Description：已知a[i]代表可以跳多少步，判断是否可以从数组的起点跳到终点
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/24
 */
 
public class JumpGame {

    public boolean canJump(int[] a) {

        // max代表能到达的最远距离
        int max = 0;

        for (int i = 0; i < a.length; i++) {
            if (i > max) {
                // 已经走到能力范围之外了
                return false;
            }
            // 否则更新当前位置能
            max = Math.max(max, a[i] + i);
        }
        return true;
    }
}
