package com.song.algorithm.array;

import org.junit.Test;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 * <p>
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 * <p>
 * 示例1:
 * <p>
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 */
public class Offer42_MaxSubArray {

    /**
     * 动态规划算法
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        // 1. dp[i] 表示以 nums[i] 为结尾的最大子数组之和
        // 2. dp[i - 1] > 0, dp[i] = dp[i-1] + nums[i]
        // 3. dp[i - 1] <= 0, dp[i] = nums[i]
        // 4. 函数 dp[i] = max(nums[i], dp[i-1] + nums[i])
        // 5. 遍历顺序从前到后
        // 6. 初始化值 dp[0] = nums[0]
        // 7. 推导 dp 数组
        if (nums.length == 0) {
            return nums[0];
        }
        int p = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            p = Math.max(nums[i], p + nums[i]);
            res = Math.max(res, p);
            System.out.println("i: " + i + ", " + p + ", " + res);
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
