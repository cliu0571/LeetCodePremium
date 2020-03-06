import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=119 lang=java
 *
 * [119] Pascal's Triangle II
 *
 * https://leetcode.com/problems/pascals-triangle-ii/description/
 *
 * algorithms
 * Easy (46.12%)
 * Likes:    590
 * Dislikes: 182
 * Total Accepted:    239.2K
 * Total Submissions: 518.2K
 * Testcase Example:  '3'
 *
 * Given a non-negative index k where k ≤ 33, return the k^th index row of the
 * Pascal's triangle.
 * 
 * Note that the row index starts from 0.
 * 
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it.
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output: [1,3,3,1]
 * 
 * 
 * Follow up:
 * 
 * Could you optimize your algorithm to use only O(k) extra space?
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] array = new Integer[rowIndex + 1];
        Arrays.fill(array, 0);
        array[0] = 1;
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                array[j] = array[j] + array[j - 1];
            }
        }
        return Arrays.asList(array);
    }
}
// @lc code=end
