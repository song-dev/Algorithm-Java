package com.song.algorithm.string;

import org.junit.Test;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * <p>
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * 示例 2：
 * <p>
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= k < s.length <= 10000
 */
public class Offer58_ReverseLeftWords {

    /**
     * 反转两个子串后总体反转
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        char[] array = s.toCharArray();
        int left = 0, right = n - 1;
        reverseWord(array, left, right);
        left = n;
        right = array.length - 1;
        reverseWord(array, left, right);
        left = 0;
        right = array.length - 1;
        reverseWord(array, left, right);
        return new String(array);
    }

    private void reverseWord(char[] array, int left, int right) {
        while (left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }


    public String reverseLeftWords2(String s, int n) {
        char[] array = s.toCharArray();
        int len = array.length;
        char c = array[0];
        int j = 0;
        for (int i = 0; i < len; i++) {
            char temp;
            int t;
            if (j < n) {
                // 左边计算
                t = len - (n - j);
            } else {
                // 右边计算
                t = j - n;
            }
            temp = array[t];
            array[t] = c;
            j = t;
            c = temp;
            System.out.println(new String(array));
        }
        return new String(array);
    }

    @Test
    public void test() {
        System.out.println(reverseLeftWords("lrloseumgh", 6));
    }

}
