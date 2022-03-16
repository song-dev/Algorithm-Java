package com.song.algorithm.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * 121. 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * <p>
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */
public class LeetCode121_MaxProfit {

    /**
     * 动态规划
     * 1. dp[i][0] 表示第 i 天持有股票金额，dp[i][1] 表示第 i 天不持有股票金额
     * 2. 状态转移方程，dp[i][0] = max(dp[i-1][0], -prices[i]), dp[i][1] = max(dp[i-1][1], prices[i] + dp[i-1][0])
     * 3. 初始化 dp[0][0] = -prices[0], dp[0][1] = 0
     * 4. 遍历顺序从前到后
     * 5. 推导 dp 数组
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
        }
        for (int[] item : dp) {
            System.out.println(Arrays.toString(item));
        }
        return Math.max(0, dp[prices.length - 1][1]);
    }

    /**
     * 动态规划
     * 1. dp[i][0] 表示第 i 天持有股票金额，dp[i][1] 表示第 i 天不持有股票金额
     * 2. 状态转移方程，dp[i][0] = max(dp[i-1][0], prices[i]), dp[i][1] = max(dp[i-1][1], prices[i] + dp[i-1][0])
     * 3. 初始化 dp[0][0] = -prices[0], dp[0][1] = 0
     * 4. 遍历顺序从前到后
     * 5. 推导 dp 数组
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int[][] dp = new int[2][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i % 2][0] = Math.max(dp[(i - 1) % 2][0], -prices[i]);
            dp[i % 2][1] = Math.max(dp[(i - 1) % 2][1], prices[i] + dp[(i - 1) % 2][0]);
        }
        for (int[] item : dp) {
            System.out.println(Arrays.toString(item));
        }
        return Math.max(0, dp[(prices.length - 1) % 2][1]);
    }

    /**
     * 贪心算法
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int result = 0;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            min = Math.min(min, price);
            result = Math.max(price - min, result);
        }
        return result;
    }

    /**
     * 暴力算法
     *
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    result = Math.max(result, prices[j] - prices[i]);
                }
            }
        }
        return Math.max(result, 0);
    }

    @Test
    public void test() {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit1(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit3(new int[]{7, 1, 5, 3, 6, 4}));
    }

}
