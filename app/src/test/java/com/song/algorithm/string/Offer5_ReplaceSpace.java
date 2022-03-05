package com.song.algorithm.string;

import org.junit.Test;

/**
 * 剑指 Offer 05. 替换空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * <p>
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 10000
 */
public class Offer5_ReplaceSpace {

    public String replaceSpace(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count++;
            }
        }
        char[] result = new char[s.length() + count * 2];
        for (int i = 0, j = 0; i < s.length(); i++, j++) {
            if (s.charAt(i) == ' ') {
                result[j++] = '%';
                result[j++] = '2';
                result[j] = '0';
            } else {
                result[j] = s.charAt(i);
            }
        }
        return new String(result);
    }

    @Test
    public void test() {
        System.out.println(replaceSpace("We are happy."));
    }

}
