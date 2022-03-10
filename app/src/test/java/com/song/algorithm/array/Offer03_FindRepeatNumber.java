package com.song.algorithm.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * <p>
 * 找出数组中重复的数字。
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *  
 * <p>
 * 限制：
 * <p>
 * 2 <= n <= 100000
 */
public class Offer03_FindRepeatNumber {

    /**
     * 用当前数据存储数据
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i]) {
                continue;
            }
            if (nums[i] == nums[nums[i]]) {
                return nums[i];
            }
            int temp = nums[i];
            nums[i] = nums[nums[i]];
            nums[temp] = temp;
            System.out.println(Arrays.toString(nums));
        }
        return nums[nums.length - 1];
    }

    /**
     * 哈希表
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return nums[nums.length - 1];
    }

    @Test
    public void test() {
        System.out.println(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
        System.out.println(findRepeatNumber2(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}
