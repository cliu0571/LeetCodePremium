import java.util.ArrayList;
import java.util.LinkedList;
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
    List<List<Integer>> ans = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean used[] = new boolean[nums.length];
        backtrack(nums, track, used);
        return ans;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        if (track.size() == nums.length) {
            ans.add(new LinkedList<Integer>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // skip used elements
            if (used[i]) {
                continue;
            }
            track.add(nums[i]);
            used[i]=true;
            backtrack(nums, track, used);
            track.removeLast();
            used[i] = false;
        }
    }

}
// @lc code=end
