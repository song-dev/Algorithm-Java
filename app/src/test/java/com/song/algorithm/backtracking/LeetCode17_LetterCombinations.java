package com.song.algorithm.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * <p>
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * <p>
 * 提示：
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class LeetCode17_LetterCombinations {

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }
        backtracking(digits, 0);
        return result;
    }

    private final List<String> result = new ArrayList<>();
    private final StringBuffer path = new StringBuffer();
    private final String[] numArr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private void backtracking(String digits, int startIndex) {
        if (path.length() == digits.length()) {
            result.add(path.toString());
            return;
        }
        String word = numArr[digits.charAt(startIndex) - '0'];
        for (int i = 0; i < word.length(); i++) {
            path.append(word.charAt(i));
            backtracking(digits, startIndex + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(letterCombinations("").toArray()));
    }


}
