package com.song.algorithm.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * <p>
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * <p>
 * 限制：
 * <p>
 * 1 <= target <= 10^5
 */
public class Offer57_II_FindContinuousSequence {

    /**
     * 滑动窗口
     * 时间复杂度 O(n)
     * 空间复杂度 O(1) (忽略结果空间)
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        if (target < 3) {
            return null;
        }
        List<int[]> res = new ArrayList<>();
        for (int left = 1, right = 2, sum = left + right; left < right; ) {
            if (sum == target) {
                int[] item = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    item[i - left] = i;
                }
                res.add(item);
                sum += ++right;
            } else if (sum < target) {
                sum += ++right;
            } else {
                sum -= left++;
            }
            System.out.println(left + ", " + right);
        }
        return res.toArray(new int[res.size()][]);
    }

    @Test
    public void test() {
        for (int[] item : findContinuousSequence(15)) {
            System.out.println(Arrays.toString(item));
        }
    }

}
