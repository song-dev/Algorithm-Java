package com.song.algorithm.dp;

import org.junit.Test;

/**
 * 剑指 Offer 47. 礼物的最大价值
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof
 * <p>
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 * <p>
 * 提示：
 * <p>
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 */
public class Offer47_MaxValue {

    /**
     * 动态规划
     * 1. dp[i][j] 到 i j 位置最大礼物数字
     * 2. dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
     * 3. 初始值为 gird
     * 4. 遍历顺序为从前到后
     * 5. 推导 dp 数组
     * 时间复杂度 O(m*n)
     * 空间复杂度 O(m*n)
     *
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 动态规划
     * 1. dp[i][j] 到 i j 位置最大礼物数字
     * 2. dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
     * 3. 初始值为 gird
     * 4. 遍历顺序为从前到后
     * 5. 推导 dp 数组
     * 时间复杂度 O(m*n)
     * 空间复杂度 O(m*n)
     *
     * @param grid
     * @return
     */
    public int maxValue2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }

    @Test
    public void test() {
        System.out.println(maxValue(new int[][]{{1, 2, 3}, {3, 4, 5}, {3, 2, 4}}));
        System.out.println(maxValue2(new int[][]{{1, 2, 3}, {3, 4, 5}, {3, 2, 4}}));
    }

}
