package com.song.algorithm.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * 01 背包问题
 */
public class Bag01 {

    /**
     * 动态规划
     * 1. dp[i][j] 表示 0...i 个物品，且背包容量 j 时候最大价值
     * 2. dp[i][j] = max(dp[i-1][j], dp[i-1][j-weight[i] + value[i]])
     * 3. 初始化 dp[i][0] = 0, dp[0][j] = value[0](满足 j>weight[0])
     * 4. 从前到后遍历
     * 5. 推导 dp 数组
     *
     * @param weight    物品重量
     * @param value     物品的价值
     * @param weightBag 背包的承载重量
     * @return 最大价值
     */
    public int bagProblem(int[] weight, int[] value, int weightBag) {
        int m = weight.length, n = weightBag + 1;
        int[][] dp = new int[m][n];
        for (int j = weight[0]; j < n; j++) {
            dp[0][j] = value[0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 滚动数组
     *
     * @param weight
     * @param value
     * @param weightBag
     * @return
     */
    public int bagProblem2(int[] weight, int[] value, int weightBag) {
        int m = weight.length, n = weightBag + 1;
        int[] dp = new int[n];
        for (int j = weight[0]; j < n; j++) {
            dp[j] = value[0];
        }
        System.out.println(Arrays.toString(dp));
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (j < weight[i]) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[n - 1];
    }

    /**
     * TODO 存在物品被重复放入的可能性
     *
     * @param weight
     * @param value
     * @param weightBag
     * @return
     */
    @Deprecated
    public int bagProblem3(int[] weight, int[] value, int weightBag) {
        int m = weight.length, n = weightBag + 1;
        int[] dp = new int[n];
        for (int j = weight[0]; j < n; j++) {
            dp[j] = value[0];
        }
        System.out.println(Arrays.toString(dp));
        for (int i = 1; i < m; i++) {
            for (int j = weightBag; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[n - 1];
    }

    @Test
    public void test() {
        System.out.println(bagProblem(new int[]{1, 3, 4}, new int[]{15, 20, 30}, 4));
        System.out.println(bagProblem2(new int[]{1, 3, 4}, new int[]{15, 20, 30}, 4));
        System.out.println(bagProblem3(new int[]{1, 3, 4}, new int[]{15, 20, 30}, 4));
    }

}
