package com.liuwenbin.note.java.tree;

import com.liuwenbin.note.java.api.TreeNode;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ Description： 二叉查找树的第 K 个结点
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/14
 */
 
public class KthNode {

    private int count = 0;
    private TreeNode res;

    public TreeNode find(TreeNode root, int k) {
        inOrder(root, k);
        return res;
    }

    /**
     * 中序遍历，左 -> 父 -> 右
     */
    private void inOrder(TreeNode root, int k) {

        // 边界
        if (root == null || count > k) return;

        // 左
        inOrder(root.left, k);

        // 父
        count++;
        if (count == k) res = root;

        // 右
        inOrder(root.right, k);
    }
}
