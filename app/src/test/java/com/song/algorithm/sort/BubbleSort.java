package com.song.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://www.runoob.com/w3cnote/bubble-sort.html
 */
public class BubbleSort {

    /**
     * 冒泡排序
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
     * @param nums
     * @return
     */
    public int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return nums;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(bubbleSort(new int[]{6, 5, 4, 3, 2, 1})));
    }

}
