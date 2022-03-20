package com.song.algorithm.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 131. 分割回文串
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 * <p>
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 * <p>
 * 输入：s = "a"
 * 输出：[["a"]]
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 */
public class LeetCode131_Partition {

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return result;
    }

    private final List<List<String>> result = new ArrayList<>();
    private final LinkedList<String> path = new LinkedList<>();

    public void backtracking(String s, int startIndex) {
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                path.add(s.substring(startIndex, i + 1));
            } else {
                continue;
            }
            backtracking(s, i + 1);
            path.removeLast();
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        for (List<String> item : partition("aabaa")) {
            System.out.println(Arrays.toString(item.toArray()));
        }
    }

}
