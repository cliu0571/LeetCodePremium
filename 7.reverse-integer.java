/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 *
 * https://leetcode.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (25.57%)
 * Likes:    2667
 * Dislikes: 4160
 * Total Accepted:    886.9K
 * Total Submissions: 3.5M
 * Testcase Example:  '123'
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * 
 * 
 * Input: 123
 * Output: 321
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -123
 * Output: -321
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 120
 * Output: 21
 * 
 * 
 * Note:
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose
 * of this problem, assume that your function returns 0 when the reversed
 * integer overflows.
 * 
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        long n = 0; // to bit

        while (x != 0) {
            n = n * 10 + x % 10;
            x /= 10;
        }
        if (n < Integer.MIN_VALUE || n > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) n;
    }
}
// @lc code=end
