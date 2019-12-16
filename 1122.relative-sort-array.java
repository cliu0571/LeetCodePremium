/*
 * @lc app=leetcode id=1122 lang=java
 *
 * [1122] Relative Sort Array
 *
 * https://leetcode.com/problems/relative-sort-array/description/
 *
 * algorithms
 * Easy (66.59%)
 * Likes:    325
 * Dislikes: 23
 * Total Accepted:    32.3K
 * Total Submissions: 48.5K
 * Testcase Example:  '[2,3,1,3,2,4,6,7,9,2,19]\n[2,1,4,3,9,6]'
 *
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all
 * elements in arr2 are also in arr1.
 * 
 * Sort the elements of arr1 such that the relative ordering of items in arr1
 * are the same as in arr2.  Elements that don't appear in arr2 should be
 * placed at the end of arr1 in ascending order.
 * 
 * 
 * Example 1:
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 * 
 * 
 * Constraints:
 * 
 * 
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * Each arr2[i] is distinct.
 * Each arr2[i] is in arr1.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] bucket = new int[1001];
        int[] ans = new int[arr1.length];

        // record arr1 elements in bucket
        for (int num : arr1) {
            bucket[num]++;
        }

        // move arr2 elements to result
        int index = 0;
        for (int num : arr2) {
            while (bucket[num] > 0) {
                bucket[num]--;
                ans[index++] = num;
            }
        }

        // move remaining element from arr1 to result
        for (int num = 0; num < 1001; num++) {
            while (bucket[num]-- > 0) {
                ans[index++] = num;
            }
        }

        return ans;
    }
}
// @lc code=end
