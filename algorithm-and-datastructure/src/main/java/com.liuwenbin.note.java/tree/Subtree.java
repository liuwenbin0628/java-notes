package com.liuwenbin.note.java.tree;

import com.liuwenbin.note.java.api.TreeNode;

/**
 * @ Description：
 * @ Author     ：liuwenbin
 * @ Date       ：2019/1/14
 */

public class Subtree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)
            return false;
        return isFrom(s, t)
                || isFrom(s.left, t)
                || isFrom(s.right, t);
    }

    private boolean isFrom(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        if (s.val != t.val)
            return false;
        return isSubtree(s.left, t.left)
                && isSubtree(s.right, t.right);
    }
}
