package com.song.algorithm.stackandqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 225. 用队列实现栈
 * https://leetcode-cn.com/problems/implement-stack-using-queues
 * <p>
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * <p>
 * 实现 MyStack 类：
 * <p>
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 *  
 * <p>
 * 注意：
 * <p>
 * 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
 * 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 2, 2, false]
 * <p>
 * 解释：
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // 返回 2
 * myStack.pop(); // 返回 2
 * myStack.empty(); // 返回 False
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= x <= 9
 * 最多调用100 次 push、pop、top 和 empty
 * 每次调用 pop 和 top 都保证栈不为空
 *  
 * <p>
 * 进阶：你能否仅用一个队列来实现栈。
 */
public class LeetCode225_StackByQueue {

    static class MyStack {

        private Deque<Integer> deque;

        public MyStack() {
            this.deque = new LinkedList<Integer>();
        }

        /**
         * 入栈
         *
         * @param x
         */
        public void push(int x) {
            deque.push(x);
        }

        /**
         * 移除并返回栈顶元素
         *
         * @return
         */
        public int pop() {
            for (int i = 0; i < deque.size() - 1; i++) {
                deque.push(deque.poll());
            }
            return deque.poll();
        }

        /**
         * 返回栈顶元素
         *
         * @return
         */
        public int top() {
            for (int i = 0; i < deque.size() - 1; i++) {
                deque.push(deque.poll());
            }
            return deque.peek();
        }

        /**
         * 判断栈是否为空
         *
         * @return
         */
        public boolean empty() {
            return deque.isEmpty();
        }
    }

}
