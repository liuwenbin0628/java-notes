package com.liuwenbin.note.java.tree;

import com.liuwenbin.note.java.api.TreeNode;

/**
 * @ Description：判读是否是对称二叉树
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/12
 */

public class IsSymmetricalTree {

    public boolean isSymmetrical(TreeNode root) {
        if (root == null)
            return true;

        return isSymmetrical(root.left, root.right);
    }

    private boolean isSymmetrical(TreeNode left, TreeNode right) {

        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.val != right.val)
            return false;

        return isSymmetrical(left.left, right.right)
                && isSymmetrical(left.right, right.left);
    }
}
