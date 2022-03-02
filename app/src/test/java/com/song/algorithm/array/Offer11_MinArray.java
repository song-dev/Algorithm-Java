package com.song.algorithm.array;

import org.junit.Test;

/**
 * 旋转数组的最小数字
 * <p>
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * <p>
 * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为1。  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：[2,2,2,0,1]
 * 输出：0
 */
public class Offer11_MinArray {

    /**
     * 暴力搜索
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return numbers[i + 1];
            }
        }
        return numbers[0];
    }

    /**
     * 二分查找
     * 时间复杂度 O(log(n))
     * 空间复杂度 O(1)
     *
     * @param numbers
     * @return
     */
    public int minArray2(int[] numbers) {
        int left = 0, right = numbers.length - 1, mid = 0;
        // 判断条件 <= 和 < 都可以，因为最终退出循环的条件是 mid = 最小值下标
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[mid];
    }

    @Test
    public void test() {
        int[] numbers = {3, 4, 5, 1, 2};
        System.out.println(minArray(numbers));
        System.out.println(minArray2(numbers));
    }

}
