package com.liuwenbin.note.java.tree;

import com.liuwenbin.note.java.api.TreeNode;

/**
 * @ Description：镜像二叉树
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/12
 */

public class MirrorTree {

    public void mirror(TreeNode root) {
        if (root == null) return;
        swap(root);
        mirror(root.left);
        mirror(root.right);
    }

    /**
     * 翻转node结点的左右孩子
     */
    private void swap(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
