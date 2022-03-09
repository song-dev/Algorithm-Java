package com.song.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://www.runoob.com/w3cnote/selection-sort.html
 */
public class SelectionSort {

    /**
     * 选择排序
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
     * @param nums
     * @return
     */
    public int[] selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
        }
        return nums;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(selectionSort(new int[]{6, 5, 4, 3, 2, 1})));
    }

}
