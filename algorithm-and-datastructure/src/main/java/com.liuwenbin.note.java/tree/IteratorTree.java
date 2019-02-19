package com.liuwenbin.note.java.tree;

import com.liuwenbin.note.java.api.TreeNode;

import java.util.*;

/**
 * @ Description：遍历二叉树的所有方式
 * .             前序遍历、后续遍历、中序遍历、按层遍历
 * .             包含[递归]和[迭代]版本
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/11
 */

public class IteratorTree {

    /* ----------------------- 前序遍历 ----------------------- */

    // 1 递归
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preHelper(root, res);
        return res;
    }

    private void preHelper(TreeNode node, List res) {
        if (node == null) return;
        res.add(node.val);
        preHelper(node.left, res);
        preHelper(node.right, res);
    }

    // 2 迭代
    public List<Integer> preOrder2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.empty()) {
            if (current != null) {
                stack.push(current);
                res.add(current.val);  // 在遍历到左孩子之前添加
                current = current.left;
            } else {
                TreeNode node = stack.pop();
                current = node.right;
            }
        }
        return res;
    }

    /* ------------------------ 中序遍历 -------------------------- */

    // 1 递归
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inHelper(root, res);
        return res;
    }

    private void inHelper(TreeNode node, List res) {
        if (node == null) return;
        inHelper(node.left, res);
        res.add(node.val);
        inHelper(node.right, res);
    }

    // 2 迭代
    public List<Integer> inOrder2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.empty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode node = stack.pop();
                res.add(node.val);  // 在遍历到右孩子之前添加
                current = node.right;
            }
        }
        return res;
    }

    /* --------------------------后序遍历----------------------------*/

    // 1 递归
    /*public List<Integer> postOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
    }*/

    // 2 迭代

    /* -------------------------- 按层遍历 ------------------------ */
    public static ArrayList<ArrayList<Integer>> level(TreeNode root) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        // FIFO
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null)
            queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.peek();
                level.add(curr.val);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            res.add(level);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(level(root));
    }


}
