import java.util.ArrayList;
/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 *
 * https://leetcode.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (52.06%)
 * Likes:    2722
 * Dislikes: 85
 * Total Accepted:    430.7K
 * Total Submissions: 827.2K
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a
 * target number (target), find all unique combinations in candidates where the
 * candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of
 * times.
 *
 * Note:
 *
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 *
 * Example 1:
 *
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * ⁠ [7],
 * ⁠ [2,2,3]
 * ]
 *
 *
 * Example 2:
 *
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 *
 *
 */
import java.util.LinkedList;
import java.util.List;

// @lc code=start
class Solution {

  List<List<Integer>> ans = new LinkedList<>();
  LinkedList<Integer> track = new LinkedList<>();
  int trackSum = 0;

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    if (candidates.length == 0) {
      return ans;
    }
    backtrack(candidates, 0, target);
    return ans;
  }

  private void backtrack(int[] candidates, int start, int target) {
    if (trackSum == target) {
      ans.add(new LinkedList<>(track));
      return;
    }
    if (trackSum > target) {
      return;
    }

    for (int i = start; i < candidates.length; i++) {
      trackSum += candidates[i];
      track.addLast(candidates[i]);
      backtrack(candidates, i, target);
      trackSum -= candidates[i];
      track.removeLast();
    }
  }
}
// @lc code=end
