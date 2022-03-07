package com.song.algorithm.stackandqueue;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 20. 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 * <p>
 * 输入：s = "{[]}"
 * 输出：true
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class LeetCode20_IsValid {

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{') {
                deque.push('}');
            } else if (c == '[') {
                deque.push(']');
            } else if (c == '(') {
                deque.push(')');
            } else if (!deque.isEmpty() && deque.peek() == c) {
                deque.pop();
            } else {
                return false;
            }
        }
        return deque.isEmpty();
    }

    @Test
    public void test() {
        System.out.println(isValid("{[()]}"));
        System.out.println(isValid("{[()]}}"));
    }

}
