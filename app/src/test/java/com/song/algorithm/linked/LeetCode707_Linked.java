package com.song.algorithm.linked;

import org.junit.Test;

/**
 * 707. 设计链表
 * https://leetcode-cn.com/problems/design-linked-list/
 * <p>
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * <p>
 * 在链表类中实现这些功能：
 * <p>
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *  
 * <p>
 * 示例：
 * <p>
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 *  
 * <p>
 * 提示：
 * <p>
 * 所有val值都在 [1, 1000] 之内。
 * 操作次数将在  [1, 1000] 之内。
 * 请不要使用内置的 LinkedList 库。
 */
public class LeetCode707_Linked {

    static class MyLinkedList {

        static class ListNode {
            public int val;
            public ListNode next;
            public ListNode prev;

            public ListNode(int val) {
                this.val = val;
            }
        }

        public int size;
        private ListNode head;
        private ListNode tail;

        public MyLinkedList() {
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            int count = 0;
            ListNode cur;
            if (index > size / 2) {
                cur = tail;
                while (count < size - index - 1) {
                    cur = cur.prev;
                    count++;
                }
            } else {
                cur = head;
                while (count < index) {
                    cur = cur.next;
                    count++;
                }
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            ListNode node = new ListNode(val);
            if (size == 0) {
                head = node;
                tail = node;
            } else {
                node.next = head;
                head.prev = node;
                head = node;
            }
            size++;
        }

        public void addAtTail(int val) {
            ListNode node = new ListNode(val);
            if (size == 0) {
                head = node;
            } else {
                node.prev = tail;
                tail.next = node;
            }
            tail = node;
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) {
                return;
            }
            if (index == 0) {
                addAtHead(val);
                return;
            }
            if (index == size) {
                addAtTail(val);
                return;
            }
            int count = 0;
            ListNode cur;
            if (index > size / 2) {
                cur = tail;
                while (count < size - index - 1) {
                    cur = cur.prev;
                    count++;
                }
            } else {
                cur = head;
                while (count < index) {
                    cur = cur.next;
                    count++;
                }
            }
            // 插入到 cur 前面
            ListNode node = new ListNode(val);
            node.prev = cur.prev;
            node.next = cur;
            node.prev.next = node;
            node.next.prev = node;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (size == 0 || index < 0 || index >= size) {
                return;
            }
            if (size == 1) {
                head = tail = null;
                size--;
                return;
            }
            // 删除头节点
            if (index == 0) {
                head = head.next;
                head.prev = null;
                size--;
                return;
            }
            // 删除尾节点
            if (index == size - 1) {
                tail = tail.prev;
                tail.next = null;
                size--;
                return;
            }
            int count = 0;
            ListNode cur;
            if (index > size / 2) {
                cur = tail;
                while (count < size - index - 1) {
                    cur = cur.prev;
                    count++;
                }
            } else {
                cur = head;
                while (count < index) {
                    cur = cur.next;
                    count++;
                }
            }
            //
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            size--;
        }
    }

    @Test
    public void test() {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(7);
        list.addAtHead(2);
        list.addAtHead(1);
        list.addAtIndex(3, 0);
        list.deleteAtIndex(2);
        list.addAtHead(6);
        list.addAtTail(4);
        {
            MyLinkedList.ListNode cur = list.head;
            while (cur != null) {
                System.out.println("For: " + cur.val);
                cur = cur.next;
            }
        }
        System.out.println(list.get(4));
        list.addAtHead(4);
        list.addAtIndex(5, 0);
        list.addAtHead(6);

        {
            MyLinkedList.ListNode cur = list.head;
            while (cur != null) {
                System.out.println("For: " + cur.val);
                cur = cur.next;
            }
        }
    }

}
