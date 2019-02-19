package com.liuwenbin.note.java.tree;

import com.liuwenbin.note.java.api.TreeNode;

/**
 * @ Description：判断是否是平衡二叉树
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/13
 */

public class IsBalanced {

    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        height(root);
        return isBalanced;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return Math.max(left, right) + 1;
    }
}
