package com.song.algorithm.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 226. 翻转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree
 * <p>
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * 示例 2：
 * <p>
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 * 示例 3：
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * 提示：
 * <p>
 * 树中节点数目范围在 [0, 100] 内
 * -100 <= Node.val <= 100
 */
public class LeetCode226_InvertTree {

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
     * 前序遍历迭代实现
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !deque.isEmpty()) {
            if (cur != null) {
                deque.push(cur);
                // 将左右孩子调换
                TreeNode temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;
                cur = cur.left;
            } else {
                cur = deque.pop();
                cur = cur.right;
            }
        }
        return root;
    }

    /**
     * 递归实现
     * @param root
     * @return
     */
    public TreeNode recursive(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            recursive(root.left);
            recursive(root.right);
        }
        return root;
    }

    /**
     * 前序遍历迭代实现
     *
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return root;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode cur = deque.pop();
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            if (cur.right != null) {
                deque.push(cur.right);
            }
            if (cur.left != null) {
                deque.push(cur.left);
            }
        }
        return root;
    }

    /**
     * 中序遍历迭代实现困难
     *
     * @param root
     * @return
     */
    @Deprecated
    public TreeNode invertTree3(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !deque.isEmpty()) {
            if (cur != null) {
                deque.push(cur);
                cur = cur.left;
            } else {
                cur = deque.pop();
                // 将左右孩子调换
                TreeNode temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;
                cur = cur.right;
            }
        }
        return root;
    }

    /**
     * 后续遍历
     *
     * @param root
     * @return
     */
    public TreeNode invertTree4(TreeNode root) {
        if (root == null) {
            return root;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode cur = deque.peek();
            if (cur != null) {
                deque.push(null);
                if (cur.right != null) {
                    deque.push(cur.right);
                }
                if (cur.left != null) {
                    deque.push(cur.left);
                }
            } else {
                deque.pop();
                TreeNode node = deque.pop();
                // 调换位置
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
        }
        return root;
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
                add(root);
            }};
            while (!queue.isEmpty()) {
                ArrayList<Integer> list = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                result.add(list);
            }
        }
        return result;
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
        System.out.println(Arrays.toString(levelOrder(invertTree(root)).toArray()));
//        System.out.println(Arrays.toString(levelOrder(invertTree2(root)).toArray()));
//        System.out.println(Arrays.toString(levelOrder(invertTree3(root)).toArray()));
//        System.out.println(Arrays.toString(levelOrder(invertTree4(root)).toArray()));
//        System.out.println(Arrays.toString(levelOrder(recursive(root)).toArray()));
    }
}
