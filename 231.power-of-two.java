/*
 * @lc app=leetcode id=231 lang=java
 *
 * [231] Power of Two
 *
 * https://leetcode.com/problems/power-of-two/description/
 *
 * algorithms
 * Easy (42.60%)
 * Likes:    561
 * Dislikes: 149
 * Total Accepted:    260.8K
 * Total Submissions: 612.1K
 * Testcase Example:  '1'
 *
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * Example 1:
 * 
 * 
 * Input: 1
 * Output: true 
 * Explanation: 2^0 = 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 16
 * Output: true
 * Explanation: 2^4 = 16
 * 
 * Example 3:
 * 
 * 
 * Input: 218
 * Output: false
 * 
 */

// @lc code=start
/**
 * x = 4      -> 0 0 0 0 0 1 0 0
 * -x = ~x+1  -> 1 1 1 1 1 1 0 0
 * x & -x     -> 0 0 0 0 0 1 0 0
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;
        long x = (long) n;
        return (x & (-x)) == x;
    }
}
// @lc code=end
