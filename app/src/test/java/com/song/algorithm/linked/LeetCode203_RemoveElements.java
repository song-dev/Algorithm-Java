package com.song.algorithm.linked;

import org.junit.Test;

/**
 * 203. 移除链表元素
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * <p>
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 * <p>
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * 列表中的节点数目在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 */
public class LeetCode203_RemoveElements {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            if (cur.val != val) {
                pre = cur;
                cur = cur.next;
            } else {
                if (pre == null) {
                    pre = cur;
                    cur = cur.next;
                    pre.next = null;
                    pre = null;
                    head = cur;
                } else {
                    pre.next = cur.next;
                    cur.next = null;
                    cur = pre.next;
                }
            }
        }
        return head;
    }

    public ListNode removeElements2(ListNode head, int val) {
        // 先处理删除头节点情况
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode cur = head, pre = null;
        while (cur != null) {
            if (cur.val != val) {
                pre = cur;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return head;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        ListNode node = removeElements2(head, 6);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
