import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 *
 * https://leetcode.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (43.27%)
 * Likes:    1596
 * Dislikes: 56
 * Total Accepted:    315.3K
 * Total Submissions: 710.7K
 * Testcase Example:  '[1,1,2]'
 *
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,1,2]
 * Output:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
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
        Set<Integer> appeared = new HashSet<>();
        for (int i = start; i < nums.length; ++i) {
            if (appeared.add(nums[i])) {
                swap(nums, start, i);
                dfsHelper(ans, nums, start + 1);
                swap(nums, start, i);
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
// @lc code=end
