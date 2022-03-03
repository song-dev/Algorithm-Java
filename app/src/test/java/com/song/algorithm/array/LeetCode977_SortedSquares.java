package com.song.algorithm.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 977. 有序数组的平方
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 * <p>
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 *  
 * <p>
 * 进阶：
 * <p>
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 */
public class LeetCode977_SortedSquares {

    /**
     * 先求值再排序
     * 时间复杂度 O(nlog(n))
     * 空间复杂度 O(1)
     *
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    /**
     * 双指针
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     * @param nums
     * @return
     */
    public int[] sortedSquares2(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1;
        int i = right;
        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[i] = (int) Math.pow(nums[left], 2);
                left++;
            } else {
                result[i] = (int) Math.pow(nums[right], 2);
                right--;
            }
            i--;
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(sortedSquares2(new int[]{-7, -3, 2, 3, 11})));
    }


}
