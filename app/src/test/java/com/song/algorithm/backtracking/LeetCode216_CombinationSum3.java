package com.song.algorithm.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 216. 组合总和 III
 * https://leetcode-cn.com/problems/combination-sum-iii/
 * <p>
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * <p>
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * <p>
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 解释:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * 没有其他符合的组合了。
 * 示例 3:
 * <p>
 * 输入: k = 4, n = 1
 * 输出: []
 * 解释: 不存在有效的组合。
 * 在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
 * <p>
 * 提示:
 * <p>
 * 2 <= k <= 9
 * 1 <= n <= 60
 */
public class LeetCode216_CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking2(k, n, 0, 1);
        return result;
    }

    private final LinkedList<Integer> path = new LinkedList<>();
    private final List<List<Integer>> result = new ArrayList<>();

    private void backtracking(int k, int n, int sum, int startIndex) {
        if (path.size() == k) {
            if (sum == n) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = startIndex; i <= 9; i++) {
            path.addLast(i);
            sum += i;
            backtracking(k, n, sum, i + 1);
            int last = path.pollLast();
            sum -= last;
        }
    }

    /**
     * 剪枝操作
     *
     * @param k
     * @param n
     * @param sum
     * @param startIndex
     */
    private void backtracking2(int k, int n, int sum, int startIndex) {
        if (sum > n) {
            return;
        }
        if (path.size() == k) {
            if (sum == n) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.addLast(i);
            sum += i;
            backtracking(k, n, sum, i + 1);
            int last = path.pollLast();
            sum -= last;
        }
    }

    @Test
    public void test() {
        List<List<Integer>> list = combinationSum3(3, 9);
        for (List<Integer> item : list) {
            System.out.println(Arrays.toString(item.toArray()));
        }
    }

}
