package com.song.algorithm.dp;

import org.junit.Test;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * <p>
 * 提示：
 * <p>
 * 0 <= num < 231
 */
public class Offer46_TranslateNum {

    /**
     * 两个数字连续或者不连续
     * 1. dp[i] 表示从 num 的 0 到 i 位翻译的种数
     * 2. dp[i] = dp[i-1] + (9<num[i-1]*10+num[i]<26?dp[i-2]:0)
     * 3. 从前向后遍历
     * 4. dp[-1] = 1, dp[0] = 1
     * 5. 推导 dp 数组，1 2 3 5 5
     *
     * @param num
     * @return
     */
    public int translateNum(int num) {
        String src = String.valueOf(num);
        int p = 1, q = 1;
        for (int i = 1; i < src.length(); ++i) {
            int temp;
            String pre = src.substring(i - 1, i + 1);
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                temp = p + q;
            } else {
                temp = q;
            }
            p = q;
            q = temp;
        }
        return q;
    }

    public int translateNum2(int num) {
        String src = String.valueOf(num);
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < src.length(); ++i) {
            p = q;
            q = r;
            r = 0;
            r += q;
            if (i == 0) {
                continue;
            }
            String pre = src.substring(i - 1, i + 1);
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                r += p;
            }
        }
        return r;
    }

    @Test
    public void test() {
        System.out.println(translateNum(12258));
        System.out.println(translateNum2(12258));
    }

}
