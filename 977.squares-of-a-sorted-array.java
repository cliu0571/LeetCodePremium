/*
 * @lc app=leetcode id=977 lang=java
 *
 * [977] Squares of a Sorted Array
 *
 * https://leetcode.com/problems/squares-of-a-sorted-array/description/
 *
 * algorithms
 * Easy (72.16%)
 * Likes:    1305
 * Dislikes: 92
 * Total Accepted:    270.3K
 * Total Submissions: 374.7K
 * Testcase Example:  '[-4,-1,0,3,10]'
 *
 * Given an array of integers A sorted in non-decreasing order, return an array
 * of the squares of each number, also in sorted non-decreasing order.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A is sorted in non-decreasing order.
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int right = 0;
        // find the partion of neg/pos numbers
        while (right < n && A[right] < 0) {
            right++;
        }
        int left = right - 1;
        int[] ans = new int[n];
        int curr = 0;
        while (left >= 0 && right < n) {
            if (A[left] * A[left] < A[right] * A[right]) {
                ans[curr++] = A[left] * A[left];
                left--;
            } else {
                ans[curr++] = A[right] * A[right];
                right++;
            }
        }
        while (left >= 0) {
            ans[curr++] = A[left] * A[left];
            left--;
        }
        while (right < n) {
            ans[curr++] = A[right] * A[right];
            right++;
        }
        return ans;
    }
}
// @lc code=end
