package com.liuwenbin.note.java.tree;

import com.liuwenbin.note.java.api.TreeNode;

/**
 * @ Description：序列化和反序列化二叉树
 * @ Author     ：liuwenbin
 * @ Date       ：2019/1/12
 */

public class Serialize {

    // -------------- 序列化二叉树 ----------------

    public String serialize(TreeNode root) {
        if (root == null)
            return "#";
        return root.val + " "
                + serialize(root.left) + " "
                + serialize(root.right);
    }

    // -------------- 反序列化二叉树 ----------------

    private String deserializeStr;

    public TreeNode deserialize(String s) {
        deserializeStr = s;
        return deserialize();
    }

    private TreeNode deserialize() {
        if (deserializeStr.length() == 0)
            return null;
        int index = deserializeStr.indexOf(" ");
        String node = index == -1
                ? deserializeStr
                : deserializeStr.substring(0, index);
        deserializeStr = index == -1
                ? ""
                : deserializeStr.substring(index + 1);
        if (node.equals("#"))
            return null;
        int val = Integer.valueOf(node);
        TreeNode t = new TreeNode(val);
        t.left = deserialize();
        t.right = deserialize();
        return t;
    }
}
