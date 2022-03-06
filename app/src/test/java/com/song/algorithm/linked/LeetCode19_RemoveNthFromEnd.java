package com.song.algorithm.linked;

import org.junit.Test;

/**
 * 19. 删除链表的倒数第 N 个结点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * <p>
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *  
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class LeetCode19_RemoveNthFromEnd {

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
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head, p = head, pre = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
            if (count > n) {
                p = p.next;
            }
            if (count > n + 1) {
                pre = pre.next;
            }
        }
        if (pre == p) {
            return head.next;
        } else {
            pre.next = p.next;
        }
        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;
        while (n-- > 0) {
            fast = fast.next;
        }
        // 记住 待删除节点slow 的上一节点
        ListNode prev = null;
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        // 上一节点的next指针绕过 待删除节点slow 直接指向slow的下一节点
        prev.next = slow.next;
        // 释放 待删除节点slow 的next指针, 这句删掉也能AC
        slow.next = null;

        return dummy.next;
    }

    @Test
    public void test() {
        ListNode node = new ListNode(3);
        node.next = new ListNode(2);
        node.next.next = new ListNode(0);
        node.next.next.next = new ListNode(-4);
        node = removeNthFromEnd(node, 1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
