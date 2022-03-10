package com.song.algorithm.linked;

import org.junit.Test;

import java.util.Arrays;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * <p>
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 */
public class Offer06_ReversePrint {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        int[] result = new int[count];
        cur = head;
        for (int i = count - 1; i >= 0; i--) {
            result[i] = cur.val;
            cur = cur.next;
        }
        return result;
    }

    @Test
    public void test() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        System.out.println(Arrays.toString(reversePrint(node)));
    }
}
