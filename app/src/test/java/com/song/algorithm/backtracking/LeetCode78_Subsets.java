package com.song.algorithm.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 * https://leetcode-cn.com/problems/subsets/
 * <p>
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 */
public class LeetCode78_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        result.clear();
        path.clear();
        backtracking(nums, 0);
        return result;
    }

    private final List<List<Integer>> result = new ArrayList<>();
    private final LinkedList<Integer> path = new LinkedList<>();

    public void backtracking(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }

    @Test
    public void test() {
        for (List<Integer> item : subsets(new int[]{1, 2, 3})) {
            System.out.println(Arrays.toString(item.toArray()));
        }
    }

}
