import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=719 lang=java
 *
 * [719] Find K-th Smallest Pair Distance
 *
 * https://leetcode.com/problems/find-k-th-smallest-pair-distance/description/
 *
 * algorithms
 * Hard (30.23%)
 * Likes:    679
 * Dislikes: 23
 * Total Accepted:    24.7K
 * Total Submissions: 81.9K
 * Testcase Example:  '[1,3,1]\n1'
 *
 * Given an integer array, return the k-th smallest distance among all the
 * pairs. The distance of a pair (A, B) is defined as the absolute difference
 * between A and B. 
 * 
 * Example 1:
 * 
 * Input:
 * nums = [1,3,1]
 * k = 1
 * Output: 0 
 * Explanation:
 * Here are all the pairs:
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * Then the 1st smallest distance pair is (1,1), and its distance is 0.
 * 
 * 
 * 
 * Note:
 * 
 * 2 .
 * 0 .
 * 1 .
 * 
 * 
 */

// @lc code=start
class Solution {
    // Binary Search + sliding widown
    // T = O(NlogW + NlogN)
    // S = O(1)
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int lo = 0;
        int hi = nums[nums.length - 1] - nums[0];
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            int count = 0, left = 0;
            for (int right = 1; right < nums.length; right++) {
                while (nums[right] - nums[left] > mi)
                    left++;
                count += right - left;
            }
            // count = number of pairs with distance <= mi
            if (count >= k)
                hi = mi;
            else
                lo = mi + 1;
        }
        return lo;
    }
}
// @lc code=end
