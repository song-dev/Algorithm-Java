package com.song.algorithm.dp;

import org.junit.Test;

/**
 * 198. 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 * <p>
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 */
public class LeetCode198_Rob {

    /**
     * 1. dp[i] 表示第 i 位置最大不相邻和 dp[i]
     * 2. dp[i] = max(dp[i-1], dp[i-2] + nums[i])
     * 3. 初始化 dp[0] = nums[0], dp[1] = max[num[0], nums[1]]
     * 4. 从前到后遍历
     * 5. 推导 dp 数组
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int p = nums[0], q = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int temp = Math.max(q, p + nums[i]);
            p = q;
            q = temp;
        }
        return q;
    }

    @Test
    public void test() {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
    }

}
