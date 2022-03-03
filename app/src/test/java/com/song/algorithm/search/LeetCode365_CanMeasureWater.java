package com.song.algorithm.search;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * 365. 水壶问题
 * https://leetcode-cn.com/problems/water-and-jug-problem/
 *
 * 有两个水壶，容量分别为 jug1Capacity 和 jug2Capacity 升。水的供应是无限的。确定是否有可能使用这两个壶准确得到 targetCapacity 升。
 *
 * 如果可以得到 targetCapacity 升水，最后请用以上水壶中的一或两个来盛放取得的 targetCapacity 升水。
 *
 * 你可以：
 *
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 *  
 *
 * 示例 1: 
 *
 * 输入: jug1Capacity = 3, jug2Capacity = 5, targetCapacity = 4
 * 输出: true
 * 解释：来自著名的 "Die Hard"
 * 示例 2:
 *
 * 输入: jug1Capacity = 2, jug2Capacity = 6, targetCapacity = 5
 * 输出: false
 * 示例 3:
 *
 * 输入: jug1Capacity = 1, jug2Capacity = 2, targetCapacity = 3
 * 输出: true
 *  
 *
 * 提示:
 *
 * 1 <= jug1Capacity, jug2Capacity, targetCapacity <= 106
 *
 */
public class LeetCode365_CanMeasureWater {

    /**
     * 深度优先搜索
     *
     * 时间复杂度 O(xy)
     * 空间复杂度 O(xy)
     *
     * @param jug1Capacity
     * @param jug2Capacity
     * @param targetCapacity
     * @return
     */
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity < targetCapacity) {
            return false;
        }
        if (jug1Capacity == 0 || jug2Capacity == 0) {
            return targetCapacity == 0 || targetCapacity + jug2Capacity == targetCapacity;
        }
        LinkedList<int[]> stack = new LinkedList<int[]>(){{
            add(new int[]{0, 0});
        }};
        HashSet<Long> set = new HashSet<>();
        while (!stack.isEmpty()) {
            if (set.contains(hash(stack.peek()))) {
                stack.pop();
                continue;
            }
            int[] pop = stack.pop();
            set.add(hash(pop));
            int remain_x = pop[0];
            int remain_y = pop[1];
            if (remain_x == targetCapacity || remain_y == targetCapacity || remain_x + remain_y == targetCapacity) {
                return true;
            }
            stack.push(new int[]{0, remain_y});
            stack.push(new int[]{remain_x, 0});
            stack.push(new int[]{jug1Capacity, remain_y});
            stack.push(new int[]{remain_x, jug2Capacity});
            // 从 x 中导倒入 y 中，直至 y 倒满或者 x 到空
            stack.push(new int[]{remain_x - Math.min(remain_x, jug2Capacity - remain_y), remain_y + Math.min(remain_x, jug2Capacity - remain_y)});
            // 从 y 中导倒入 x 中，直至 x 倒满或者 y 到空
            stack.push(new int[]{remain_x + Math.min(remain_y, jug1Capacity - remain_x), remain_y - Math.min(remain_y, jug1Capacity - remain_x)});
        }
        return false;
    }

    private long hash(int[] arr) {
        return (long) arr[0] * 10001 + arr[1];
    }

    /**
     * 贝祖定理
     *
     * 时间复杂度 O(log(min(x,y)))
     * 空间复杂度 O(1)
     *
     * @param jug1Capacity
     * @param jug2Capacity
     * @param targetCapacity
     * @return
     */
    public boolean canMeasureWater2(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity < targetCapacity) {
            return false;
        } else if (jug1Capacity == 0 || jug2Capacity == 0) {
            return targetCapacity == 0 || jug1Capacity + jug2Capacity == targetCapacity;
        } else {
            return targetCapacity % gcd(jug1Capacity, jug2Capacity) == 0;
        }
    }

    /**
     * 求最大公约数
     * @param x
     * @param y
     * @return
     */
    private int gcd(int x, int y) {
        int temp = x % y;
        while (temp != 0) {
            x = y;
            y = temp;
            temp = x % y;
        }
        return y;
    }

    @Test
    public void test() {
        System.out.println(canMeasureWater(3, 5, 9));
        System.out.println(canMeasureWater2(3, 5, 9));
    }

}
