package com.song.algorithm.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 491. 递增子序列
 * https://leetcode-cn.com/problems/increasing-subsequences/
 * <p>
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 * <p>
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,6,7,7]
 * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * 示例 2：
 * <p>
 * 输入：nums = [4,4,3,2,1]
 * 输出：[[4,4]]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 15
 * -100 <= nums[i] <= 100
 */
public class LeetCode491_FindSubsequences {

    public List<List<Integer>> findSubsequences(int[] nums) {
        result.clear();
        path.clear();
        backtracking(nums, 0);
        return result;
    }

    private final List<List<Integer>> result = new ArrayList<>();
    private final LinkedList<Integer> path = new LinkedList<>();

    public void backtracking(int[] nums, int startIndex) {
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
        }
        // 也可用 set 集合去重
        int[] used = new int[201];
        for (int i = startIndex; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.getLast()
                    || (used[nums[i] + 100] == 1)) {
                continue;
            }
            used[nums[i] + 100] = 1;
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }

    @Test
    public void test() {
        for (List<Integer> item : findSubsequences(new int[]{4, 6, 7, 7})) {
            System.out.println(Arrays.toString(item.toArray()));
        }
        for (List<Integer> item : findSubsequences(new int[]{4, 4, 3, 2, 1})) {
            System.out.println(Arrays.toString(item.toArray()));
        }
    }

}
