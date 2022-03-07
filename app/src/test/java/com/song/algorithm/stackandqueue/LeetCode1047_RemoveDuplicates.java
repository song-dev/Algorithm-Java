package com.song.algorithm.stackandqueue;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1047. 删除字符串中的所有相邻重复项
 * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 * <p>
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * <p>
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * <p>
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 */
public class LeetCode1047_RemoveDuplicates {

    public String removeDuplicates(String s) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!deque.isEmpty() && deque.peek() == c) {
                deque.pop();
            } else {
                deque.push(c);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!deque.isEmpty()) {
            result.insert(0, deque.pop());
        }
        return result.toString();
    }

    public String removeDuplicates2(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int len = result.length();
            if (len > 0 && result.charAt(len - 1) == c) {
                result.deleteCharAt(len - 1);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    @Test
    public void test() {
        System.out.println(removeDuplicates("abbaca"));
        System.out.println(removeDuplicates2("abbaca"));
    }

}
