package com.song.algorithm.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 移动零
 * <p>
 * https://leetcode-cn.com/problems/move-zeroes/
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * <p>
 * 输入: nums = [0]
 * 输出: [0]
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *  
 * <p>
 * 进阶：你能尽量减少完成的操作次数吗？
 */
public class LeetCode283_MoveZeroes {

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * 快慢指针
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int i = 0, p = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                if (i != p) {
                    nums[p] = nums[i];
                    nums[i] = 0;
                }
                p++;
            }
            i++;
        }
    }

    @Test
    public void test() {
        int[] arr = {0, 3, 1, 2, 1, 3, 0, 5};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

}
