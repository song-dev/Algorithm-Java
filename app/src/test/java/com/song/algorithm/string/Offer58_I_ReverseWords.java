package com.song.algorithm.string;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 剑指 Offer 58 - I. 翻转单词顺序
 * https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof
 *
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 注意：本题与主站 151 题相同：https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */
public class Offer58_I_ReverseWords {

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        // 移除多余空格 快慢指针
        char[] chars = s.toCharArray();
        int p = 0;
        for (int i = 0; i < chars.length; i++) {
            for (; i < chars.length && chars[i] != ' '; i++) {
                if (i != p) {
                    chars[p] = chars[i];
                    chars[i] = ' ';
                }
                p++;
            }
            if (p > 0 && chars[p - 1] != ' ') {
                p++;
            }
        }
        // 将字符串反转
        int left = 0, right = p - 2, end = right;
        System.out.println("end:" + chars[end]);
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        // 将单词反转
        for (int i = 0, j = 0; i <= end + 1; i++) {
            if (i == end + 1 || chars[i] == ' ') {
                int k = i - 1;
                while (j < k) {
                    char temp = chars[j];
                    chars[j] = chars[k];
                    chars[k] = temp;
                    j++;
                    k--;
                }
                j = i + 1;
            }
        }
        return new String(chars, 0, end + 1);
    }

    public String reverseWords2(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    @Test
    public void test() {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords2("the sky is blue"));
    }
}
