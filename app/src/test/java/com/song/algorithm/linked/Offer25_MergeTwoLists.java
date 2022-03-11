package com.song.algorithm.linked;

import org.junit.Test;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * <p>
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 示例1：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 1000
 */
public class Offer25_MergeTwoLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode one = l1, two = l2, pre = null;
        ListNode newNode = null;
        while (one != null && two != null) {
            ListNode temp;
            if (one.val > two.val) {
                temp = two;
                two = two.next;
            } else {
                temp = one;
                one = one.next;
            }
            if (pre == null) {
                pre = temp;
                newNode = temp;
            } else {
                pre.next = temp;
                pre = pre.next;
            }
        }
        if (one == null) {
            pre.next = two;
        } else {
            pre.next = one;
        }
        return newNode;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0), cur = dum;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }

    @Test
    public void test() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(3);
        node.next.next = new ListNode(5);
        node.next.next.next = new ListNode(7);
        node.next.next.next.next = new ListNode(8);

        ListNode node2 = new ListNode(2);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);
        node2.next.next.next = new ListNode(6);

        ListNode result = mergeTwoLists(node, node2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
