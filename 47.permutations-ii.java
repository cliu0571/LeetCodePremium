import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
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

  List<List<Integer>> ans = new LinkedList<>();
  LinkedList<Integer> track = new LinkedList<>();
  boolean[] used;

  public List<List<Integer>> permuteUnique(int[] nums) {
    used = new boolean[nums.length];
    Arrays.sort(nums);
    backtrack(nums);
    return ans;
  }

  private void backtrack(int[] nums) {
    if (track.size() == nums.length) {
      ans.add(new LinkedList<>(track));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (used[i]) {
        continue;
      }

      // !used[i-1]: e.g. [1,2,2']-> 2' be selected only if 2 is used
      if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
        continue;
      }

      used[i] = true;
      track.addLast(nums[i]);
      backtrack(nums);
      used[i] = false;
      track.removeLast();
    }
  }
}
// @lc code=end
