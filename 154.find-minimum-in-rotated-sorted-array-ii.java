/*
 * @lc app=leetcode id=154 lang=java
 *
 * [154] Find Minimum in Rotated Sorted Array II
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
 *
 * algorithms
 * Hard (40.03%)
 * Likes:    607
 * Dislikes: 168
 * Total Accepted:    152K
 * Total Submissions: 379.7K
 * Testcase Example:  '[1,3,5]'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * 
 * Find the minimum element.
 * 
 * The array may contain duplicates.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,3,5]
 * Output: 1
 * 
 * Example 2:
 * 
 * 
 * Input: [2,2,2,0,1]
 * Output: 0
 * 
 * Note:
 * 
 * 
 * This is a follow up problem to Find Minimum in Rotated Sorted Array.
 * Would allow duplicates affect the run-time complexity? How and why?
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) { //[3,3,1,3]
        int left = 0, right = nums.length - 1;
        int mid = left;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]){
                right = mid;
            }else if (nums[mid] > nums[right]){
                left = mid + 1;
            }else{
                right--;
            }
        }
        return nums[left];
    }
}
// @lc code=end
