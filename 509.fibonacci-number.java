/*
 * @lc app=leetcode id=509 lang=java
 *
 * [509] Fibonacci Number
 *
 * https://leetcode.com/problems/fibonacci-number/description/
 *
 * algorithms
 * Easy (66.63%)
 * Likes:    387
 * Dislikes: 175
 * Total Accepted:    138.2K
 * Total Submissions: 207K
 * Testcase Example:  '2'
 *
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the
 * Fibonacci sequence, such that each number is the sum of the two preceding
 * ones, starting from 0 and 1. That is,
 * 
 * 
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), for N > 1.
 * 
 * 
 * Given N, calculate F(N).
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 0 ≤ N ≤ 30.
 * 
 */

// @lc code=start
class Solution {
    public int fib(int N) {
        if (N < 2) {
            return N;
        }
        // ans_i_1 -> ans[i-1]
        // ans_i_2 -> ans[i-2]
        int ans_i_1 = 1, ans_i_2 = 0;
        for (int i = 2; i < N + 1; i++) {
            int ans_i = ans_i_1 + ans_i_2;
            ans_i_2 = ans_i_1;
            ans_i_1 = ans_i;
        }
        return ans_i_1;
    }
}
// @lc code=end
