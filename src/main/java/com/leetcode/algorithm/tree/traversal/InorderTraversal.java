package com.leetcode.algorithm.tree.traversal;

import com.leetcode.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InorderTraversal {

    //递归实现
    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        inorderTraversal(root, res);
        return res;
    }

    private static void inorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorderTraversal(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);
    }

    public static List<Integer> inorderTraversalIterative(TreeNode root) {
        // 初始化结果列表，用于存储中序遍历的结果
        List<Integer> res = new ArrayList<>();

        // 使用栈来模拟递归过程，存储待访问的节点
        Deque<TreeNode> stack = new LinkedList<>();

        // 当前节点指针，从根节点开始遍历
        TreeNode curr = root;

        // 迭代遍历二叉树的条件：
        // 1. 当前节点不为空，或者
        // 2. 栈中还有待处理的节点
        while (curr != null || !stack.isEmpty()) {
            // 阶段1: 一直向左走到底，将路径上的所有节点入栈
            // 这模拟了递归中先访问左子树的过程
            while (curr != null) {
                stack.push(curr);  // 将当前节点压入栈中
                curr = curr.left;  // 移动到左子节点
            }

            // 阶段2: 弹出栈顶节点进行处理
            // 此时已经到达最左端的节点，可以开始访问
            curr = stack.pop();    // 弹出栈顶节点
            res.add(curr.val);     // 将节点值添加到结果列表中

            // 阶段3: 转向右子树
            // 访问完当前节点后，继续处理其右子树
            curr = curr.right;     // 移动到右子节点
        }

        // 返回中序遍历的结果列表
        return res;
    }


    public static void main(String[] args) {

        // 测试用例1: 空树
        System.out.println("测试用例1 - 空树:");
        List<Integer> result1 = inorderTraversal(null);
        System.out.println("结果: " + result1);
        System.out.println("预期: []");
        System.out.println();

        // 测试用例2: 单个节点
        System.out.println("测试用例2 - 单个节点:");
        TreeNode singleNode = new TreeNode(1);
        List<Integer> result2 = inorderTraversal(singleNode);
        System.out.println("结果: " + result2);
        System.out.println("预期: [1]");
        System.out.println();

        // 测试用例3: 简单的二叉树
        //     1
        //      \
        //       2
        //      /
        //     3
        System.out.println("测试用例3 - 简单二叉树:");
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode root1 = new TreeNode(1, null, node2);
        List<Integer> result3 = inorderTraversal(root1);
        System.out.println("结果: " + result3);
        System.out.println("预期: [1, 3, 2]");
        System.out.println();

        // 测试用例4: 完整的二叉树
        //       1
        //      / \
        //     2   3
        //    / \   \
        //   4   5   6
        System.out.println("测试用例4 - 完整二叉树:");
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode leftSubtree = new TreeNode(2, node4, node5);
        TreeNode rightSubtree = new TreeNode(3, null, node6);
        TreeNode root2 = new TreeNode(1, leftSubtree, rightSubtree);
        List<Integer> result4 = inorderTraversal(root2);
        System.out.println("结果: " + result4);
        System.out.println("预期: [4, 2, 5, 1, 3, 6]");
        System.out.println();
    }
}
