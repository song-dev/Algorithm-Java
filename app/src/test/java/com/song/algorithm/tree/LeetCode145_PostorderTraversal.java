package com.song.algorithm.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * <p>
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[3,2,1]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *  
 * <p>
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 */
public class LeetCode145_PostorderTraversal {

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
     * 迭代实现
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root != null) {
            deque.push(root);
        }
        while (!deque.isEmpty()) {
            TreeNode node = deque.peek();
            if (node != null) {
                // 中节点访问过, 加入空节点做为标记
                deque.push(null);
                if (node.right != null) {
                    // 添加右节点(空节点不入栈)
                    deque.push(node.right);
                }
                if (node.left != null) {
                    // 添加左节点(空节点不入栈)
                    deque.push(node.left);
                }
            } else {
                // 只有遇到空节点的时候, 才将下一个节点放进结果集(下节点肯定不为空)
                deque.pop();
                // 取出下一个不为空节点
                node = deque.pop();
                // 加入到结果集
                list.add(node.val);
            }
        }
        return list;
    }

    /**
     * 递归实现
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        recursive(root, list);
        return list;
    }

    private void recursive(TreeNode root, List<Integer> list) {
        if (root != null) {
            recursive(root.left, list);
            recursive(root.right, list);
            list.add(root.val);
        }
    }

    /**
     * 迭代实现，入栈顺序 根右左，后反转得到左右根
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal3(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root != null) {
            deque.push(root);
        }
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            if (node != null) {
                list.add(node.val);
                if (node.right != null) {
                    // 添加右节点(空节点不入栈)
                    deque.push(node.left);
                }
                if (node.left != null) {
                    // 添加左节点(空节点不入栈)
                    deque.push(node.right);
                }
            }
        }
        Collections.reverse(list);
        return list;
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
        System.out.println(Arrays.toString(postorderTraversal(root).toArray()));
        System.out.println(Arrays.toString(postorderTraversal2(root).toArray()));
        System.out.println(Arrays.toString(postorderTraversal3(root).toArray()));
    }
}
