package com.song.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://www.runoob.com/w3cnote/quick-sort-2.html
 */
public class QuickSort {

    /**
     * 快速排序优化版本
     *
     * @param nums
     * @param left
     * @param right
     */
    public int[] quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int i = left, j = right, s = nums[i];
            while (i < j) {
                while (i < j && s < nums[j]) {
                    j--;
                }
                if (i < j) {
                    nums[i++] = nums[j];
                }
                while (i < j && s >= nums[i]) {
                    i++;
                }
                if (i < j) {
                    nums[j--] = nums[i];
                }
            }
            nums[i] = s;
            System.out.println(Arrays.toString(nums));
            System.out.println("===" + i + "===");
            quickSort(nums, left, i - 1);
            quickSort(nums, i + 1, right);
        }
        return nums;
    }

    @Test
    public void test() {
        System.out.println("TEST: " + Arrays.toString(quickSort(new int[]{8, 7, 5, 6, 4, 3, 1, 2}, 0, 7)));
    }

}
