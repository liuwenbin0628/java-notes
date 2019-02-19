package com.liuwenbin.note.java.tree;

import com.liuwenbin.note.java.api.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @ Description：之字形打印二叉树，
 *               即第一行按照从左到右的顺序打印，
 *               第二层按照从右至左的顺序打印，
 *               第三行按照从左到右的顺序打印，其他行以此类推。
 * @ Author     ：liuwenbin
 * @ Date       ：2019/1/6
 */

public class ZPrint {

    public ArrayList<ArrayList<Integer>> print(TreeNode root) {

        ArrayList<ArrayList<Integer>> layers = new ArrayList<ArrayList<Integer>>();

        if (root == null) return layers;

        int depth = 0;

        // Deque<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            depth++;

            ArrayList<Integer> layer = new ArrayList<>();

            int curr = 0, size = queue.size();

            if ((depth & 1) == 0) { //如果是偶数层,倒序添加
                Iterator<TreeNode> it = queue.descendingIterator();
                while (it.hasNext()) {
                    layer.add(it.next().val);
                }
            } else { //如果是奇数层,正序添加
                Iterator<TreeNode> it = queue.iterator();
                while (it.hasNext()) {
                    layer.add(it.next().val);
                }
            }

            while (curr < size) {
                TreeNode node = queue.poll();

                if (node.left != null)
                    queue.offer(node.left);

                if (node.right != null)
                    queue.offer(node.right);

                curr++;
            }
            layers.add(layer);
        }

        return layers;

    }
}
















