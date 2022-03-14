package com.song.algorithm.dp;

import org.junit.Test;

/**
 * 343. 整数拆分
 * https://leetcode-cn.com/problems/integer-break/
 * <p>
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * <p>
 * 返回 你可以获得的最大乘积 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 * <p>
 * 输入: n = 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 2 <= n <= 58
 */
public class LeetCode343_IntegerBreak {

    /**
     * 动态规划
     * 1. dp[i] 表示 i 值拆分数最大乘积
     * 2. dp[i] = max(dp[i], max(j*(i-j),j*dp[i-j]))
     * 3. 初始化 dp[2] = 1
     * 4. 从前往后遍历
     * 5. 推导 dp 数组
     * 时间复杂度 O(n2)
     * 空间复杂度 O(n)
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    /**
     * 贪心算法
     * 每次拆成n个3，如果剩下是4，则保留4，然后相乘
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
     * @param n
     * @return
     */
    public int integerBreak2(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        int result = 1;
        while (n > 4) {
            result *= 3;
            n -= 3;
        }
        result *= n;
        return result;
    }

    @Test
    public void test() {
        System.out.println(integerBreak(10));
        System.out.println(integerBreak2(10));
    }

}
