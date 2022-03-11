package com.song.algorithm.string;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 面试题50. 第一个只出现一次的字符
 * <p>
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * <p>
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入：s = "abaccdeff"
 * 输出：'b'
 * 示例 2:
 * <p>
 * 输入：s = ""
 * 输出：' '
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 50000
 */
public class Interview50_FirstChar {

    /**
     * 时间复杂度 O(n)
     *
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return ' ';
    }

    public char firstUniqChar2(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            arr[c]++;
        }
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (arr[c] == 1) {
                return (char) ('a' + c);
            }
        }
        return ' ';
    }

    @Test
    public void test() {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
        System.out.println(firstUniqChar2(s));
    }

}
