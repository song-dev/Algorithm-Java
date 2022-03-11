package com.song.algorithm.linked;

import org.junit.Test;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * <p>
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 */
public class Offer22_GetKthFromEnd {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 快慢指针
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        int count = 0;
        ListNode p = head;
        while (head != null) {
            count++;
            head = head.next;
            if (count > k) {
                p = p.next;
            }
        }
        return p;
    }

    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode p = head;
        for (int i = 0; i < k; i++) {
            head = head.next;
        }
        while (head != null) {
            head = head.next;
            p = p.next;
        }
        return p;
    }

    @Test
    public void test() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
//        node = getKthFromEnd(node, 2);
        node = getKthFromEnd2(node, 2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
