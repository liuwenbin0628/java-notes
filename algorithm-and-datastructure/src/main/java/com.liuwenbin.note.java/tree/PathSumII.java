package com.liuwenbin.note.java.tree;

import com.liuwenbin.note.java.api.TreeNode;

/**
 * @ Description：统计路径和等于一个数的路径数量
 * .             路径不一定以 root 开头，也不一定以 leaf 结尾，但是必须连续。
 * @ Author     ：liuwenbin
 * @ Date       ：2019/1/14
 */

public class PathSumII {

    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return pathFrom(root, sum)
                + pathSum(root.left, sum)
                + pathSum(root.right, sum);

    }

    private int pathFrom(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return (root.val == sum ? 1 : 0)
                + pathFrom(root.left, sum - root.val)
                + pathFrom(root.right, sum - root.val);

    }


}
