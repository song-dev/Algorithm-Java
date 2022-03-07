package com.song.algorithm.stackandqueue;

import org.junit.Test;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * https://leetcode-cn.com/problems/implement-queue-using-stacks
 * <p>
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * <p>
 * 实现 MyQueue 类：
 * <p>
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 * <p>
 * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 1, 1, false]
 * <p>
 * 解释：
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= x <= 9
 * 最多调用 100 次 push、pop、peek 和 empty
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
 */
public class LeetCode232_QueueByStack {

    static class MyQueue {

        private Stack<Integer> left;
        private Stack<Integer> right;

        public MyQueue() {
            this.left = new Stack<Integer>();
            this.right = new Stack<Integer>();
        }

        /**
         * 将数据 push 到队列末尾
         *
         * @param x
         */
        public void push(int x) {
            left.push(x);
        }

        /**
         * 返回队列头部数据，且出队列
         *
         * @return
         */
        public int pop() {
            if (right.empty()) {
                while (!left.empty()) {
                    right.push(left.pop());
                }
            }
            return right.pop();

        }

        /**
         * 返回队列头部数据，且不出队列
         *
         * @return
         */
        public int peek() {
            if (right.empty()) {
                while (!left.empty()) {
                    right.push(left.pop());
                }
            }
            return right.peek();
        }

        /**
         * 判断队列是否为空
         *
         * @return
         */
        public boolean empty() {
            return left.empty() && right.empty();
        }
    }

    @Test
    public void test() {

    }
}
