import java.util.ArrayList;
import java.util.Arrays;
/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 *
 * https://leetcode.com/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (44.58%)
 * Likes:    1342
 * Dislikes: 55
 * Total Accepted:    287.3K
 * Total Submissions: 629.5K
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
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
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * ⁠ [1, 7],
 * ⁠ [1, 2, 5],
 * ⁠ [2, 6],
 * ⁠ [1, 1, 6]
 * ]
 *
 *
 * Example 2:
 *
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
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

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    if (candidates.length == 0) return ans;
    Arrays.sort(candidates);
    backtrack(candidates, 0, target);
    return ans;
  }

  private void backtrack(int[] candidates, int start, int target) {
    if (trackSum == target) {
      ans.add(new LinkedList<>(track));
    }

    if (trackSum > target) {
      return;
    }

    for (int i = start; i < candidates.length; i++) {
      if (i > start && candidates[i] == candidates[i - 1]) {
        continue;
      }
      trackSum += candidates[i];
      track.addLast(candidates[i]);
      backtrack(candidates, i + 1, target);
      trackSum -= candidates[i];
      track.removeLast();
    }
  }
}
// @lc code=end
