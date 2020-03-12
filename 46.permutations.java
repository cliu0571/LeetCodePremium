import java.util.ArrayList;
import java.util.List;
/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (58.90%)
 * Likes:    3150
 * Dislikes: 94
 * Total Accepted:    524.9K
 * Total Submissions: 867.1K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3]
 * Output:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfsHelper(ans, nums, 0);
        return ans;
    }

    private void dfsHelper(List<List<Integer>> ans, int[] nums, int start) {
        if (start == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums)
                temp.add(num);
            ans.add(temp);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            dfsHelper(ans, nums, start + 1);
            swap(nums, i, start);
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
// @lc code=end
