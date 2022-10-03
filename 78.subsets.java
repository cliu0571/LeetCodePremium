import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.prefs.BackingStoreException;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms
 * Medium (56.62%)
 * Likes:    2633
 * Dislikes: 62
 * Total Accepted:    452.4K
 * Total Submissions: 799K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 *
 */

// @lc code=start
class Solution {

  List<List<Integer>> ans = new LinkedList<>();
  LinkedList<Integer> track = new LinkedList<>();

  public List<List<Integer>> subsets(int[] nums) {
    backtrack(nums, 0);
    return ans;
  }

  private void backtrack(int[] nums, int start) {
    ans.add(new LinkedList<>(track));
    for (int i = start; i < nums.length; i++) {
      track.addLast(nums[i]);
      backtrack(nums, i + 1);
      track.removeLast();
    }
  }
}
// @lc code=end
