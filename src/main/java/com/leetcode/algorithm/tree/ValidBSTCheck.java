package com.leetcode.algorithm.tree;

/**
 * 98. 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 *  节点的左子树只包含 严格小于 当前节点的数。
 *  节点的右子树只包含 严格大于 当前节点的数。
 *  所有左子树和右子树自身必须也是二叉搜索树。
 */
public class ValidBSTCheck {
    //不仅需要验证节点与节点的关系，还需啊验证节点与更上层节点的关系
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    public boolean isValidBST(TreeNode root, long minLeft, long maxRight) {
        if (root == null)
            return true;
        if (root.val <= minLeft || root.val >= maxRight)
            return false;
        return isValidBST(root.left, minLeft, root.val) && isValidBST(root.right, root.val, maxRight);

    }
}
