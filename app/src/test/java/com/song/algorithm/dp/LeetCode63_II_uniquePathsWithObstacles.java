package com.song.algorithm.dp;

import org.junit.Test;

/**
 * 63. 不同路径 II
 * https://leetcode-cn.com/problems/unique-paths-ii
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 示例 1：
 * <p>
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * 示例 2：
 * <p>
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] 为 0 或 1
 */
public class LeetCode63_II_uniquePathsWithObstacles {

    /**
     * 动态规划
     * 1. dp[i][j] 表示在 i j 位置所有路径
     * 2. dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * 3. 遍历方向从前到后
     * 4. 初识值 dp[i][0] = 1, dp[0][j] = 1
     * 5. 推导 dp[i][j]
     * TODO 初始化第一行和第一列出现障碍物则后续都为 0
     * 时间复杂度 O(m*n)
     * 空间复杂度 O(m*n)
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 动态规划
     * 1. dp[i] 表示在 j 行 i 列位置所有路径
     * 2. dp[i] += dp[i-1] 条件若有障碍物则为 0，否则 i>0 且i-1 没有障碍物
     * 3. 遍历方向从前到后
     * 4. 初识值 dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0
     * 5. 推导 dp[i][j]
     * TODO 初始化第一行和第一列出现障碍物则后续都为 0
     * 时间复杂度 O(m*n)
     * 空间复杂度 O(m*n)
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];

        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                    continue;
                }
                if (j >= 1 && obstacleGrid[i][j - 1] == 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }

    @Test
    public void test() {
        System.out.println(uniquePathsWithObstacles(new int[][]{{1}, {1}, {0}}));
        System.out.println(uniquePathsWithObstacles2(new int[][]{{1}, {1}, {0}}));
    }

}
