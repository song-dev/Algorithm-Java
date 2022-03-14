package com.song.algorithm.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * 416. 分割等和子集
 * https://leetcode-cn.com/problems/partition-equal-subset-sum
 * <p>
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
public class LeetCode416_CanPartition {

    /**
     * 01 背包问题
     * 1. dp[i] 表示第 i 位置 dp[i] 最大和
     * 2. dp[i] = max(dp[i], dp[i - nums[i] + nums[i]])
     * 3. 初始化第一行
     * 4. 必须倒叙，否则存在重复添加的可能性
     * 5. 推导 dp 数组
     * 时间复杂度 O(m*n)
     * 空间复杂度 O(n)
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        int m = nums.length, n = target + 1;
        int[] dp = new int[n];
        for (int j = nums[0]; j <= target; j++) {
            dp[j] = nums[0];
        }
        System.out.println(Arrays.toString(dp));
        for (int i = 1; i < m; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[target] == target;
    }

    @Test
    public void test() {
        System.out.println(canPartition(new int[]{1, 3, 2, 2}));
    }

}
