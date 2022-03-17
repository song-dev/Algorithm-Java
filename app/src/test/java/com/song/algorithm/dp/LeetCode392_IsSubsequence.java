package com.song.algorithm.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * 392. 判断子序列
 * https://leetcode-cn.com/problems/is-subsequence/
 * <p>
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 进阶：
 * <p>
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * <p>
 * 致谢：
 * <p>
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * 两个字符串都只由小写字符组成。
 */
public class LeetCode392_IsSubsequence {

    /**
     * 非连续子集 动态规划
     * 1. dp[i][j] 表示 s[i-1] t[j-1] 结尾的字符串最长非连续公共子集长度
     * 2. 若 s[i - 1] == t[j - 1]，则表示最后字符相同，dp[i][j] = dp[i - 1][j - 1] + 1；否则 dp[i][j] = dp[i][j - 1]（必须保护 s[i]）
     * 3. 初始化为 0
     * 4. 从前向后遍历
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); 不包含 s[i]
                    dp[i][j] = dp[i][j - 1]; // 包含 s[i]
                }
            }
        }
        for (int[] item : dp) {
            System.out.println(Arrays.toString(item));
        }
        return dp[s.length()][t.length()] == s.length();
    }

    /**
     * 双指针
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence2(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    @Test
    public void test() {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence2("abc", "ahbgdc"));
    }

}
