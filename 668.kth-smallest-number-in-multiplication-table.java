import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=668 lang=java
 *
 * [668] Kth Smallest Number in Multiplication Table
 *
 * https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/description/
 *
 * algorithms
 * Hard (45.51%)
 * Likes:    534
 * Dislikes: 21
 * Total Accepted:    20.8K
 * Total Submissions: 45.7K
 * Testcase Example:  '3\n3\n5'
 *
 * 
 * Nearly every one have used the Multiplication Table. But could you find out
 * the k-th smallest number quickly from the multiplication table?
 * 
 * 
 * 
 * Given the height m and the length n of a m * n Multiplication Table, and a
 * positive integer k, you need to return the k-th smallest number in this
 * table.
 * 
 * 
 * Example 1:
 * 
 * Input: m = 3, n = 3, k = 5
 * Output: 
 * Explanation: 
 * The Multiplication Table:
 * 1    2    3
 * 2    4    6
 * 3    6    9
 * 
 * The 5-th smallest number is 3 (1, 2, 2, 3, 3).
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: m = 2, n = 3, k = 6
 * Output: 
 * Explanation: 
 * The Multiplication Table:
 * 1    2    3
 * 2    4    6
 * 
 * The 6-th smallest number is 6 (1, 2, 2, 3, 4, 6).
 * 
 * 
 * 
 * 
 * Note:
 * 
 * The m and n will be in the range [1, 30000].
 * The k will be in the range [1, m * n]
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = m * n;
        int mid = left;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (!isEnough(mid, m, n, k)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private boolean isEnough(int mid, int m, int n, int k) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(mid / i, n);
        }
        return count >= k;
    }
}
// @lc code=end
