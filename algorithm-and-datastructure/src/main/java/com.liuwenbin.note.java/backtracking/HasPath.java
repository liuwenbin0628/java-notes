package com.liuwenbin.note.java.backtracking;

/**
 * @ Description：判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * .              路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * .              如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * @ Author     ：liuwenbin
 * @ Date       ：2019/1/12
 */

public class HasPath {

    public boolean findPath(char[] matrix, int rows, int cols, char[] s) {
        int[] flag = new int[matrix.length];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (help(matrix, cols, rows, i, j, s, 0, flag))
                    return true;
            }
        }

        return false;
    }

    private boolean help(char[] matrix, int rows, int cols, int i, int j,
                         char[] s, int k, int[] flag) {

        int index = cols * i + j;

        boolean error = i < 0 || i >= rows || j < 0 || j >= cols // 越界
                || matrix[index] != s[k]                         // 不匹配
                || flag[index] == 1;                             // 已经走过
        if (error) return false;

        if (k == s.length - 1) return true; // 走完了

        if (help(matrix, rows, cols, i - 1, j, s, k + 1, flag)
                || help(matrix, rows, cols, i + 1, j, s, k + 1, flag)
                || help(matrix, rows, cols, i, j - 1, s, k + 1, flag)
                || help(matrix, rows, cols, i, j + 1, s, k + 1, flag)) {
            return true;
        }

        // 没成功，回滚
        flag[index] = 0;
        return false;
    }
}
