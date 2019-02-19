package com.liuwenbin.note.java.tree;

import com.liuwenbin.note.java.api.TreeNode;

/**
 * @ Description：判断路径和是否等于一个数
 * @ Author     ：liuwenbin
 * @ Date       ：2019/1/14
 */

public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {

        // 1 边界
        if (root == null)
            return false;

        // 2 找到了
        if (root.val == sum)
            return true;

        // 3 没找到 继续 DFS
        return hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
    }
}
