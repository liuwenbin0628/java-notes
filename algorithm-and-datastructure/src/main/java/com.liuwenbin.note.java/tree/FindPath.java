package com.liuwenbin.note.java.tree;

import com.liuwenbin.note.java.api.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Description：打印出二叉树中结点值的和为输入整数的所有路径
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/12
 */

public class FindPath {

    private ArrayList<ArrayList<Integer>> all = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> find(TreeNode root, int target) {
        backTracking(root, target, new ArrayList<>());
        return all;
    }

    private void backTracking(TreeNode root,
                              int target,
                              ArrayList<Integer> path) {

        if (root == null) return;
        path.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            all.add(path);
        } else {
            backTracking(root.left, target, path);
            backTracking(root.right, target, path);
        }
        path.remove(path.size() - 1);
    }
}
