package com.leetcode.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class TreeLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 使用队列进行BFS遍历
        Queue<TreeNode> queue = new LinkedList<>();
        // 存储最终结果，每个子列表代表一层的节点值
        List<List<Integer>> result = new ArrayList<>();

        // 处理空树情况
        if (root == null)
            return result;

        // 将根节点加入队列
        queue.offer(root);

        // 当队列不为空时继续处理
        while (!queue.isEmpty()) {
            // 当前层的节点数量
            int levelSize = queue.size();
            // 存储当前层节点值的列表
            List<Integer> levelRes = new ArrayList<>();

            // 遍历当前层的所有节点
            for (int i = 0; i < levelSize; i++) {
                // 从队列中取出节点
                TreeNode node = queue.poll();

                // 将左右子节点加入队列（先左后右）
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

                // 将当前节点值加入当前层结果列表
                levelRes.add(node.val);
            }

            // 将当前层结果加入最终结果列表
            result.add(levelRes);
        }

        return result;
    }

    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null)
            return;

        // 如果当前层级的列表还不存在，创建它
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }

        // 将当前节点值添加到对应层级的列表中
        result.get(level).add(node.val);

        // 递归处理左右子树，层级+1
        dfs(node.left, level + 1, result);
        dfs(node.right, level + 1, result);
    }
}
