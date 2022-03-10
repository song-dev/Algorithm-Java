package com.song.algorithm.stackandqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 30. 包含min函数的栈
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
 * <p>
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 * <p>
 * 提示：
 * <p>
 * 各函数的调用总次数不超过 20000 次
 */
public class Offer30_MinStack {

    static class MinStack {

        private Deque<Integer> deque;
        private Deque<Integer> minDeque;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            deque = new LinkedList<>();
            minDeque = new LinkedList<>();
        }

        public void push(int x) {
            deque.push(x);
            if (minDeque.isEmpty() || minDeque.peek() >= x) {
                minDeque.push(x);
            }
        }

        public void pop() {
            int val = deque.pop();
            if (val == minDeque.peek()) {
                minDeque.pop();
            }
        }

        public int top() {
            return deque.peek();
        }

        public int min() {
            return minDeque.peek();
        }
    }

}
