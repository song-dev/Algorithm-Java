package com.song.algorithm.linked;

import org.junit.Test;

/**
 * 面试题 02.07. 链表相交
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/
 * <p>
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * <p>
 * 图示两个链表在节点 c1 开始相交：
 * <p>
 * <p>
 * <p>
 * 题目数据 保证 整个链式结构中不存在环。
 * <p>
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Intersected at '2'
 * 解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
 * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
 * 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 这两个链表不相交，因此返回 null 。
 *  
 * <p>
 * 提示：
 * <p>
 * listA 中节点数目为 m
 * listB 中节点数目为 n
 * 0 <= m, n <= 3 * 104
 * 1 <= Node.val <= 105
 * 0 <= skipA <= m
 * 0 <= skipB <= n
 * 如果 listA 和 listB 没有交点，intersectVal 为 0
 * 如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1]
 *  
 * <p>
 * 进阶：你能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？
 */
public class Interview0207_GetIntersectionNode {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode one = headA;
        ListNode two = headB;
        int lenA = 0;
        int lenB = 0;
        while (one != null) {
            one = one.next;
            lenA++;
        }
        while (two != null) {
            two = two.next;
            lenB++;
        }
        one = headA;
        two = headB;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                one = one.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                two = two.next;
            }
        }
        while (one != null) {
            if (one == two) {
                return one;
            }
            one = one.next;
            two = two.next;
        }
        return null;
    }

    @Test
    public void test() {
        ListNode one = new ListNode(1);
        one.next = new ListNode(2);
        one.next.next = new ListNode(3);
        one.next.next.next = new ListNode(4);
        ListNode two = new ListNode(1);
        two.next = one.next.next;
        System.out.println(getIntersectionNode(one, two).val);
    }
}
