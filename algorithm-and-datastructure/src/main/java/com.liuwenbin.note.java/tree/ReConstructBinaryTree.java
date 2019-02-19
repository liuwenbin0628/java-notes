package com.liuwenbin.note.java.tree;

import com.liuwenbin.note.java.api.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Description：已知前序遍历、中序遍历，重构二叉树
 * .             假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/11
 */

public class ReConstructBinaryTree {

    private Map<Integer, Integer> indexInOrders = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            indexInOrders.put(in[i], i);
        }
        return help(pre, 0, pre.length - 1, 0);

    }

    /**
     * @param pre  前序遍历的数组
     * @param preL 前序遍历的左边界
     * @param preR 前序遍历的右边界
     * @param inL  中序遍历的左边界
     * @return
     */
    private TreeNode help(int[] pre, int preL, int preR, int inL) {

        // 边界条件
        if (preL > preR) return null;

        // 根节点是前序遍历的第一个，没什么好说的
        TreeNode root = new TreeNode(pre[preL]);

        // 跟节点在中序遍历的位置
        int inIndex = indexInOrders.get(root.val);

        // 左子树的长度（辅助下面的计算）
        int leftTreeSize = inIndex - inL;

        /*
         * pre: [root] [...left...] [...right...]
         * in:  [...left...] [root] [...right...]
         */
        root.left = help(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = help(pre, preL + leftTreeSize + 1, preR, inIndex + 1);
        return root;
    }
}
