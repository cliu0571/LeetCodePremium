/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 *
 * https://leetcode.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (45.92%)
 * Likes:    5125
 * Dislikes: 94
 * Total Accepted:    396.1K
 * Total Submissions: 861K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped. Thanks
 * Marcos for contributing this image!
 * 
 * Example:
 * 
 * 
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * 
 */

// @lc code=start
class Solution {
    /** Time=O(n) Space=O(1) */
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        int lMax = height[0], rMax = height[height.length - 1];
        int ans = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                lMax = Math.max(lMax, height[left]);
                ans += lMax - height[left];
                left++;
            } else {
                rMax = Math.max(rMax, height[right]);
                ans += rMax - height[right];
                right--;
            }
        }
        return ans;
    }

    /** solution2: dynamic programming Time = O(n) Space = O(n) */
    public int trap_dp(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int length = height.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int lMax = height[0];
        int rMax = height[length - 1];

        for (int i = 0; i <= length - 1; i++) {
            lMax = Math.max(lMax, height[i]);
            left[i] = lMax;
        }
        for (int i = length - 1; i >= 0; i--) {
            rMax = Math.max(rMax, height[i]);
            right[i] = rMax;
        }
        int ans = 0;
        for (int i = 0; i < length; i++) {
            int max = Math.min(left[i], right[i]);
            if (max > height[i]) {
                ans += max - height[i];
            }
        }
        return ans;
    }
}
// @lc code=end
