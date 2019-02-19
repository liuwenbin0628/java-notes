package com.liuwenbin.note.java.tree;

import com.liuwenbin.note.java.api.TreeNode;
import com.sun.xml.internal.ws.api.pipe.ServerTubeAssemblerContext;

/**
 * @ Description：二叉树任意两节点的最近公共祖先
 * @ Author     ：liuwenbin
 * @ Date       ：2018/12/13
 */

public class LowestCommonAncestor {

    public static TreeNode find(TreeNode root, TreeNode a, TreeNode b) {

        // 1 发现目标节点则通过返回值标记该子树发现了某个目标结点
        if (root == null || a == root || b == root) {
            return root;
        }

        // 2 查看左子树中是否有目标结点，没有为null
        TreeNode left = find(root.left, a, b);

        // 3 查看右子树中是否有目标结点，没有为null
        TreeNode right = find(root.right, a, b);

        // 4 都不为空，说明做右子树都有目标结点，则公共祖先就是本身
        if (left != null && right != null) {
            return root;
        }

        // 5 如果发现了目标节点，则继续向上标记为该目标节点
        return left != null ? left : right;
    }
}
