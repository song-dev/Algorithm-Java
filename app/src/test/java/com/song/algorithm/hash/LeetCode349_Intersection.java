package com.song.algorithm.hash;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 349. 两个数组的交集
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * <p>
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 */
public class LeetCode349_Intersection {

    /**
     * 时间复杂度 O(n+m)
     * 空间复杂度 O(n+m)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> targetSet = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            targetSet.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (targetSet.contains(nums2[i])) {
                resultSet.add(nums2[i]);
            }
        }
        int[] arr = new int[resultSet.size()];
        int i = 0;
        for (Integer t : resultSet) {
            arr[i] = t;
            i++;
        }
        return arr;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

}
