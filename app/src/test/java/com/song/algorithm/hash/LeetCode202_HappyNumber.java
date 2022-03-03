package com.song.algorithm.hash;

import org.junit.Test;

import java.util.HashSet;

/**
 * 202. 快乐数
 * https://leetcode-cn.com/problems/happy-number/
 * <p>
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」 定义为：
 * <p>
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 231 - 1
 */
public class LeetCode202_HappyNumber {

    /**
     * 哈希表
     * 时间复杂度 O(log(n))
     * 空间复杂度 O(log(n))
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    /**
     * 快慢指针
     * 时间复杂度 O(log(n))
     * 空间复杂度 O(1)
     *
     * @param n
     * @return
     */
    public boolean isHappy2(int n) {
        int fast = getNext(n);
        int low = n;
        while (low != 1 && fast != low) {
            low = getNext(low);
            fast = getNext(getNext(fast));
        }
        return low == 1;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            sum += Math.pow(n % 10, 2);
            n = n / 10;
        }
        return sum;
    }

    @Test
    public void test() {
        System.out.println(isHappy(19));
        System.out.println(isHappy2(19));
    }

}
