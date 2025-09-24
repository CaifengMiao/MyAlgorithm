package com.leetcode.algorithm.tree.buildtree;

import java.util.HashMap;
import java.util.Map;
import com.leetcode.algorithm.tree.TreeNode;

public class preInorderBuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 构建中序遍历的值到索引的映射，方便快速查找根节点位置
        HashMap<Integer, Integer> inMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length, inMap);
    }

    private TreeNode buildTree(int[] preorder, int preorderFrom, int preorderTo,
                               int[] inorder, int inorderFrom, int inorderTo,
                               Map<Integer, Integer> inMap) {

        // 递归终止条件：没有节点需要处理
        if (preorderFrom == preorderTo) return null;

        // 前序遍历的第一个元素就是根节点
        int rootVal = preorder[preorderFrom];
        TreeNode root = new TreeNode(rootVal);

        // 在中序遍历中找到根节点的位置
        int inorderRootIndex = inMap.get(rootVal);

        // 计算左子树的节点数量
        int leftLen = inorderRootIndex - inorderFrom;

        // 递归构建左子树
        root.left = buildTree(preorder, preorderFrom + 1, preorderFrom + leftLen + 1,
                inorder, inorderFrom, inorderRootIndex, inMap);

        // 递归构建右子树
        root.right = buildTree(preorder, preorderFrom + leftLen + 1, preorderTo,
                inorder, inorderRootIndex + 1, inorderTo, inMap);

        return root;
    }
}
