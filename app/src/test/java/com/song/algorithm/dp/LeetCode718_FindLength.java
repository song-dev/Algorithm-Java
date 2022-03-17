package com.song.algorithm.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * 718. 最长重复子数组
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 * <p>
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * 输出：3
 * 解释：长度最长的公共子数组是 [3,2,1] 。
 * 示例 2：
 * <p>
 * 输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
 * 输出：5
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 100
 */
public class LeetCode718_FindLength {

    /**
     * 动态规划
     * 1. dp[i][j] 为 包含 nums1[i] nums2[j] 最长连续子数组
     * 2. 若 nums1[i-1] == nums2[j-1], 则 dp[i][j] = dp[i-1][j-1] + 1, 否则为 0
     * 3. 初始值为 0
     * 4. 从前向后遍历
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength(int[] nums1, int[] nums2) {
        int result = 0;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        for (int[] item : dp) {
            System.out.println(Arrays.toString(item));
        }
        return result;
    }

    /**
     * 动态规划 滚动数组
     * 1. dp[i][j] 为 包含 nums1[i] nums2[j] 最长连续子数组
     * 2. 若 nums1[i-1] == nums2[j-1], 则 dp[i][j] = dp[i-1][j-1] + 1, 否则为 0
     * 3. 初始值为 0
     * 4. 从后向前遍历
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength2(int[] nums1, int[] nums2) {
        int result = 0;
        int[] dp = new int[nums2.length + 1];
        System.out.println(Arrays.toString(dp));
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = nums2.length; j >= 1; j--) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                }else {
                    dp[j] = 0;
                }
                result = Math.max(result, dp[j]);
            }
            System.out.println(Arrays.toString(dp));
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
        System.out.println(findLength2(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }

}
