package com.song.algorithm.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 40. 组合总和 II
 * https://leetcode-cn.com/problems/combination-sum-ii/
 * <p>
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * <p>
 * 注意：解集不能包含重复的组合。
 * <p>
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * <p>
 * 提示:
 * <p>
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
public class LeetCode40_CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result.clear();
        path.clear();
        Arrays.sort(candidates);
        boolean[] flag = new boolean[candidates.length];
        backtracking(candidates, target, 0, 0, flag);
        return result;
    }

    private final List<List<Integer>> result = new ArrayList<>();
    private final LinkedList<Integer> path = new LinkedList<>();

    private void backtracking(int[] candidates, int target, int startIndex, int sum, boolean[] flag) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && !flag[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            flag[i] = true;
            backtracking(candidates, target, i + 1, sum, flag);
            flag[i] = false;
            sum -= path.removeLast();
        }
    }

    public List<List<Integer>> combinationSum3(int[] candidates, int target) {
        Arrays.sort(candidates);
        result.clear();
        path.clear();
        backtracking2(candidates, target, 0, 0);
        return result;
    }

    /**
     * 剪枝操作，在排序数组中若 sum 大于 target 则直接跳出本次 for 循环
     *
     * @param candidates
     * @param target
     * @param startIndex
     */
    private void backtracking2(int[] candidates, int target, int startIndex, int sum) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length && sum <= target; i++) {
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            backtracking2(candidates, target, i + 1, sum);
            sum -= path.removeLast();
        }
    }

    @Test
    public void test() {
        List<List<Integer>> list = combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        for (List<Integer> item : list) {
            System.out.println(Arrays.toString(item.toArray()));
        }
        List<List<Integer>> list1 = combinationSum3(new int[]{2, 5, 2, 1, 2}, 5);
        for (List<Integer> item : list1) {
            System.out.println(Arrays.toString(item.toArray()));
        }
    }

}
