package com.song.algorithm.tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * <p>
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 */
public class LeetCode104_MaxDepth {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 队列实现
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        int result = 0;
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                result++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 递归实现
     *
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        return recursive(root, 0);
    }

    private int recursive(TreeNode root, int deep) {
        if (root != null) {
            deep++;
            int deep1 = recursive(root.left, deep);
            int deep2 = recursive(root.right, deep);
            return Math.max(deep1, deep2);
        }
        return deep;
    }

    /**
     * 递归实现
     *
     * @param root
     * @return
     */
    public int maxDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depthLeft = maxDepth3(root.left);
        int depthRight = maxDepth3(root.right);
        return Math.max(depthLeft, depthRight) + 1;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println(maxDepth(root));
        System.out.println(maxDepth2(root));
        System.out.println(maxDepth3(root));
    }
}
