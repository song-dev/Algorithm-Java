package com.song.algorithm.stackandqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * <p>
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 * <p>
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 * <p>
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 */
public class Offer09_StackByQueue {

    static class CQueue {

        private final Deque<Integer> dequeLeft;
        private final Deque<Integer> dequeRight;

        public CQueue() {
            dequeLeft = new LinkedList<>();
            dequeRight = new LinkedList<>();
        }

        public void appendTail(int value) {
            dequeLeft.push(value);
        }

        public int deleteHead() {
            if (dequeLeft.isEmpty() && dequeRight.isEmpty()) {
                return -1;
            }
            if (dequeRight.isEmpty()) {
                while (!dequeLeft.isEmpty()) {
                    dequeRight.push(dequeLeft.poll());
                }
            }
            return dequeRight.pop();
        }
    }

}
