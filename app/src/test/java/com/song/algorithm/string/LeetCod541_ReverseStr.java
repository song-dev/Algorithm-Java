package com.song.algorithm.string;

import org.junit.Test;

/**
 * 541. 反转字符串 II
 * https://leetcode-cn.com/problems/reverse-string-ii/
 * <p>
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 * <p>
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由小写英文组成
 * 1 <= k <= 104
 */
public class LeetCod541_ReverseStr {

    public String reverseStr(String s, int k) {
        char[] result = s.toCharArray();
        for (int i = 0; i < result.length; i++) {
            if ((i / k) % 2 == 0) {
                int left = i, right = Math.min(i + k - 1, result.length - 1);
                int right_remain = right;
                while (left < right) {
                    char temp = result[left];
                    result[left] = result[right];
                    result[right] = temp;
                    left++;
                    right--;
                }
                i = right_remain;
            } else {
                i = i + k - 1;
            }
        }
        return new String(result);
    }

    @Test
    public void test() {
        System.out.println(reverseStr("abcdefg", 2));
    }
}
