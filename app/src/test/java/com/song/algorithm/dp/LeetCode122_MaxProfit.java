package com.song.algorithm.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * 122. 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * <p>
 * 给定一个数组 prices ，其中 prices[i] 表示股票第 i 天的价格。
 * <p>
 * 在每一天，你可能会决定购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以购买它，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: prices = [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 * <p>
 * 输入: prices = [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 * <p>
 * 输入: prices = [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 3 * 104
 * 0 <= prices[i] <= 104
 */
public class LeetCode122_MaxProfit {

    /**
     * 动态规划
     * 1. dp[i][0] 表示第 i 天持有股票金额，dp[i][1] 表示第 i 天不持有股票金额
     * 2. 状态转移方程，dp[i][0] = max(dp[i-1][0], dp[i-1][1] - prices[i]), dp[i][1] = max(dp[i-1][1], prices[i] + dp[i-1][0])
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
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
        }
        for (int[] item : dp) {
            System.out.println(Arrays.toString(item));
        }
        return dp[prices.length - 1][1];
    }

    /**
     * 动态规划
     * 1. dp[i][0] 表示第 i 天持有股票金额，dp[i][1] 表示第 i 天不持有股票金额
     * 2. 状态转移方程，dp[i][0] = max(dp[i-1][0], dp[i-1][1] - prices[i]), dp[i][1] = max(dp[i-1][1], prices[i] + dp[i-1][0])
     * 3. 初始化 dp[0][0] = -prices[0], dp[0][1] = 0
     * 4. 遍历顺序从前到后
     * 5. 推导 dp 数组
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int[][] dp = new int[2][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i % 2][0] = Math.max(dp[(i - 1) % 2][0], dp[(i - 1) % 2][1] - prices[i]);
            dp[i % 2][1] = Math.max(dp[(i - 1) % 2][1], prices[i] + dp[(i - 1) % 2][0]);
        }
        for (int[] item : dp) {
            System.out.println(Arrays.toString(item));
        }
        return dp[(prices.length - 1) % 2][1];
    }

    /**
     * 贪心算法
     *
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result += Math.max(0, prices[i] - prices[i - 1]);
        }
        return result;

    }

    @Test
    public void test() {
        System.out.println(maxProfit(new int[]{4, 3, 2, 1}));
        System.out.println(maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit3(new int[]{7, 1, 5, 3, 6, 4}));
    }

}
