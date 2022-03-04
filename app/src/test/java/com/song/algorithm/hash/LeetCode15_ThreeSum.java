package com.song.algorithm.hash;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 15. 三数之和
 * https://leetcode-cn.com/problems/3sum/
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class LeetCode15_ThreeSum {

    /**
     * 哈希表后去重
     * 时间复杂度 O(n2)
     * 空间复杂度 O(n)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // 两数之和
        List<List<Integer>> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            map.clear();
            for (int j = i + 1; j < nums.length; j++) {
                int z = -nums[i] - nums[j];
                if (map.containsKey(z)) {
                    ArrayList<Integer> item = new ArrayList<>();
                    item.add(nums[i]);
                    item.add(z);
                    item.add(nums[j]);
                    list.add(item);
                } else {
                    // TODO 存在重复情况处理
                    map.put(nums[j], j);
                }
            }
        }
        // 对 list 去重处理
        HashSet<Long> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            long hash = hash(list.get(i));
            if (set.contains(hash)) {
                list.remove(i);
            } else {
                set.add(hash);
            }
        }
        return list;
    }

    private long hash(List<Integer> list) {
        Collections.sort(list);
        return (long) list.get(0) * 1001 + list.get(1) * 101 + list.get(2);
    }

    /**
     * 先排序后双指针
     * 时间复杂度 O(n2)
     * 空间复杂度 O(n)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            // 当 i 值相同，则必须去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if ((nums[i] + nums[left] + nums[right]) == 0) {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 当 i 相同，left 相同，则 right 必须去重
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // 当 i 相同，right 相同，则 left 必须去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    right--;
                    left++;
                } else if (((nums[i] + nums[left] + nums[right]) > 0)) {
                    // right 左移
                    right--;
                } else {
                    // left 右移
                    left++;
                }
            }
        }
        return list;
    }

    @Test
    public void test() {
        List<List<Integer>> list = threeSum2(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> item : list) {
            System.out.println(Arrays.toString(item.toArray(new Integer[0])));
        }
    }
}
