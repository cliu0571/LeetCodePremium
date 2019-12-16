/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 *
 * https://leetcode.com/problems/sqrtx/description/
 *
 * algorithms
 * Easy (32.50%)
 * Likes:    968
 * Dislikes: 1607
 * Total Accepted:    449.8K
 * Total Submissions: 1.4M
 * Testcase Example:  '4'
 *
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x, where x is guaranteed to be a
 * non-negative integer.
 * 
 * Since the return type is an integer, the decimal digits are truncated and
 * only the integer part of the result is returned.
 * 
 * Example 1:
 * 
 * 
 * Input: 4
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since 
 * the decimal part is truncated, 2 is returned.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        // return ans1(x);
        return ans2(x);
    }

    // root = e^1/2log(x)
    private int ans1(int x) {
        if (x < 2)
            return x;
        int left = (int) Math.pow(Math.E, Math.log(x) / 2);
        int right = left + 1;
        return right * right > x ? left : right;
    }

    // binary search
    private int ans2(int x) {
        if (x < 2)
            return x;
        int left = 2, right = x / 2;
        int mid;
        long square;
        while (left <= right) {
            mid = left + (right - left) / 2;
            square = (long) mid * mid;
            if (square < x) {
                left = mid + 1;
            } else if (x < square) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return right;
    }
}
// @lc code=end
