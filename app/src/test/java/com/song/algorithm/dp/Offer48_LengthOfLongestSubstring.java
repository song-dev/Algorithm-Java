package com.song.algorithm.dp;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 * <p>
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 提示：
 * <p>
 * s.length <= 40000
 */
public class Offer48_LengthOfLongestSubstring {

    /**
     * 动态规划 + 线性遍历
     * 1. dp[i] 表示包含 i 的最长不重复字符串
     * 2. 状态转移方程，假设 j 为 dp[i] 的最左边位置，若 s[i]==s[j] 则 dp[i]=dp[i-1]+1 (dp[i-1]<j-i), dp[i]=j-i (dp[i-1]>=j-i)
     * 3. dp[0] = 1
     * 4. 从前向后遍历
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            int j = i - 1;
            while (j >= 0 && s.charAt(j) != s.charAt(i)) {
                j--;
            }
            if (dp[i - 1] < i - j) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = i - j;
            }
            res = Math.max(res, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return res;
    }

    /**
     * 滚动数组
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int res = 0, q = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = i - 1;
            while (j >= 0 && s.charAt(j) != s.charAt(i)) {
                // 线性查找 j
                j--;
            }
            // dp[i - 1] -> dp[i]
            q = q < i - j ? q + 1 : i - j;
            // max(dp[i - 1], dp[i])
            res = Math.max(res, q);
        }
        return res;
    }

    /**
     * 动态规划 + 哈希表
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0, q = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = map.getOrDefault(s.charAt(i), -1);
            map.put(s.charAt(i), i);
            q = q < i - j ? q + 1 : i - j;
            res = Math.max(res, q);
        }
        return res;
    }

    /**
     * 双指针 + 哈希表
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring4(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (dic.containsKey(s.charAt(j))) {
                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
            }
            dic.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(lengthOfLongestSubstring3("abcabcbb"));
        System.out.println(lengthOfLongestSubstring4("abcabcbb"));
    }

}
