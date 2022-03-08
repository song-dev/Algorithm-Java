package com.song.algorithm.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 429. N 叉树的层序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
 * <p>
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * <p>
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 *  
 * <p>
 * 提示：
 * <p>
 * 树的高度不会超过 1000
 * 树的节点总数在 [0, 10^4] 之间
 */
public class LeetCode429_LevelOrder {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * 队列实现
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            Deque<Node> deque = new LinkedList<>();
            deque.add(root);
            while (!deque.isEmpty()) {
                int size = deque.size();
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    Node node = deque.pop();
                    list.add(node.val);
                    if (node.children != null) {
                        deque.addAll(node.children);
                    }
                }
                result.add(list);
            }
        }
        return result;
    }

    @Test
    public void test() {
    }
}
