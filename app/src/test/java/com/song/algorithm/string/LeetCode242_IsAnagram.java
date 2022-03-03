package com.song.algorithm.string;

import org.junit.Test;

/**
 * 242. 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 */
public class LeetCode242_IsAnagram {

    /**
     * 哈希表
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(isAnagram("abc", "cba"));
    }

}
