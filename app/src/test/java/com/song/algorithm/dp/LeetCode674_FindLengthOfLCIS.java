package com.song.algorithm.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * 674. 最长连续递增序列
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 * <p>
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * <p>
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,5,4,7]
 * 输出：3
 * 解释：最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2]
 * 输出：1
 * 解释：最长连续递增序列是 [2], 长度为1。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 */
public class LeetCode674_FindLengthOfLCIS {

    /**
     * 动态规划
     * 1. dp[i] 表示包含 0 到 i，包含 nums[i] 的最长连续递增序列
     * 2. dp[i] = dp[i-1] + 1（dp[i] > dp[i-1]）
     * 3. 初始化为 1
     * 4. 从前向后遍历
     *
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        int result = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            result = Math.max(result, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return result;
    }

    /**
     * 贪心算法
     *
     * @param nums
     * @return
     */
    public int findLengthOfLCIS2(int[] nums) {
        int result = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            result = Math.max(result, count);
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(findLengthOfLCIS2(new int[]{1, 3, 5, 7}));
    }

}
