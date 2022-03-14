package com.song.algorithm.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * 62. 不同路径
 * https://leetcode-cn.com/problems/unique-paths
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 3, n = 7
 * 输出：28
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * 示例 3：
 * <p>
 * 输入：m = 7, n = 3
 * 输出：28
 * 示例 4：
 * <p>
 * 输入：m = 3, n = 3
 * 输出：6
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 109
 */
public class LeetCode62_UniquePaths {

    /**
     * 动态规划
     * 1. dp[i][j] 表示在 i j 位置所有路径
     * 2. dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * 3. 遍历方向从前到后
     * 4. 初识值 dp[i][0] = 1, dp[0][j] = 1
     * 5. 推导 dp[i][j]
     * 时间复杂度 O(m*n)
     * 空间复杂度 O(m*n)
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        // 打印 dp 数组
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 动态规划，滚动数组
     * 1. dp[i] 表示在 j 行 第 i 列位置所有路径
     * 2. dp[i] = dp[i] + dp[i-1]
     * 3. 遍历方向从前到后
     * 4. 初识值 dp[i] = 1
     * 5. 推导 dp[i]
     * 时间复杂度 O(m*n)
     * 空间复杂度 O(n)
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        System.out.println(Arrays.toString(dp));
        for (int j = 1; j < m; j++) {
            for (int i = 1; i < n; i++) {
                dp[i] += dp[i - 1];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[n - 1];
    }

    /**
     * 深度优先搜索
     * 时间复杂度 O(2(m+n-1))
     * 空间间复杂度 O(2(m+n-1))
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths3(int m, int n) {
        return recursive(1, 1, m, n);
    }

    private int recursive(int i, int j, int m, int n) {
        if (i > m || j > n) {
            return 0;
        }
        if (i == m & j == n) {
            return 1;
        }
        return recursive(i + 1, j, m, n) + recursive(i, j + 1, m, n);
    }

    /**
     * 排列组合求解 C(m-1)(m+n-2) =
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths4(int m, int n) {
        long numerator = 1; // 分子
        int denominator = m - 1; // 分母
        int count = m - 1;
        int t = m + n - 2;
        while ((count--) > 0) {
            numerator *= (t--);
            while (denominator != 0 && numerator % denominator == 0) {
                numerator /= denominator;
                denominator--;
            }
        }
        return (int) numerator;
    }

    @Test
    public void test() {
//        System.out.println(uniquePaths(100, 100));
        System.out.println(uniquePaths2(20, 20));
        System.out.println(uniquePaths3(3, 7));
        System.out.println(uniquePaths4(3, 7));
    }

}
