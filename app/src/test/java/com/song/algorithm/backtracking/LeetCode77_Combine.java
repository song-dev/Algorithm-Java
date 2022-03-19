package com.song.algorithm.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * https://leetcode-cn.com/problems/combinations/
 * <p>
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 示例 2：
 * <p>
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class LeetCode77_Combine {

    public List<List<Integer>> combine(int n, int k) {
        backtracking2(n, k, 1);
        return result;
    }

    private final LinkedList<Integer> path = new LinkedList<>();
    private final List<List<Integer>> result = new ArrayList<>();

    private void backtracking(int n, int k, int startIndex) {
        // 结束判断
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        // 循环判断 n 决定宽度
        for (int i = startIndex; i <= n; i++) {
            path.addLast(i);
            backtracking(n, k, i + 1);
            path.pollLast();
        }
    }

    /**
     * 剪枝操作
     *
     * @param n
     * @param k
     * @param startIndex
     */
    private void backtracking2(int n, int k, int startIndex) {
        // 结束判断
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        // 剪枝操作，最起码还需要 k - path.size() 节点，但是当前从 startIndex 开始遍历，则最起码 n - (k - path.size()) + 1 前结束才有效
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.addLast(i);
            backtracking(n, k, i + 1);
            path.pollLast();
        }
    }

    @Test
    public void test() {
        List<List<Integer>> list = combine(4, 2);
        for (List<Integer> item : list) {
            System.out.println(Arrays.toString(item.toArray()));
        }
    }

}
