package com.song.algorithm.linked;

import org.junit.Test;

/**
 * 剑指 Offer 24. 反转链表
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * <p>
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 */
public class Offer24_ReverseList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 双指针实现
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * 递归实现
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    @Test
    public void test() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node = reverseList(node);
        node = reverseList2(node);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
