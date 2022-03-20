package com.song.algorithm.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 * <p>
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * <p>
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 * <p>
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 20
 * s 仅由数字组成
 */
public class LeetCode93_RestoreIpAddresses {

    private final List<String> result = new ArrayList<>();
    private final LinkedList<String> path = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        result.clear();
        path.clear();
        backtracking(s, 0);
        return result;
    }

    public void backtracking(String s, int startIndex) {
        if (startIndex >= s.length() && path.size() == 4) {
            result.add(String.join(".", path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isMatches(s, startIndex, i)) {
                path.add(s.substring(startIndex, i + 1));
            } else {
                continue;
            }
            backtracking(s, i + 1);
            path.removeLast();
        }
    }

    private boolean isMatches(String s, int left, int right) {
        String str = s.substring(left, right + 1);
        if (str.length() > 1 && str.charAt(0) == '0') {
            return false;
        }
        return str.length() <= 3 && Integer.parseInt(str) <= 255;
    }

    public List<String> restoreIpAddresses2(String s) {
        if (s.length() > 12 || s.length() < 4) {
            return result;
        }
        result.clear();
        path.clear();
        backtracking2(s, 0);
        return result;
    }

    /**
     * 剪枝操作
     *
     * @param s
     * @param startIndex
     */
    public void backtracking2(String s, int startIndex) {
        if (startIndex >= s.length() && path.size() == 4) {
            result.add(String.join(".", path));
            return;
        }
        for (int i = startIndex; i < s.length() && path.size() < 4; i++) {
            if (isMatches(s, startIndex, i)) {
                path.add(s.substring(startIndex, i + 1));
            } else {
                continue;
            }
            backtracking(s, i + 1);
            path.removeLast();
        }
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(restoreIpAddresses("25525511135").toArray()));
        System.out.println(Arrays.toString(restoreIpAddresses("101023").toArray()));
        System.out.println(Arrays.toString(restoreIpAddresses2("101023").toArray()));
    }

}
