package com.song.algorithm.array;

import org.junit.Test;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * <p>
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 */
public class Offer53_Search {

    /**
     * 二分查找
     * 时间复杂度 O(log(n))
     * 空间复杂度 O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return rightIdx - leftIdx + 1;
        }
        return 0;
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     * 迭代
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                int p = i + 1;
                while (p < nums.length && nums[p] == target) {
                    p++;
                }
                return p - i;
            }
        }
        return 0;
    }

    @Test
    public void test() {
        System.out.println(search(new int[]{5, 7, 7, 8, 8, 10}, 8));
        System.out.println(search2(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }
}
