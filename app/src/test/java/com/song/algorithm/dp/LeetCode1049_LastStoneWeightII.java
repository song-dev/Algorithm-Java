package com.song.algorithm.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * 1049. 最后一块石头的重量 II
 * https://leetcode-cn.com/problems/last-stone-weight-ii/
 * <p>
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 * <p>
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 * <p>
 * 示例 1：
 * <p>
 * 输入：stones = [2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 * 示例 2：
 * <p>
 * 输入：stones = [31,26,33,21,40]
 * 输出：5
 * 示例 3：
 * <p>
 * 输入：stones = [1,2]
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 100
 */
public class LeetCode1049_LastStoneWeightII {

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
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int num : stones) {
            sum += num;
        }
        int target = sum / 2;
        int m = stones.length, n = target + 1;
        int[] dp = new int[n];
        for (int j = stones[0]; j <= target; j++) {
            dp[j] = stones[0];
        }
        System.out.println(Arrays.toString(dp));
        for (int i = 1; i < m; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
            System.out.println(Arrays.toString(dp));
        }
        return Math.abs(sum - 2 * dp[target]);
    }

    @Test
    public void test() {
        System.out.println(lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}));
    }

}
