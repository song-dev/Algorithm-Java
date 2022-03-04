package com.song.algorithm.hash;

import org.junit.Test;

/**
 * 383. 赎金信
 * https://leetcode-cn.com/problems/ransom-note/
 * <p>
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * <p>
 * 如果可以，返回 true ；否则返回 false 。
 * <p>
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote 和 magazine 由小写英文字母组成
 */
public class LeetCode383_CanConstruct {

    /**
     * 哈希表
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] aar = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            aar[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            aar[index]--;
            if (aar[index] < 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(canConstruct("aa", "aab"));
    }

}
