package com.song.algorithm.array;

import org.junit.Test;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * <p>
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= 数组长度 <= 10000
 */
public class Offer53_II_MissingNumber {

    /**
     * 二分查找
     * 时间复杂度 O(log(n))
     * 空间复杂度 O(1)
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    @Test
    public void test() {
        System.out.println(missingNumber(new int[]{0, 1}));
        System.out.println(missingNumber(new int[]{0, 1, 3}));
        System.out.println(missingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9}));
    }
}
